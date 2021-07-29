package backendchallenge.aluraflix.controller;

import backendchallenge.aluraflix.controller.dto.VideoDto;
import backendchallenge.aluraflix.controller.form.VideoForm;
import backendchallenge.aluraflix.model.Video;
import backendchallenge.aluraflix.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/aluraflix/video")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;


    @GetMapping(path = "/{id}")
    public ResponseEntity <VideoDto> buscaPorId (@PathVariable Integer id){
        Optional<Video> video = videoRepository.findById(id);
        return ResponseEntity.ok(new VideoDto(video.get()));
    }

    @GetMapping
    public List <VideoDto> listaVideo () {
        List<Video> video = videoRepository.findAll();
        return VideoDto.converter(video);
    }

    @PostMapping
    public ResponseEntity<VideoDto> cadastraVideo(@RequestBody VideoForm videoForm, UriComponentsBuilder uriBuilder){
        Video video = videoForm.converter();
        videoRepository.save(video);
        URI uri = uriBuilder.path("/aluraflix/video/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(new VideoDto(video));

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<VideoDto> deletarVideo(@PathVariable Integer id){
        videoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
