package com.ahk.arg.forsale.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    //variables de ruta
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
    @GetMapping("/hello/{nombre}")
    public String StringhelloTo(@PathVariable String nombre){
        return "Hello "+nombre;
    }

    //Query params (parametros de query)
    @GetMapping("/hello-complex")
    public String helloContext(@RequestParam("nombre") String nombre ,
                               @RequestParam(value="apellido",required = false) String apellido){
        return "hola " + nombre + apellido;
    }
}
