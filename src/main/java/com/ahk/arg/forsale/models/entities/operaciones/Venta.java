package com.ahk.arg.forsale.models.entities.operaciones;

import com.ahk.arg.forsale.models.entities.personas.Empleado;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Venta extends Operacion{
    static Float porcentajeComision=1.5F;
    @Override
    public Float calcularComisionPara(Empleado empleado) {
        return super.inmueble.precioFinal() * Venta.porcentajeComision;
    }


}
