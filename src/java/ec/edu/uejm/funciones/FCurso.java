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
import java.util.ArrayList;

/**
 *
 * @author wagne_000
 */
public class FCurso {

    public static boolean insertar(Curso obj) throws Exception {
        boolean band = false;
        String sql = "INSERT INTO `curso`( `nombre`, `descripcion`, `tutor`) VALUES (?,?,?)";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
//campos con referencias
        lstpar.add(new Parametro(1, obj.getNombre()));
        lstpar.add(new Parametro(2, obj.getDescripcion()));
        lstpar.add(new Parametro(3, obj.getTutor()));
//campos sin referencias
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean modificar(Curso obj) throws Exception {
        boolean band = false;
        String sql = "update curso set nombre=? ,descripcion=?,tutor=? where  Id=?";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
//campos con referencias
        lstpar.add(new Parametro(1, obj.getNombre()));
        lstpar.add(new Parametro(2, obj.getDescripcion()));
        lstpar.add(new Parametro(3, obj.getTutor()));
        lstpar.add(new Parametro(4, obj.getId()));
//campos sin referencias
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean eliminar(Curso obj) throws Exception {
        boolean band = false;
        String sql = "delete from curso where Id=?";
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

    public static Curso obtener(int id) throws Exception {
        Curso miCurso = null;
        try {
            String sql = "SELECT * FROM `curso` WHERE Id =? ";
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, id));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            ArrayList<Curso> lst = llenarCursos(rs);
            for (Curso c : lst) {
                miCurso = c;
            }

        } catch (Exception ex) {
            throw ex;
        }
        return miCurso;
    }

    public static ArrayList<Curso> obtener() throws Exception {
        System.out.println("HOla");
        
        ArrayList<Curso> lst = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `curso`";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCursos(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

    private static ArrayList<Curso> llenarCursos(ConjuntoResultado cr) throws Exception {
        ArrayList<Curso> lst = new ArrayList<Curso>();
        Curso obj = null;
        try {
            while (cr.next()) {
                obj = new Curso();
//campos con referencias
                obj.setId(cr.getInt(1));
                obj.setNombre(cr.getString(2));
                obj.setDescripcion(cr.getString(3));
                obj.setTutor(cr.getString(4));
//campos sin referencias
                lst.add(obj);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

}
