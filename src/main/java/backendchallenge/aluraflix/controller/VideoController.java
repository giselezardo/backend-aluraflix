package backendchallenge.aluraflix.controller;

import backendchallenge.aluraflix.controller.dto.VideoDto;
import backendchallenge.aluraflix.controller.form.AtualizaVideoForm;
import backendchallenge.aluraflix.controller.form.VideoForm;
import backendchallenge.aluraflix.model.Video;
import backendchallenge.aluraflix.repository.CategoriaRepository;
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

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping(path = "/{id}")
    public ResponseEntity<VideoDto> buscarPorId(@PathVariable Integer id) {
        Optional<Video> video = videoRepository.findById(id);

        return video.map(value -> ResponseEntity.ok
                        (new VideoDto(
                                video.get().getId(),
                                video.get().getTitulo(),
                                video.get().getDescricao(),
                                video.get().getUrl(),
                                video.get().getCategoria().getIdCategoria())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<VideoDto> listarVideos() {
        List<Video> videos = videoRepository.findAll();
        return VideoDto.converterParaListaDto(videos);
    }

    @PostMapping
    public ResponseEntity<VideoDto> cadastrarVideo(@RequestBody @Valid VideoForm videoForm, UriComponentsBuilder uriBuilder) {
        Video video = videoForm.converter(videoRepository, categoriaRepository);
        videoRepository.save(video);
        URI uri = uriBuilder.path("videos/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(VideoDto.converterParaDto(video));
    }

    @PutMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<VideoDto> atualizarVideo(@PathVariable Integer id, @RequestBody @Valid AtualizaVideoForm videoAtualizadoForm) {
        Optional<Video> videoProcurado = videoRepository.findById(id);
        if (videoProcurado.isPresent()) {
            Video video = videoAtualizadoForm.atualizar(id, videoRepository);
            return ResponseEntity.ok(new VideoDto());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<VideoDto> deletarVideo(@PathVariable Integer id) {
        Optional<Video> video = videoRepository.findById(id);

        if (video.isPresent()) {
            videoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
