package com.ahk.arg.forsale.models.entities.operaciones.estados;

import com.ahk.arg.forsale.models.entities.Inmueble;
import com.ahk.arg.forsale.models.entities.personas.Cliente;
import com.ahk.arg.forsale.models.entities.personas.Empleado;

public class Concretada implements EstadoOperacion{

    public Concretada(Empleado empleado, Inmueble inmueble){
        inmueble.getOperacion().calcularComisionPara(empleado);
    }

    @Override
    public void reservar(Inmueble inmueble, Cliente cliente, Empleado empleado) {
        throw new RuntimeException("No se puede volver a reservar, porque ya esta concretada");

    }

    @Override
    public void concretar(Inmueble inmueble, Cliente cliente, Empleado empleado) {
        throw new RuntimeException("No se puede volver a Concretar");

    }

    @Override
    public String estadoOperacion() {
        return "Concretada";
    }
}
