/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Detallesmateriales;
import Model.Estado;
import Model.HibernateUtil;
import Model.Marcas;
import Model.Materiales;
import Model.Ubicacion;
import Model.Unidades;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yoshi
 */
public class ControllerMateriales
{
    public static boolean CreateMaterial (String nombre, Marcas marca
            , Ubicacion ubicacion, Estado estado)
    {
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    sesion.beginTransaction();
        try {
            Materiales material = new Materiales();
            material.setMaterial(nombre);
            material.setActivo(true);
            material.setMarcas(marca);
            material.setUbicacion(ubicacion);
            material.setEstado(estado);
            material.setImagen(nombre);
            sesion.save(material);
            sesion.getTransaction().commit();            
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }

public static boolean CreateDetallesMateriales (String codigo, float stock, 
        Date caducidad, String notas, Unidades unidad
            )
    {
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    sesion.beginTransaction();
        try {
                 
            int id = (int) sesion.createCriteria(Materiales.class)
                    .setProjection(Projections.max("idMateriales"))
                    .uniqueResult();
            //Aqui se hace una busqueda del ultimo registro
            Materiales idD= ConsultasMateriales.UnicoMaterial(id);
            Detallesmateriales detalles = new Detallesmateriales();
            detalles.setCodigo(codigo);
            detalles.setStock(stock);
            detalles.setFechaCaducidad(caducidad);
            detalles.setDetalles(notas);
            detalles.setUnidades(unidad);
            detalles.setMateriales(idD);
            sesion.save(detalles);
            sesion.getTransaction().commit();            
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
   public static boolean CrearMateriales (String nombre, Marcas marca
            , Ubicacion ubicacion, Estado estado, String codigo, 
            float stock, Date caducidad, String notas, Unidades unidad)
   {
       if (CreateMaterial(nombre, marca, ubicacion, estado)==true) 
       {
           if(CreateDetallesMateriales(codigo, stock, caducidad, notas, unidad)){
               JOptionPane.showMessageDialog(null, "Se ha registrado correctamente");
               return true;
           }
       }
       else
       {
           JOptionPane.showMessageDialog(null, "Ha ocurrido un error al guardar");
           return false;
       }
       return false;
   }
    
   /* Codidgo de Prueba de Agregar nuevo registro
   public static void main (String args[]){
       String nombre ="yOSHI1";
       String cod ="112dasd";
       String nota ="1sdasdasd";
       Date date = new Date();
       Marcas marca = ConsultasMateriales.UnicaMarca(1);
       Ubicacion ubicacion = ConsultasMateriales.UnicaUbicacion(1);
       Estado estado = ConsultasMateriales.UnicoEstado(1);
       Unidades uni = ConsultasMateriales.UnicaUnidad(1);
       float stock= 12;
       
       CrearMateriales(nombre, marca, ubicacion, estado, cod, stock, date, nota, uni);
   }*/
   public static boolean UpdateMateriales (int id,String codigo, String nombre, Marcas marca, Ubicacion 
           ubicacion, Estado estado /*Detalles*/,float stock, Date caducidad, String detalle
           ,Unidades unidad){
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       sesion.beginTransaction();
       try {
           Detallesmateriales detalles = (Detallesmateriales) sesion.createCriteria
                   (Detallesmateriales.class).add(Restrictions.eq("idDetalleMaterial", id)).uniqueResult();
                   
               if(detalles!=null)
                   {               
                detalles.getMateriales().setMaterial(nombre);
                detalles.getMateriales().setMarcas(marca);
                detalles.getMateriales().setUbicacion(ubicacion);
                detalles.getMateriales().setEstado(estado);
                detalles.setStock(stock);
                detalles.setFechaCaducidad(caducidad);
                detalles.setDetalles(detalle);
                detalles.setUnidades(unidad);
                sesion.update(detalles);
                sesion.getTransaction().commit();
                return true;
               }else{
                   JOptionPane.showMessageDialog(null, "No se ha podigo encontrar el codigo","",JOptionPane.ERROR_MESSAGE);
                   return false;
               }
           
       } catch (Exception e) {
           sesion.getTransaction().rollback();
           System.err.println(e.getMessage());
           return false;
       }
        
   }
   /*Test Update
   public static void main (String args[]){
       String nombre ="Bebe Yoshi";
       String cod ="yoshi";
       String nota ="1sdasdasd";
       Date date = new Date();
       Marcas marca = ConsultasMateriales.UnicaMarca(1);
       Ubicacion ubicacion = ConsultasMateriales.UnicaUbicacion(1);
       Estado estado = ConsultasMateriales.UnicoEstado(1);
       Unidades uni = ConsultasMateriales.UnicaUnidad(1);
       float stock= 12;
       if (cod, nombre, marca, ubicacion, estado, stock, date, nota, uni)!=false) {
           System.out.println("exito");
       }
   }*/
   public static boolean DownMateriales (String codigo)
   {
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       sesion.beginTransaction();
       try {
           Detallesmateriales detalles = (Detallesmateriales) sesion.createCriteria
                   (Detallesmateriales.class).add(Restrictions.eq("codigo", codigo)).uniqueResult();
           
               if(detalles!=null)
               {               
                detalles.getMateriales().setActivo(false);
                sesion.update(detalles);
                sesion.getTransaction().commit();
                return true;
               }else{
                   JOptionPane.showMessageDialog(null, "No se ha podigo encontrar el codigo","",JOptionPane.ERROR_MESSAGE);
                   return false;
               }
           
       } catch (Exception e) {
           sesion.getTransaction().rollback();
           System.err.println(e.getMessage());
           return false;
       }    
   }
   public static boolean DeleteMateriales (int id)
   {
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       sesion.beginTransaction();
       try {
           Detallesmateriales detalles = (Detallesmateriales) sesion.createCriteria
                   (Detallesmateriales.class).add(Restrictions.eq("idDetalleMaterial", id)).uniqueResult();
           
               if(detalles!=null)
               {               
                sesion.delete(detalles);
                sesion.getTransaction().commit();
                return true;
               }else{
                   JOptionPane.showMessageDialog(null, "No se ha podigo encontrar el codigo","",JOptionPane.ERROR_MESSAGE);
                   return false;
               }
           
       } catch (Exception e) {
           sesion.getTransaction().rollback();
           System.err.println(e.getMessage());
           return false;
       }    
   }
   
   public static boolean UpMateriales (String codigo)
   {
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       sesion.beginTransaction();
       try {
           Detallesmateriales detalles = (Detallesmateriales) sesion.createCriteria
                   (Detallesmateriales.class).add(Restrictions.eq("codigo", codigo)).uniqueResult();
           
               if(detalles!=null)
               {               
                detalles.getMateriales().setActivo(true);
                sesion.update(detalles);
                sesion.getTransaction().commit();
                return true;
               }else{
                   JOptionPane.showMessageDialog(null, "No se ha podigo encontrar el codigo","",JOptionPane.ERROR_MESSAGE);
                   return false;
               }
           
       } catch (Exception e) {
           sesion.getTransaction().rollback();
           System.err.println(e.getMessage());
           return false;
       }
        
   }
   /*Test UP and Down
   public static void main (String args[]){
       String cod ="yoshi";
       if (UpMateriales(cod)) {
           System.out.println("exito");
       }
   }*/
}
