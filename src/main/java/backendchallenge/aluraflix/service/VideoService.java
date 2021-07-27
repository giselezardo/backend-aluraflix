package backendchallenge.aluraflix.service;

import backendchallenge.aluraflix.model.Video;
import backendchallenge.aluraflix.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository repository;

    public Video buscarPorId (Integer id) {
        Optional<Video> video = repository.findById(id);
        return video.orElse(null);
    }

    public List<Video> listar () {
        return repository.findAll();
    }

    public Video inserir (Video video) {
        return repository.save(video);
    }

    public Video atualizar (Video video) {
        return repository.save(video);
    }

    public void deletar (Integer id) {
        repository.deleteById(id);
    }
}
