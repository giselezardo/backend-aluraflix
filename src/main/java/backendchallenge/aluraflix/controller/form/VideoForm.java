package backendchallenge.aluraflix.controller.form;

import backendchallenge.aluraflix.model.Categoria;
import backendchallenge.aluraflix.model.Video;
import backendchallenge.aluraflix.repository.CategoriaRepository;
import backendchallenge.aluraflix.repository.VideoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoForm {

    private Integer idCategoria;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String url;

    public Video converter(VideoRepository videoRepository, CategoriaRepository categoriaRepository) {
        Categoria categoria = categoriaRepository.findById(idCategoria).get();
        return new Video(titulo, descricao, url, categoria);
    }

}
