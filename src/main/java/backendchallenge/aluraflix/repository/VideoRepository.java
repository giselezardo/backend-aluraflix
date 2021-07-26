package backendchallenge.aluraflix.repository;

import backendchallenge.aluraflix.model.Video;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VideoRepository extends CrudRepository<Video, Integer> {

    @Query (value = "select new Video(v.id, v.titulo, v.descricao, v.url) from Video v")
    List<Video> findAllVideos();
}
