/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HibernateUtil;
import Model.Ubicacion;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Yoshi
 */
public class ControllerUbicacion {
    public static boolean CreateUbicacion(String anaquel, String seccion){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Ubicacion ubicacion = new Ubicacion();
            ubicacion.setAnaquel(anaquel);
            ubicacion.setSeccion(seccion);
            sesion.save(ubicacion);
            sesion.getTransaction().commit();
            sesion.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            sesion.getTransaction().rollback();
            sesion.close();
            return false;
        }
    }
}
