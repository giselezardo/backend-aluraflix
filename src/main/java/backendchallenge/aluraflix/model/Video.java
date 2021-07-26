package backendchallenge.aluraflix.model;

import backendchallenge.aluraflix.model.dto.VideoRequest;
import backendchallenge.aluraflix.model.dto.VideoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //valores atribuidos a chave primaria são gerados pela coluna de auto incremento do BD
    public Integer id;

    @Column(nullable = false)
    public String titulo;

    @Column(nullable = false)
    public String descricao;

    @Column(nullable = false)
    public String url;

    public static Video of(VideoRequest videoRequest) {
        return Video.builder().titulo(videoRequest.getTitulo()).descricao(videoRequest.getDescricao())
                .url(videoRequest.getUrl()).build();

    }

    public VideoResponse toDto() {
        return VideoResponse.builder().id(this.id).titulo(this.titulo).descricao(this.descricao)
                .url(this.url).build();
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
