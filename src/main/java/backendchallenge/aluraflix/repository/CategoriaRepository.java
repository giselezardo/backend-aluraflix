package backendchallenge.aluraflix.repository;

import backendchallenge.aluraflix.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categorias, Integer> {


}
