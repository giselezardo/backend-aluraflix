package backendchallenge.aluraflix.model;


import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //valores atribuidos a chave primaria são gerados pela coluna de auto incremento do BD
    public Integer id;

    @Column(nullable = false)
    public String titulo;

    @Column(nullable = false)
    public String descricao;

    @Column(nullable = false)
    public String url;

    @ManyToOne
    Categoria categoria;

}
