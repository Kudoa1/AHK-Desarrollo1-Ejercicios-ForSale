package com.ahk.arg.forsale.controllers;

import com.ahk.arg.forsale.models.entities.*;
import com.ahk.arg.forsale.models.entities.operaciones.Alquiler;
import com.ahk.arg.forsale.models.entities.operaciones.Venta;
import com.ahk.arg.forsale.models.entities.personas.Cliente;
import com.ahk.arg.forsale.models.entities.personas.Empleado;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    private List<Empleado> empleados;
    private List<Cliente> clientes;


    //Constructor
    public InmueblesController() {
        this.inmuebles=new ArrayList<>();
        this.zonas=new ArrayList<>();
        this.casas=new ArrayList<>();
        this.deptos=new ArrayList<>();
        this.PHS=new ArrayList<>();
        this.empleados=new ArrayList<>();
        this.clientes=new ArrayList<>();

        Zona unaZona=new Zona();
        unaZona.setId(1);
        unaZona.setNombre("Congreso");
        unaZona.setPrecio(50F);
        this.zonas.add(unaZona);

        Casa casa1=new Casa();
        casa1.setId(1);
        casa1.setOperacion(new Venta());
        casa1.setValor(100F);
        casa1.setZona(unaZona);
        casa1.setCantAmbientes(5);
        casa1.setTamanioEnM2(100F);
        casa1.getOperacion().setInmueble(casa1);

        Depto depto1=new Depto();
        depto1.setId(2);
        depto1.setOperacion(new Venta());
        depto1.setZona(unaZona);
        depto1.setCantAmbientes(3);
        depto1.setTamanioEnM2(50F);
        depto1.precio();
        depto1.getOperacion().setInmueble(depto1);

        PH ph1=new PH();
        ph1.setId(3);
        ph1.setOperacion(new Alquiler());
        ph1.setZona(unaZona);
        ph1.setCantAmbientes(4);
        ph1.setTamanioEnM2(70F);
        ph1.precio();
        inmuebles.add(casa1);
        inmuebles.add(depto1);
        inmuebles.add(ph1);
        ph1.getOperacion().setInmueble(ph1);

        Empleado empleado1=new Empleado();
        empleado1.setId(1);
        empleado1.setNombre("Juan");
        empleado1.setApellido("Perez");

        Empleado empleado2=new Empleado();
        empleado2.setId(2);
        empleado2.setNombre("Marcos");
        empleado2.setApellido("Sanchez 2");

        Empleado empleado3=new Empleado();
        empleado3.setId(3);
        empleado3.setNombre("Carlos");
        empleado3.setApellido("Alvarez 3");
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);

        Cliente cliente1=new Cliente();
        cliente1.setNombre("Cliente 1");
        cliente1.setApellido("apellido 1");
        cliente1.setId(1);

        Cliente cliente2=new Cliente();
        cliente2.setNombre("Cliente 2");
        cliente2.setApellido("apellido 2");
        cliente2.setId(2);

        Cliente cliente3=new Cliente();
        cliente3.setNombre("Cliente 3");
        cliente3.setApellido("apellido 3");
        cliente3.setId(1);
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);


    }

    //Manejar navegacion (similar al navTo)
    @GetMapping
    public ModelAndView listarInmuebles(Map<String, Object> model) {
        model.put("title","For Sale");
        model.put("inmuebles",this.inmuebles);
        return new ModelAndView("inmuebles",model);
    }

    //Manejar navegacion (similar al navTo)
    @GetMapping("/agregar")
    public ModelAndView seleccionarInmuebles(Map<String, Object> model) {
        model.put("title","Seleccionar tipo de Inmueble");
        model.put("zonas", this.zonas);
        return new ModelAndView("formularioCrearInmueble",model);
    }

/*
    @PostMapping("/crear/dpto")
    public RedirectView guardarDpto(@ModelAttribute Depto depto){  //le pasa los parametros a la vista
        this.inmuebles.add(depto);
        return new RedirectView("/inmuebles");
    }
    @PostMapping("/crear/dpto")
    public RedirectView guardarPH(@ModelAttribute PH ph){  //le pasa los parametros a la vista
        this.inmuebles.add(ph);
        return new RedirectView("/inmuebles");
    }
    @PostMapping("/crear/casa")
    public RedirectView guardarDpto(@ModelAttribute Casa casa){  //le pasa los parametros a la vista
        this.inmuebles.add(casa);
        return new RedirectView("/inmuebles");
    }
*/
    //formulario para reservar
    @GetMapping("/{id}/reservar")
    public ModelAndView formularioParaReservar(@PathVariable Integer id, Map<String, Object>model){
       model.put("empleados",this.empleados);
       model.put("clientes",this.clientes);
       model.put("inmuebleId",id);
       model.put("title","reservar");
        return new ModelAndView("formulario_reservar",model);
    }

    //TODO arreglar
    //formulario para concretar
    @GetMapping("/{id}/concretar")
    public ModelAndView formularioParaConcretar(@PathVariable Integer id, Map<String, Object>model){
        model.put("empleados",this.empleados);
        model.put("clientes",this.clientes);
        model.put("inmuebleId",id);
        model.put("title","concretar");
        return new ModelAndView("formulario_concretar",model);
    }

    //para el post de cambio de estado (si reserva o concreta compra)
    @PostMapping("/{id}/reservar")
    public RedirectView reservarInmueble(
            @PathVariable Integer id,
            @RequestParam Integer empleado_id,
            @RequestParam Integer cliente_id
    ){
        Inmueble inmueble = this.inmuebles.stream().filter(i -> i.getId().equals(id)).findFirst().get();
        Empleado empleado= this.empleados.stream().filter(e -> e.getId().equals(id)).findFirst().get();
        Cliente cliente= this.clientes.stream().filter(c -> c.getId().equals(id)).findFirst().get();

        empleado.registrarReserva(cliente,inmueble);
        return new RedirectView("/inmuebles");
    }

}
