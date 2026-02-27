package com.casopractico1.service;

import com.casopractico1.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> listarCategorias();
    Categoria guardarCategoria(Categoria categoria);
    void eliminarCategoria(Integer id);
    Categoria buscarPorId(Integer id);
}
