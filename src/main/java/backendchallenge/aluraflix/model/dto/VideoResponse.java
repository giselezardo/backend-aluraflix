package backendchallenge.aluraflix.model.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VideoResponse {

    public Integer id;
    public String titulo;
    public String descricao;
    public String url;

}
