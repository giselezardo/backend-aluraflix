package backendchallenge.aluraflix.service;

import backendchallenge.aluraflix.model.Video;
import backendchallenge.aluraflix.model.dto.VideoRequest;
import backendchallenge.aluraflix.model.dto.VideoResponse;
import backendchallenge.aluraflix.repository.VideoRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    private VideoRepository repository;

    public VideoResponse criarVideo (VideoRequest videoRequest){

        Video video = Video.of(videoRequest);
        this.repository.save(video);

        return video.toDto();
    }
}
