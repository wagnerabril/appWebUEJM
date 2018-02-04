/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uejm.bean;

import static com.sun.faces.facelets.util.Path.context;
import ec.edu.uejm.funciones.FEstudiantes;
import ec.edu.uejm.rnegocio.clases.Curso;
import ec.edu.uejm.rnegocio.clases.Estudiantes;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author wagne_000
 */
@ManagedBean
@ViewScoped
public class EstudiantesController {

    boolean showModal = false;
    Estudiantes estudiante = new Estudiantes();
    Curso curso = new Curso();
    ArrayList<Estudiantes> lst = new ArrayList<>();

    public EstudiantesController() throws Exception {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Map requestParams = context.getExternalContext().getRequestParameterMap();
            int id = Integer.parseInt((String) requestParams.get("id"));
           
            curso.setId(id);
            cargarDatos();
        } catch (Exception e) {
            
        }

    }

    public void cargarDatos() throws Exception {
        lst = new ArrayList<>();
         System.out.println("Id :"+curso.getId());
        lst = FEstudiantes.obtener(curso);
    }

    public Estudiantes getEstudiantes() {
        return estudiante;
    }

    public void setEstudiantes(Estudiantes estudiante) {
        this.estudiante = estudiante;
    }

    public ArrayList<Estudiantes> getLst() {
        return lst;
    }

    public void setLst(ArrayList<Estudiantes> lst) {
        this.lst = lst;
    }

    public void showEditar(Estudiantes item) {
        estudiante = item;

    }

    public void insert() throws Exception {
        estudiante.setCurso(curso);
        FEstudiantes.insertar(estudiante);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto.", "Correcto."));
        cargarDatos();
    }

    public void update() throws Exception {
        FEstudiantes.modificar(estudiante);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto.", "Correcto."));
        cargarDatos();
        FacesContext.getCurrentInstance().getExternalContext().redirect("Estudiantes.xhtml?id="+curso.getId());

    }

    public void ver(Estudiantes item) throws Exception {

        FacesContext.getCurrentInstance().getExternalContext().redirect("Estudiantes.xhtml?id=" + item.getId());

    }

    public void eliminar(Estudiantes item) throws Exception {
        FEstudiantes.eliminar(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto.", "Correcto."));
        cargarDatos();
    }
}
