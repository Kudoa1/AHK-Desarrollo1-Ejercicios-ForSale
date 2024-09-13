package com.ahk.arg.forsale.controllers;

import com.ahk.arg.forsale.models.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/inmuebles")
public class InmueblesController {
    private List<Inmueble> inmuebles;
    private List<Zona> zonas;
    private List<Casa> casas;
    private List<Depto> deptos;
    private List<PH> PHS;


    //Constructor
    public InmueblesController() {
        this.inmuebles=new ArrayList<>();
        this.zonas=new ArrayList<>();
        this.casas=new ArrayList<>();
        this.deptos=new ArrayList<>();
        this.PHS=new ArrayList<>();

        Zona unaZona=new Zona();
        unaZona.setId(1);
        unaZona.setNombre("Congreso");
        unaZona.setPrecio(50F);
        this.zonas.add(unaZona);

        Casa casa1=new Casa();
        casa1.setValor(100F);
        casa1.setZona(unaZona);
        casa1.setCantAmbientes(5);
        casa1.setTamanioEnM2(100F);

        Depto depto1=new Depto();
        depto1.setZona(unaZona);
        depto1.setCantAmbientes(3);
        depto1.setTamanioEnM2(50F);
        depto1.precio();

        PH ph1=new PH();
        ph1.setZona(unaZona);
        ph1.setCantAmbientes(4);
        ph1.setTamanioEnM2(70F);
        ph1.precio();

        inmuebles.add(casa1);
        inmuebles.add(depto1);
        inmuebles.add(ph1);

    }

    //Manejar navegacion (similar al navTo)
    @GetMapping
    public ModelAndView listarInmuebles(Map<String, Object> model) {
        model.put("title","For Sale");
        model.put("inmuebles",this.inmuebles);
        return new ModelAndView("inmuebles",model);
    }

}
