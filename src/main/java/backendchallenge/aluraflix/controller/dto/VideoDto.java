package backendchallenge.aluraflix.controller.dto;

import backendchallenge.aluraflix.model.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VideoDto {

    public Integer id;
    public String titulo;
    public String descricao;
    public String url;
    private Integer idCategoria;



    public static VideoDto converterParaDto(Video video) {
        return new VideoDto(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl(), video.getCategoria().getIdCategoria());
    }

    public static List<VideoDto> converterParaListaDto(List<Video> videos) {
        List<VideoDto> videoDtos = new ArrayList<>();

        videos.forEach((Video v) -> videoDtos.add(new VideoDto(v.getId(), v.getTitulo(), v.getDescricao(), v.getUrl(), v.getCategoria().getIdCategoria())));

        return videoDtos;
    }

}

