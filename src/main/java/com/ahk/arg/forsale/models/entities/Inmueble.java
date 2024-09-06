package com.ahk.arg.forsale.models.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Inmueble {
    // atributos siempre en privado
    protected Integer cantAmbientes;
    protected Float tamanioEnM2;
    private Zona zona;

    //los metodos abstractos solo van en clases abstractas, NO LLEVAN CUERPO {}.
    //La clase hija DEBE SI o SI implementar la clase Abstracta
    public abstract Float precio();

    public Float precioFinal(){
        return this.precio()+this.zona.getPrecio();
    }
}
