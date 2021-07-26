package backendchallenge.aluraflix.controller;

import backendchallenge.aluraflix.model.dto.VideoRequest;
import backendchallenge.aluraflix.model.dto.VideoResponse;
import backendchallenge.aluraflix.repository.VideoRepository;
import backendchallenge.aluraflix.model.Video;
import backendchallenge.aluraflix.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoController {

    VideoService videoService;

    @Autowired
    private VideoRepository repository;

//    @GetMapping(path = "/aluraflix/video/{id}")
//    //o getMapping vai consultar o video pelo id
//    public ResponseEntity consultar(@PathVariable("id") Integer id) {
//
//        return repository.findById(id)
//                .map(record -> ResponseEntity.ok().body(record))
//                .orElse(ResponseEntity.notFound().build());
//        //Se o método map retorna algo (os dados do video), ele vai trazer o ok e mudar o corpo da requisição com o record
//        //Caso contrário retorna o notFound
//    }

    @GetMapping(path = "/aluraflix/video")
    public ResponseEntity<List<Video>> listAllVideos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.repository.findAllVideos());
    }

    @PostMapping(path = "/aluraflix/video")
    public ResponseEntity<VideoResponse> entradaVideo(@RequestBody VideoRequest videoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.videoService.criarVideo(videoRequest));
    }
}
