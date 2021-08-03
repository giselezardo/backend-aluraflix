package backendchallenge.aluraflix.controller;

import backendchallenge.aluraflix.controller.dto.VideoDto;
import backendchallenge.aluraflix.controller.form.AtualizaVideoForm;
import backendchallenge.aluraflix.controller.form.VideoForm;
import backendchallenge.aluraflix.model.Videos;
import backendchallenge.aluraflix.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;


    @GetMapping(path = "/{id}")
    public ResponseEntity <VideoDto> buscaPorId (@PathVariable Integer id){
        Optional<Videos> video = videoRepository.findById(id);

        if (video.isPresent()) {
            return ResponseEntity.ok(new VideoDto(video.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List <VideoDto> listaVideos () {
        List<Videos> videos = videoRepository.findAll();
        return VideoDto.converter(videos);
    }

    @PostMapping
    public ResponseEntity<VideoDto> cadastraVideo (@RequestBody @Valid VideoForm videoForm, UriComponentsBuilder uriBuilder){
        Videos videos = videoForm.converter();
        videoRepository.save(videos);
        URI uri = uriBuilder.path("videos/{id}").buildAndExpand(videos.getId()).toUri();
        return ResponseEntity.created(uri).body(new VideoDto(videos));

    }

    @PutMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<VideoDto> atualizaVideo (@PathVariable Integer id, @RequestBody @Valid AtualizaVideoForm videoAtualizadoForm){
        Optional <Videos> videoProcurado = videoRepository.findById(id);
         if (videoProcurado.isPresent()){
             Videos videos = videoAtualizadoForm.atualizar(id, videoRepository);
             return ResponseEntity.ok(new VideoDto(videos));
         }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<VideoDto> deletarVideo(@PathVariable Integer id){
        Optional<Videos> video = videoRepository.findById(id);

        if (video.isPresent()){
            videoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
