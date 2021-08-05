package backendchallenge.aluraflix.controller.form;

import backendchallenge.aluraflix.model.Categoria;
import backendchallenge.aluraflix.repository.CategoriaRepository;

public class CategoriaForm {

    private String tituloCategoria;
    private String corCategoria;

    public CategoriaForm(String tituloCategoria, String corCategoria) {
        this.tituloCategoria = tituloCategoria;
        this.corCategoria = corCategoria;
    }

    public Categoria converterParaForm(CategoriaRepository categoriaRepository){
        Categoria categoria = new Categoria(this.tituloCategoria, this.corCategoria);
        return categoria;
    }

    public String getTituloCategoria() {
        return tituloCategoria;
    }

    public void setTituloCategoria(String tituloCategoria) {
        this.tituloCategoria = tituloCategoria;
    }

    public String getCorCategoria() {
        return corCategoria;
    }

    public void setCorCategoria(String corCategoria) {
        this.corCategoria = corCategoria;
    }
}
