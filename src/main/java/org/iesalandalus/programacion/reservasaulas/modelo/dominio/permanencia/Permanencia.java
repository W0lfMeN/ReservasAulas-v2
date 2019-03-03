/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
/**
 *
 * @author carlo
 */
public abstract class Permanencia {
    
    protected LocalDate dia;
    protected static final DateTimeFormatter FORMATO_DIA=DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     *
     * @param dia
     * 
     */
    protected Permanencia(LocalDate dia){ //constructor 
        setDia(dia);
    }
    
    /**
     *
     * @param p
     */
    protected Permanencia (Permanencia p){ //constructor copia
        if(p==null){
            throw new IllegalArgumentException("No se puede copiar una permanencia nula.");
        }
        setDia(p.dia);
    }
    protected Permanencia (String dia){
        setDia(dia);
    }

    public LocalDate getDia() {
        return LocalDate.of(dia.getYear(), dia.getMonth(), dia.getDayOfMonth());
    }

    protected void setDia(LocalDate dia) {
        if(dia==null){
            throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
        }
        this.dia = LocalDate.of(dia.getYear(), dia.getMonth(), dia.getDayOfMonth());
    }
    
    protected void setDia(String dia){
        if(dia==null){
            throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
        }
        if(dia.equals("")){
            throw new IllegalArgumentException("El día de una permanencia no puede ser vacío");
        }
        this.dia=LocalDate.parse(dia, FORMATO_DIA);
    }
    //Los metodos de a continuación al ser abstractos no pueden tener cuerpo
    
    public abstract int getPuntos();
    
    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
        
}
