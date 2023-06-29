package com.dh.mascotas.service;

import com.dh.mascotas.persistence.entities.ProductoEstilo;
import com.dh.mascotas.persistence.repository.ProductoEstiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjemploService {

    @Autowired
    ProductoEstiloRepository repository;

    public String save(ProductoEstilo m){
        if(repository.save(m) != null){
            return "OK";
        }else{
            return null;
        }
    }

    public List<ProductoEstilo> obtenerTodos(){
        return repository.findAll();
    }

}
