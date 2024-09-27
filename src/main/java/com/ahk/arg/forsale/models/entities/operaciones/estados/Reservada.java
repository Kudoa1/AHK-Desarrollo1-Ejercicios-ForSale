package com.ahk.arg.forsale.models.entities.operaciones.estados;

import com.ahk.arg.forsale.models.entities.Inmueble;
import com.ahk.arg.forsale.models.entities.personas.Cliente;
import com.ahk.arg.forsale.models.entities.personas.Empleado;

public class Reservada implements EstadoOperacion{
    private Cliente cliente;
    private Empleado empleado;

    public Reservada(Cliente cliente, Empleado empleado) {
        this.cliente=cliente;
        this.empleado=empleado;
    }

    @Override
    public void reservar(Inmueble inmueble, Cliente cliente, Empleado empleado) {
        throw new RuntimeException("No se puede volver a reservar porque ya esta reservada");
    }

    @Override
    public void concretar(Inmueble inmueble, Cliente cliente, Empleado empleado) {
        if(this.cliente.equals(cliente)){
            inmueble.getOperacion().setEstado(new Concretada(empleado,inmueble));
        }else {throw new RuntimeException("No se puede concretar la operacion, el inmueble ya esta reservado");}
    }

    @Override
    public String estadoOperacion() {
        return "Reservada";
    }
}
