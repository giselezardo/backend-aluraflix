package backendchallenge.aluraflix.repository;

import backendchallenge.aluraflix.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Integer> {

    List<Video> findByCategoria(Integer idCategoria);
}
