package backendchallenge.aluraflix.controller.form;

import backendchallenge.aluraflix.model.Categoria;
import backendchallenge.aluraflix.repository.CategoriaRepository;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AtualizaCategoriaForm {

    @NotBlank
    private String tituloCategoria;

    @NotBlank
    private String corCategoria;

    public Categoria atualizar(Integer idCategoria, CategoriaRepository categoriaRepository) {
        Categoria categoria = categoriaRepository.getById(idCategoria);
        categoria.setTituloCategoria(this.tituloCategoria);
        categoria.setCorCategoria(this.corCategoria);
        return categoria;
    }
}
