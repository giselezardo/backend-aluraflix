package backendchallenge.aluraflix.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VideoRequest {

    public Integer id;
    public String titulo;
    public String descricao;
    public String url;

}
