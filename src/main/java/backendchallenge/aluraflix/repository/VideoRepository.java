package backendchallenge.aluraflix.repository;

import backendchallenge.aluraflix.model.Videos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Videos, Integer> {

}
