/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uejm.bean;

import ec.edu.uejm.funciones.FCurso;
import ec.edu.uejm.rnegocio.clases.Curso;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.tomcat.util.http.fileupload.RequestContext;

/**
 *
 * @author wagne_000
 */
@ManagedBean
@ViewScoped
public class CursoController {

    boolean showModal = false;
    Curso curso = new Curso();
    ArrayList<Curso> lst = new ArrayList<>();

    public CursoController() throws Exception {
        cargarDatos();
    }

    public void cargarDatos() throws Exception {
        lst = new ArrayList<>();
        lst = FCurso.obtener();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public ArrayList<Curso> getLst() {
        return lst;
    }

    public void setLst(ArrayList<Curso> lst) {
        this.lst = lst;
    }

    public void showEditar(Curso item) {
        curso = item;

    }

    public void insert() throws Exception {
        FCurso.insertar(curso);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto.", "Correcto."));
        cargarDatos();
    }

    public void update() throws Exception {
        FCurso.modificar(curso);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto.", "Correcto."));
        cargarDatos();
        FacesContext.getCurrentInstance().getExternalContext().redirect("Curso.xhtml");
      
    }
    
      public void ver(Curso item) throws Exception {
      
        FacesContext.getCurrentInstance().getExternalContext().redirect("Estudiantes.xhtml?id="+item.getId());
      
    }

    public void eliminar(Curso item) throws Exception {
        FCurso.eliminar(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto.", "Correcto."));
        cargarDatos();
    }

}
