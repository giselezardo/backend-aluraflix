package backendchallenge.aluraflix.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column
    private String tituloCategoria;

    @Column
    private String corCategoria;

    @OneToMany (mappedBy = "id")
    private List<Video> video;

    public Categoria() {
    }

    public Categoria(String tituloCategoria, String corCategoria) {
        this.tituloCategoria = tituloCategoria;
        this.corCategoria = corCategoria;
    }

    public Categoria(Integer idCategoria, String tituloCategoria, String corCategoria, List<Video> video) {
        this.idCategoria = idCategoria;
        this.tituloCategoria = tituloCategoria;
        this.corCategoria = corCategoria;
        this.video = video;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTituloCategoria() {
        return tituloCategoria;
    }

    public void setTituloCategoria(String tituloCategoria) {
        this.tituloCategoria = tituloCategoria;
    }

    public String getCorCategoria() {
        return corCategoria;
    }

    public void setCorCategoria(String corCategoria) {
        this.corCategoria = corCategoria;
    }

    public List<Video> getVideo() {
        return video;
    }

    public void setVideo(List<Video> video) {
        this.video = video;
    }
}
