/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Estadistica;

/**
 *
 * @author Antonio Arce
 */
public class EstadisticaNegocio {
    private Estadistica estadistica;

    public EstadisticaNegocio(int idcliente) {
        estadistica = new Estadistica(idcliente);
    }
    
    public String mostrar(){
        return estadistica.toString();
    }
    
}
