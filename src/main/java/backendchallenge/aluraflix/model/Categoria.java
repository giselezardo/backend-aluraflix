package backendchallenge.aluraflix.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Categoria")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idCategoria;

    @Column(nullable = false)
    public String tituloCategoria;

    @Column(nullable = false)
    public String corCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<Video> video;

}
