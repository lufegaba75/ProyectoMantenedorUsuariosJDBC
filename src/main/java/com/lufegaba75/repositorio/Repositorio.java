package com.lufegaba75.repositorio;

import java.util.List;

public interface Repositorio<T>{

    List<T> listar();
    void guardar(T t);
    void actualizar(T t);
    void eliminar(Long id);


}
