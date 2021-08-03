package backendchallenge.aluraflix.controller.form;

import backendchallenge.aluraflix.model.Categoria;
import backendchallenge.aluraflix.model.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class CategoriaForm {

    public Integer idCategoria;

    @NotBlank
    public String tituloCategoria;

    @NotBlank
    public String corCategoria;


}
