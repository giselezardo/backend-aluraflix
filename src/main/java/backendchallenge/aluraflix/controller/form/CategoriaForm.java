package backendchallenge.aluraflix.controller.form;

import backendchallenge.aluraflix.model.Categorias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaForm {

    public Integer idCategoria;

    @NotBlank
    public String tituloCategoria;

    @NotBlank
    public String corCategoria;

    public Categorias converter(){
        return new Categorias (idCategoria,tituloCategoria,corCategoria);
    }
}
