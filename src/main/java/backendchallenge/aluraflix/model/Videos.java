package backendchallenge.aluraflix.model;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "videos")
public class Videos {

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
    public Categorias categorias;

}
