package backendchallenge.aluraflix.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "Categorias")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idCategoria;

    @Column(nullable = false)
    public String tituloCategoria;

    @Column(nullable = false)
    public String corCategoria;

    @OneToMany(mappedBy = "categorias")
    private List<Videos> videos;

    public Categorias(Integer idCategoria, String tituloCategoria, String corCategoria) {
    }
}
