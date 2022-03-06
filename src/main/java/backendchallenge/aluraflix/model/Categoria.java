package backendchallenge.aluraflix.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Categoria(String tituloCategoria, String corCategoria) {
        this.tituloCategoria = tituloCategoria;
        this.corCategoria = corCategoria;
    }

}
