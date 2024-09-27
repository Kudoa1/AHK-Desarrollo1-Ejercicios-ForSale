package com.ahk.arg.forsale.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PH extends Inmueble{

    @Override
    public String tipo() {
        return "PH";
    }

    @Override
    public Float precio() {
        return 500000 + 1400 * super.tamanioEnM2;
    }
}
