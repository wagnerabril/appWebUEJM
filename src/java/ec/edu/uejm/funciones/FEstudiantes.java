/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uejm.funciones;

import ec.edu.uejm.accesodatos.AccesoDatos;
import ec.edu.uejm.accesodatos.ConjuntoResultado;
import ec.edu.uejm.accesodatos.Parametro;
import ec.edu.uejm.rnegocio.clases.Curso;
import ec.edu.uejm.rnegocio.clases.Estudiantes;
import java.util.ArrayList;

/**
 *
 * @author wagne_000
 */
public class FEstudiantes {

    public static boolean insertar(Estudiantes obj) throws Exception {
        boolean band = false;
        String sql = "INSERT INTO `estudiantes`( `Numero`, `Cedula`, `Nombres`, `FechaNacimiento`, `Direccion`, `Telefono`, `Representante`, `observaciones`, `id_curso`) VALUES (?,?,?,?,?,?,?,?,?)";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
//campos con referencias
     lstpar.add(new Parametro(1, obj.getNumero()));
        lstpar.add(new Parametro(2, obj.getCedula()));
        lstpar.add(new Parametro(3, obj.getNombres()));
        lstpar.add(new Parametro(4, obj.getFechaNacimiento()));
        lstpar.add(new Parametro(5, obj.getDireccion()));
        lstpar.add(new Parametro(6, obj.getTelefono()));
        lstpar.add(new Parametro(7, obj.getRepresentante()));
        lstpar.add(new Parametro(8, obj.getObservaciones()));
        lstpar.add(new Parametro(9, obj.getCurso().getId()));
//campos sin referencias
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean modificar(Estudiantes obj) throws Exception {
        boolean band = false;
        String sql = "UPDATE `estudiantes` SET `Numero`=?,`Cedula`=?,`Nombres`=?,`FechaNacimiento`=?,`Direccion`=?,`Telefono`=?,`Representante`=?,`observaciones`=?,`id_curso`=? WHERE `Id`=?";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
//campos con referencias
        lstpar.add(new Parametro(1, obj.getNumero()));
        lstpar.add(new Parametro(2, obj.getCedula()));
        lstpar.add(new Parametro(3, obj.getNombres()));
        lstpar.add(new Parametro(4, obj.getFechaNacimiento()));
        lstpar.add(new Parametro(5, obj.getDireccion()));
        lstpar.add(new Parametro(6, obj.getTelefono()));
        lstpar.add(new Parametro(7, obj.getRepresentante()));
        lstpar.add(new Parametro(8, obj.getObservaciones()));
        lstpar.add(new Parametro(9, obj.getCurso().getId()));
        lstpar.add(new Parametro(10, obj.getId()));
//campos sin referencias
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean eliminar(Estudiantes obj) throws Exception {
        boolean band = false;
        String sql = "DELETE FROM `estudiantes` WHERE Id=?";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(1, obj.getId()));
//campos sin referencias
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static Estudiantes obtener(int id) throws Exception {
        Estudiantes miEstudiantes = null;
        try {
            String sql = "SELECT * FROM `estudiantes` WHERE Id=? ";
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, id));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            ArrayList<Estudiantes> lst = llenarEstudiantess(rs);
            for (Estudiantes c : lst) {
                miEstudiantes = c;
            }

        } catch (Exception ex) {
            throw ex;
        }
        return miEstudiantes;
    }

    public static ArrayList<Estudiantes> obtener() throws Exception {
        ArrayList<Estudiantes> lst = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `estudiantes`";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEstudiantess(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }
     public static ArrayList<Estudiantes> obtener(Curso item) throws Exception {
        ArrayList<Estudiantes> lst = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `estudiantes` where id_curso="+item.getId();
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEstudiantess(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

    private static ArrayList<Estudiantes> llenarEstudiantess(ConjuntoResultado cr) throws Exception {
        ArrayList<Estudiantes> lst = new ArrayList<Estudiantes>();
        Estudiantes obj = null;
        try {
            while (cr.next()) {
                obj = new Estudiantes();
//campos con referencias
                obj.setId(cr.getInt(1));
                obj.setNumero(cr.getString(2));
                obj.setCedula(cr.getString(3));
                obj.setNombres(cr.getString(4));
                obj.setFechaNacimiento(cr.getString(5));
                obj.setDireccion(cr.getString(6));
                obj.setTelefono(cr.getString(7));
                obj.setRepresentante(cr.getString(8));
                obj.setObservaciones(cr.getString(9));
                obj.setCurso(FCurso.obtener(cr.getInt(10)));
//campos sin referencias
                lst.add(obj);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

}
