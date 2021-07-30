package backendchallenge.aluraflix.controller;


import backendchallenge.aluraflix.controller.dto.CategoriaDto;
import backendchallenge.aluraflix.model.Categoria;
import backendchallenge.aluraflix.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<CategoriaDto> listaCategorias(){
        List<Categoria> categoria = categoriaRepository.findAll();
        return CategoriaDto.converter(categoria);
    }
}
