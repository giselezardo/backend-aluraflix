package backendchallenge.aluraflix.controller;


import backendchallenge.aluraflix.controller.dto.CategoriaDto;
import backendchallenge.aluraflix.controller.dto.VideoDto;
import backendchallenge.aluraflix.controller.form.CategoriaForm;
import backendchallenge.aluraflix.model.Categoria;
import backendchallenge.aluraflix.model.Video;
import backendchallenge.aluraflix.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/aluraflix/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<CategoriaDto> listaCategorias(){
        List<Categoria> categoria = categoriaRepository.findAll();
        return CategoriaDto.converter(categoria);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoriaDto> buscaPorId (@PathVariable Integer id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isPresent()) {
            return ResponseEntity.ok(new CategoriaDto(categoria.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
