package com.ahk.arg.forsale.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Casa extends Inmueble{
    private Float valor;

    @Override
    public Float precio() {
        return this.valor;
    }
}
