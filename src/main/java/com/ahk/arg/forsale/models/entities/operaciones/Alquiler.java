package com.ahk.arg.forsale.models.entities.operaciones;

import com.ahk.arg.forsale.models.entities.personas.Empleado;
import lombok.Getter;
import lombok.Setter;

import java.time.temporal.UnsupportedTemporalTypeException;

@Setter
@Getter
public class Alquiler extends Operacion{
    private Integer cantMeses;

    @Override
    public String operacion() {
        return "Alquiler";
    }

    @Override
    public Float calcularComisionPara(Empleado empleado) {
        Float comision= (this.cantMeses * super.inmueble.precioFinal()) / 50000;
        empleado.agregarComision(comision);
        return comision;
    }


}
