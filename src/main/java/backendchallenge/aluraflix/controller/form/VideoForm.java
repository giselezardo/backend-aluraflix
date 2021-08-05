package backendchallenge.aluraflix.controller.form;

import backendchallenge.aluraflix.model.Categoria;
import backendchallenge.aluraflix.model.Video;
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

    public Categoria categoria;

    public Video converter() {
        return new Video(titulo, descricao, url, categoria);
    }

}
