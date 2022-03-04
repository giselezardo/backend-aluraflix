package backendchallenge.aluraflix.controller.form;

import backendchallenge.aluraflix.model.Video;
import backendchallenge.aluraflix.repository.VideoRepository;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AtualizaVideoForm {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    public Video atualizar(Integer id, VideoRepository videoRepository) {
        Video video = videoRepository.getById(id);
        video.setTitulo(this.titulo);
        video.setDescricao(this.descricao);
        return video;
    }
}
