package backendchallenge.aluraflix.controller.dto;

import backendchallenge.aluraflix.model.Video;
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

    public VideoDto (Video video) {
        this.id = video.getId();
        this.titulo = video.getTitulo();
        this.descricao = video.descricao;
        this.url = video.url;
    }

    public static List<VideoDto> converter(List<Video> video){
        return video.stream().map(VideoDto::new).collect(Collectors.toList());
    }
}
