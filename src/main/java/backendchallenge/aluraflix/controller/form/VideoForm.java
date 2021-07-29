package backendchallenge.aluraflix.controller.form;

import backendchallenge.aluraflix.model.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//dados que chegam do cliente pra API

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoForm {

    public Integer id;

    public String titulo;

    public String descricao;

    public String url;

    public Video converter() {
        return new Video(id, titulo, descricao, url);
    }

}
