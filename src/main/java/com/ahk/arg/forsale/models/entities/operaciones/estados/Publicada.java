package com.ahk.arg.forsale.models.entities.operaciones.estados;

import com.ahk.arg.forsale.models.entities.Inmueble;
import com.ahk.arg.forsale.models.entities.personas.Cliente;
import com.ahk.arg.forsale.models.entities.personas.Empleado;

public class Publicada implements EstadoOperacion{
    @Override
    public void reservar(Inmueble inmueble, Cliente cliente, Empleado empleado) {
        inmueble.getOperacion().setEstado(new Reservada(cliente,empleado));
    }

    @Override
    public void concretar(Inmueble inmueble, Cliente cliente, Empleado empleado) {
        inmueble.getOperacion().setEstado(new Concretada(empleado,inmueble));
    }

    @Override
    public String estadoOperacion() {
        return "Publicada";
    }
}
