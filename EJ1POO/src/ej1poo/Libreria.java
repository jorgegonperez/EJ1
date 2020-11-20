/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1poo;

import utilidad.Utilidad;

/**
 *
 * @author dam
 */
public class Libreria {

    Libro libro1;
    Libro libro2;

    public Libreria() {
        libro1 = new Libro("Informatica");
        libro2 = new Libro("Economia");
    }

    public Libreria(String l1, String l2) {
        libro1 = new Libro(l1);
        libro2 = new Libro(l2);
    }

    public int totalLibros() {
        int total;
        total = libro1.calcularTotal() + libro2.calcularTotal();
        return total;
    }

    public float porcentajeTipo1() {
        int total = totalLibros();
        float porcentaje = 0;
        if (total != 0) {
            porcentaje = (float) libro1.calcularTotal() / total * 100;
        }
        return porcentaje;
    }

    public float porcentajeTipo2() {
        int total = totalLibros();
        float porcentaje = 0;
        if (total != 0) {
            porcentaje = (float) libro2.calcularTotal() / total * 100;
        }
        return porcentaje;
    }

    public int totalContado() {
        int total = libro1.getContado() + libro2.getContado();
        return total;
    }

    public float porcentajeContado() {
        int total = totalLibros();
        float porcentaje = 0;
        if (total != 0) {
            porcentaje = (float) totalContado() / total * 100;
        }
        return porcentaje;

    }

    public int totalCredito() {
        int total = libro1.getCredito() + libro2.getCredito();
        return total;
    }

    public float porcentajeCredito() {
        int total = totalLibros();
        float porcentaje = 0;
        if (total != 0) {
            porcentaje = (float) totalCredito() / total * 100;
        }
        return porcentaje;

    }

    public String menosVendido() {
        String libro;
        if (libro1.calcularTotal() < libro2.calcularTotal()) {
            libro = libro1.getTipo();
        } else {
            if (libro1.calcularTotal() > libro2.calcularTotal()) {
                libro = libro2.getTipo();
            } else {
                libro = "Se han vendido de forma igual";
            }

        }
        return libro;
    }

    public void venta(String libro, int formaPago) {
        if (libro.equalsIgnoreCase(libro1.getTipo())) {
            switch (formaPago) {
                case 1:
                    libro1.ventaContado();
                    break;
                case 2:
                    libro1.ventaCredito();

            }
        }else {       
            switch (formaPago){
            case 1: libro2.ventaContado();
            break;
            case 2:libro2.ventaCredito();
                }
    }
        }
    
    public void ventasLibros(){
        String libro;
        int formaPago;
        libro=pedirLibro();
        while (!libro.equalsIgnoreCase("fin")){
            formaPago=Utilidad.pedirNumero("1. Contado \n 2. Credito");
        venta (libro, formaPago);
    } 
    }
    
    public String pedirLibro(){
        String libro;
        libro=Utilidad.pedirString("Introduce un libro");
        while ( libro.compareToIgnoreCase( libro1.getTipo()) !=0 &&
               libro.compareToIgnoreCase(libro2.getTipo()) !=0 &&
               libro.compareToIgnoreCase("fin") !=0) {
        System.out.println("No tenemos ese libro");
        libro=Utilidad.pedirString("Introduce un libro");
    }
        return libro;
    }
    
    
    public void informe(){
        
        System.out.println("tipo de libro \t  contado\t credito\t total\t porcentaje");
        System.out.println(libro1.getTipo()+ "\t" + libro1.getContado() +  "\t" + libro1.getCredito() 
                + "\t" + libro1.calcularTotal() + "\t" + porcentajeTipo1() );
        System.out.println(libro2.getTipo() + "\t" + libro2.getContado() + "\t" 
                + libro2.getCredito() + "\t" + libro2.calcularTotal() + "\t" + porcentajeTipo2());
        System.out.println("Total" + totalContado() + "\t" + totalCredito () + "\t" + totalLibros());
        System.out.println("El porcentaje de ventas al contado es" + porcentajeContado());
        System.out.println("El porcentaje de ventas con tarjeta de crédito es:" + porcentajeCredito());
        System.out.println("El tipo de libro menos vendido es:" + menosVendido());
    }
    }

