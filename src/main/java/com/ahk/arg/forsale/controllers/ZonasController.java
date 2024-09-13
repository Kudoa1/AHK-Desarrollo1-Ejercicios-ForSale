package com.ahk.arg.forsale.controllers;

import com.ahk.arg.forsale.models.entities.Zona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/zonas")
public class ZonasController {
    private List<Zona> zonas;

    //CONSTRUCTOR
    public ZonasController(){
        this.zonas=new ArrayList<>();
        Zona unaZona=new Zona();
        unaZona.setId(1);
        unaZona.setNombre("Balvanera");
        unaZona.setPrecio(150F);
        this.zonas.add(unaZona);

        Zona unaZona2=new Zona();
        unaZona2.setId(2);
        unaZona2.setNombre("Almagro 2");
        unaZona2.setPrecio(250F);
        this.zonas.add(unaZona2);
    }

    //para el listado de zonas
    @GetMapping
    public ModelAndView listadoDeZonas(Map<String, Object> model){
        //pasar datos a claves de otro archivo (data binding)
        model.put("title","For Sale");
        model.put("zonas",this.zonas);
        return new ModelAndView("zonas",model);
    }

    // Mostrar el formulario de agregar zona
    @GetMapping("/agregarZona")
    public ModelAndView mostrarFormularioAgregarZona() {
        return new ModelAndView("agregarZona"); // nombre del archivo HTML para el formulario
    }

}
