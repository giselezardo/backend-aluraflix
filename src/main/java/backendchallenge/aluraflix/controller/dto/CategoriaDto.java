package backendchallenge.aluraflix.controller.dto;

import backendchallenge.aluraflix.model.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class CategoriaDto {

    public Integer idCategoria;
    public String tituloCategoria;
    public String corCategoria;

    public CategoriaDto(Categoria categoria) {
        this.idCategoria = categoria.getIdCategoria();
        this.tituloCategoria = categoria.getTituloCategoria();
        this.corCategoria = categoria.getCorCategoria();
    }

    public static List<CategoriaDto> converter(List<Categoria> categoria) {
        return categoria.stream().map(CategoriaDto::new).collect(Collectors.toList());
    }
}
