package com.ahk.arg.forsale.controllers;

import com.ahk.arg.forsale.models.entities.Zona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zonas")
public class ZonasController {
    private List<Zona> zonas;   //coleccion, array de zonas

    //constructor
    public ZonasController(){
        this.zonas= new ArrayList<>();
        Zona zona1=new Zona();
        zona1.setNombre("Recoleta");

        this.zonas.add(zona1);
    }

    @GetMapping
    public ResponseEntity<List<Zona>> buscarTodos(){
        //devuelve un codigo 200 con toda la coleccion de zonas
        return new ResponseEntity<>(this.zonas, HttpStatus.OK);
    }

    //Create
    @PostMapping
    public ResponseEntity<Zona> crearZona(@RequestBody Zona zona){
        this.zonas.add(zona);
        return new ResponseEntity<>(zona,HttpStatus.CREATED);
    }
}
