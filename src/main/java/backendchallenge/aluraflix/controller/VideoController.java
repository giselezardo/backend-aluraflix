package backendchallenge.aluraflix.controller;

import backendchallenge.aluraflix.model.Video;
import backendchallenge.aluraflix.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping(path = "/aluraflix/video/{id}")
    public ResponseEntity <Video> buscaPorId(@PathVariable Integer id){
        Video video = videoService.buscarPorId(id);
        return ResponseEntity.ok().body(video);
    }

    @GetMapping(path = "/aluraflix/video")
    public ResponseEntity <?> listaVideo () {
        List<Video> listaVideo = videoService.listar();
        return ResponseEntity.ok().body(listaVideo);
    }

    @PostMapping(path = "/aluraflix/video/inserir")
    public ResponseEntity <Void> inserirVideo (@RequestBody Video video) {
        video = videoService.inserir(video);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(video.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/aluraflix/video/{id}")
    public ResponseEntity<Video> deletarVideo(@PathVariable Integer id){
        videoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
