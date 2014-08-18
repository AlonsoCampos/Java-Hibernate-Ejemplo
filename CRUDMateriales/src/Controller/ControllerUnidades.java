/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HibernateUtil;
import Model.Unidades;
import org.hibernate.Session;

/**
 *
 * @author Yoshi
 */
public class ControllerUnidades {
    public static boolean CreateUnidad (String nombre){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Unidades unidad = new Unidades();
            unidad.setUnidad(nombre);
            sesion.save(unidad);
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            System.out.println(e.getMessage());
            return false;
        }
    }
}
