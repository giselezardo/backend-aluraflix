package backendchallenge.aluraflix.controller.dto;

import backendchallenge.aluraflix.model.Categoria;
import backendchallenge.aluraflix.model.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VideoDto {

    public Integer id;
    public String titulo;
    public String descricao;
    public String url;
    private Integer idCategoria;

    Categoria categoria;

    public VideoDto (Video video) {
        this.id = video.getId();
        this.titulo = video.getTitulo();
        this.descricao = video.getDescricao();
        this.url = video.getUrl();
        this.idCategoria = categoria.getIdCategoria();
    }

    public static List<VideoDto> converter(List<Video> videos){
        return videos.stream().map(VideoDto::new).collect(Collectors.toList());
    }
}
