package backendchallenge.aluraflix.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Table(name = "perfil")
@Entity
public class Perfil implements GrantedAuthority {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Override
    public String getAuthority() {
        return nome;
    }
}