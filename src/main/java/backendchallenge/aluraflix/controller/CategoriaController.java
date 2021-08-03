package backendchallenge.aluraflix.controller;


import backendchallenge.aluraflix.controller.dto.CategoriaDto;
import backendchallenge.aluraflix.controller.form.CategoriaForm;
import backendchallenge.aluraflix.model.Categorias;
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
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<CategoriaDto> listaCategorias(){
        List<Categorias> categorias = categoriaRepository.findAll();
        return CategoriaDto.converter(categorias);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoriaDto> buscaPorId (@PathVariable Integer id){
        Optional<Categorias> categoria = categoriaRepository.findById(id);

        if (categoria.isPresent()) {
            return ResponseEntity.ok(new CategoriaDto(categoria.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> cadastraCategoria(@RequestBody @Valid CategoriaForm categoriaForm, UriComponentsBuilder uriBuilder){
        Categorias categoria = categoriaForm.converter();
        categoriaRepository.save(categoria);
        URI uri = uriBuilder.path("/{id}").buildAndExpand(categoria.getIdCategoria()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(categoria));

    }

}
