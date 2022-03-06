package backendchallenge.aluraflix.controller.form;

import backendchallenge.aluraflix.model.Categoria;
import backendchallenge.aluraflix.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CategoriaForm {

    private String tituloCategoria;
    private String corCategoria;

    public Categoria converterParaForm(CategoriaRepository categoriaRepository){
        return new Categoria(this.tituloCategoria, this.corCategoria);
    }

}
