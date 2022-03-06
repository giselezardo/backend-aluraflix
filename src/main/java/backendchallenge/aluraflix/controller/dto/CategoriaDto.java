package backendchallenge.aluraflix.controller.dto;

import backendchallenge.aluraflix.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class CategoriaDto {

    private Integer idCategoria;
    private String tituloCategoria;
    private String corCategoria;

    public CategoriaDto(Categoria categoria) {
        this.idCategoria = categoria.getIdCategoria();
        this.tituloCategoria = categoria.getTituloCategoria();
        this.corCategoria = categoria.getCorCategoria();
    }

    public static List<CategoriaDto> converterParaDto(List <Categoria> categoria){
        return categoria.stream().map(CategoriaDto::new).collect(Collectors.toList());
    }

}
