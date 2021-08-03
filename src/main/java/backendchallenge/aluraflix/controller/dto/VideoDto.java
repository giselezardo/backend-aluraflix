package backendchallenge.aluraflix.controller.dto;

import backendchallenge.aluraflix.model.Videos;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

//dados que saem da API pro cliente

@Getter
@NoArgsConstructor
public class VideoDto {

    public Integer id;
    public String titulo;
    public String descricao;
    public String url;

    public VideoDto (Videos videos) {
        this.id = videos.getId();
        this.titulo = videos.getTitulo();
        this.descricao = videos.getDescricao();
        this.url = videos.getUrl();
    }

    public static List<VideoDto> converter(List<Videos> videos){
        return videos.stream().map(VideoDto::new).collect(Collectors.toList());
    }
}
