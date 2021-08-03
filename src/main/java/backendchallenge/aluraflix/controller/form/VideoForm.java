package backendchallenge.aluraflix.controller.form;

import backendchallenge.aluraflix.model.Categorias;
import backendchallenge.aluraflix.model.Videos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

//dados que chegam do cliente pra API

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoForm {

    public Integer id;

    @NotBlank
    public String titulo;

    @NotBlank
    public String descricao;

    @NotBlank
    public String url;

    @NotBlank
    public Categorias categorias;

    public Videos converter() {
        return new Videos(id, titulo, descricao, url, categorias);
    }

}
