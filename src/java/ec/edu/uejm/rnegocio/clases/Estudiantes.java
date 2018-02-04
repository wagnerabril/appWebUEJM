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
public class Estudiantes {

    int Id;
    String Numero;
    String Cedula;
    String Nombres;
    String FechaNacimiento;
    String Direccion;
    String Telefono;
    String Representante;
    String observaciones;
    Curso curso;

    public Estudiantes() {
        this.curso = new Curso();
    }

    public Estudiantes(int Id, String Numero, String Cedula, String Nombres, String FechaNacimiento, String Direccion, String Telefono, String Representante, String observaciones, Curso curso) {
        this.Id = Id;
        this.Numero = Numero;
        this.Cedula = Cedula;
        this.Nombres = Nombres;
        this.FechaNacimiento = FechaNacimiento;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Representante = Representante;
        this.observaciones = observaciones;
        this.curso = curso;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getRepresentante() {
        return Representante;
    }

    public void setRepresentante(String Representante) {
        this.Representante = Representante;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
