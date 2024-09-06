package com.ahk.arg.forsale.entities;

import com.ahk.arg.forsale.models.entities.Casa;
import com.ahk.arg.forsale.models.entities.Zona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InmuebleTest {
    @Test
    public void precioDeCasaEnRecoleta(){
        Zona recoleta=new Zona();
        recoleta.setNombre("Recoleta");
        recoleta.setPrecio(50.0F);

        Casa unaCasa=new Casa();
        unaCasa.setZona(recoleta);
        unaCasa.setValor(100F);

        Assertions.assertEquals(150F, unaCasa.precioFinal());
    }
}
