package backendchallenge.aluraflix.repository;

import backendchallenge.aluraflix.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {


}
