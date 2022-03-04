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

    private Integer id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String url;

    public Categoria categoria;

    public Video converter() {
        return new Video(titulo, descricao, url, categoria);
    }

}
