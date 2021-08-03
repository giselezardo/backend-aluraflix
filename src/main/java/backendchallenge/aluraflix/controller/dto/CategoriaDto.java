package backendchallenge.aluraflix.controller.dto;

import backendchallenge.aluraflix.model.Categorias;
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

    public CategoriaDto(Categorias categorias) {
        this.idCategoria = categorias.getIdCategoria();
        this.tituloCategoria = categorias.getTituloCategoria();
        this.corCategoria = categorias.getCorCategoria();
    }

    public static List<CategoriaDto> converter(List<Categorias> categorias) {
        return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
    }
}
