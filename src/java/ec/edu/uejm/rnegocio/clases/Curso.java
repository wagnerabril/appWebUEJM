/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uejm.rnegocio.clases;

/**
 *
 * @author wagne_000
 */
public class Curso {

    int Id;
    String nombre;
    String descripcion;
    String tutor;

    public Curso() {
    }

    public Curso(int Id, String nombre, String descripcion, String tutor) {
        this.Id = Id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tutor = tutor;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

}
