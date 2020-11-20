/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1poo;

/**
 *
 * @author dam
 */
public class Libro {
    private String tipo;
    private int contado;
    private int credito;

    public Libro (String tipo){
        this.tipo=tipo;
    }
    
    
    public String getTipo() {
        return tipo;
    }

    public int getContado() {
        return contado;
    }

    public int getCredito() {
        return credito;
    }
    
    public int calcularTotal(){
       int total; 
       total= contado + credito;
        return total;
    }
    public void ventaContado(){
        contado++;
    }
    public void ventaCredito(){
        credito++;
    }

}
