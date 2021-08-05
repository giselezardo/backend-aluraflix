package backendchallenge.aluraflix.repository;

import backendchallenge.aluraflix.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {

}
