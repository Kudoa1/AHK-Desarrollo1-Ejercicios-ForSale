package com.ahk.arg.forsale.controllers.api;

import com.ahk.arg.forsale.models.entities.Zona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/zonas")
public class ZonasAPIController {
    private List<Zona> zonas;   //coleccion, array de zonas

    //constructor
    public ZonasAPIController(){
        this.zonas= new ArrayList<>();
        Zona zona1=new Zona();
        zona1.setId(1);
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

    //Delete (esperamos id como entero)
    @DeleteMapping("/{id}")
    public ResponseEntity<?>eliminarZona(@PathVariable Integer id){
        //variable para intentar conseguir la zona es de tipo Optional<entity>
        //Verificar si existe
        Optional<Zona> posibleZona = this.zonas
                .stream()
                .filter(z -> z.getId().equals(id))  //aca tenemos una coleccion filtrada
                .findFirst();
        if(posibleZona.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

        //si encontró una zona, entonces llamar metodo "get" para obtener esa zona y le damos al metodo "remove"
        Zona zonaABorrar=posibleZona.get();
        this.zonas.remove(zonaABorrar);
        return  new ResponseEntity<>(null,HttpStatus.OK);
    }

    //para modificar: put-patch
        //put= pretende modificar todos los atributos de la entidad.
        //patch= modificar parcialmente la entidad.
    @PutMapping("/{id}")
    public ResponseEntity<Zona> modificarZona(@PathVariable Integer id, @RequestBody Zona zona){
        //Verificar si existe
        Optional<Zona> posibleZona = this.zonas
                .stream()
                .filter(z -> z.getId().equals(id))  //aca tenemos una coleccion filtrada
                .findFirst();
        if(posibleZona.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

        Zona zonaAModificar=posibleZona.get();
        zonaAModificar.setNombre(zona.getNombre());
        zonaAModificar.setPrecio(zona.getPrecio());

        return new ResponseEntity<>(zonaAModificar,HttpStatus.OK);
    }
}
