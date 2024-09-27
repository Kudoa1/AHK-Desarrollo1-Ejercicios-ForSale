package com.ahk.arg.forsale.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Depto extends  Inmueble{

    @Override
    public String tipo() {
        return "Depto";
    }

    @Override
    public Float precio() {
        return Float.valueOf(350000 * super.cantAmbientes);
        //return (float) (350000 * super.cantAmbientes);
    }
}
