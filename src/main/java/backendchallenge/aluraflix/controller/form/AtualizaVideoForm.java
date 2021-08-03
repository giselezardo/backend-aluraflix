package backendchallenge.aluraflix.controller.form;

import backendchallenge.aluraflix.model.Videos;
import backendchallenge.aluraflix.repository.VideoRepository;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AtualizaVideoForm {

    @NotBlank
    public String titulo;

    @NotBlank
    public String descricao;

    public Videos atualizar(Integer id, VideoRepository videoRepository) {
        Videos videos = videoRepository.getById(id);
        videos.setTitulo(this.titulo);
        videos.setDescricao(this.descricao);
        return videos;
    }
}
