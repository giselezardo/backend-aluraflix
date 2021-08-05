package backendchallenge.aluraflix.controller;

import backendchallenge.aluraflix.controller.dto.CategoriaDto;
import backendchallenge.aluraflix.controller.form.CategoriaForm;
import backendchallenge.aluraflix.model.Categoria;
import backendchallenge.aluraflix.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping
    public List<CategoriaDto> listaCategorias(){
        List <Categoria> categorias = categoriaRepository.findAll();
        return CategoriaDto.converterParaDto(categorias);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> cadastraCategoria(@RequestBody CategoriaForm categoriaForm, UriComponentsBuilder uriBuilder){
        Categoria categoria = categoriaForm.converterParaForm(categoriaRepository);
        categoriaRepository.save(categoria);
        URI uri = uriBuilder.path("/categoria/{id}").buildAndExpand(categoria.getIdCategoria()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
    }

}
