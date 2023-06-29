package com.dh.mascotas.controller;


import com.dh.mascotas.persistence.entities.ProductoEstilo;
import com.dh.mascotas.service.EjemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Mediante la anotacion RestController me permite tratar la clase como un controller,
// de tio REST, de esta manera, me permite crear los RequestMapping y poder realizar los POST y GET.
@RestController
//mediante la anotacion RequestMapping indicamos el nombre del endpoint principal
//de esta manera, al intentar realizar un POST o un GET debemos realizar la peticion
//dando como parametro "/movimientos". Tener en cuenta esto para utilizar en PostMan
@RequestMapping("/movimientos")
public class ProductoEstiloController {

    //Mediante la anotacion Autowired, delegamos la creacion de las propiedades declaradas
    //De esta manera no necesitamos crear un objeto de tipo EjemploService.
    @Autowired
    EjemploService service;

    // creamos el primer metodo POST. De esta manera, al entrar por el endpoint "/crear" llamamos
    //al metodo "crear" y ejecutamos su contenido. Tener en cuenta cuando lo usemos en PostMan
    //En este caso el metodo crear toma como parametro un objeto de tipo ProductoEstilo y lo
    //agrega a la base de datos.
    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody ProductoEstilo pe){
        ResponseEntity<String> respuesta = null;

        if(service.save(pe) != null){
            respuesta = ResponseEntity.ok("El Producto fue registrado con éxito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }

    // creamos el segundo metodo GET. De esta manera, al entrar por el endpoint "/todos" ejecutamos
    //al metodo "consultarTodos" y ejecutamos su contenido. Tener en cuenta cuando lo usemos en PostMan
    //En este caso el metodo consultarTodos no toma ningnu parametro. Retorno TODOS los objetos de tipo
    //ProductoEstilo que tengamos en la base de datos. Digamos, todos los productos
    //que hayamos creado y agregado en la base de datos, este metodo los retornara.
    @GetMapping("/todos")
    public ResponseEntity<List<ProductoEstilo>> consultarTodos(){

        return ResponseEntity.ok(service.obtenerTodos());
    }
}
