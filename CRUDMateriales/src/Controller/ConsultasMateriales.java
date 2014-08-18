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
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yoshi
 */
public class ConsultasMateriales 
{
    public static Materiales AfterMaterial(int busqueda){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Materiales limite = ConsultasMateriales.UnicoMaterial(busqueda);
        if(limite!=null){
            Materiales inicio = FirtsMaterial();
            boolean continuar =true;
            int id = limite.getIdMateriales();
            int index = inicio.getIdMateriales();
            while (continuar!=false) {                   
                if (id>index) {
                    id--;
                    Materiales material = ConsultasMateriales.UnicoMaterial(id);
                    if(material!=null){
                        System.out.println(id);  
                        continuar =false;
                        return material;
                    }
                }else{
                    System.out.println(id);
                    continuar =false;
                    return limite;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ya no existe un registro antes");
            
        }
         return limite;   
    }
    public static boolean IsPar(int numero) {        
        if (numero % 2 == 0) {
            //System.out.println("numero: " + numero + ", Es Par");
            return true;
        } else {
            //System.out.println("numero: " + numero + ", Es ImPar");
            return false;
        }
    }
    
    public static Materiales BetweenMaterial(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Materiales begin = FirtsMaterial();
        Materiales last = LastMaterial();
        System.out.println(begin.getIdMateriales());
        System.out.println(last.getIdMateriales());
        // size = 1 + 12 = 13
        // 13 / 2 = 6.5
        boolean continuar = true;
        while (continuar!=false)
        {
            int size = begin.getIdMateriales()+last.getIdMateriales();
            System.out.println(size);
            int resultado = size/2;
            System.out.println(resultado);
            //Resultado = 13
            if(IsPar(resultado)==true)
            {
                Materiales between = ConsultasMateriales.UnicoMaterial(resultado); 
                System.out.println("-"+between.getIdMateriales());
                if(between==null){
                 continuar =false;   
                }
            }//Fin IF IsPar
            else
            {
               size++;
               System.out.println(size);
               continuar=true;
            }//Fin Else IF IsPar
        }//Fin While
        return null;
    }
    public static Materiales BetwMaterial(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Materiales begin = FirtsMaterial();
        Materiales last = LastMaterial();
        
        boolean continuar = true;
        while (continuar!=true) {            
        int size = begin.getIdMateriales()+last.getIdMateriales();
            System.out.println(size);
        //size = 30
        if(IsPar(size)!=true){
            size++;
        }
            System.err.println(size);
            Materiales busqueda =UnicoMaterial(size);
            if(busqueda==null)
            {
                size++;
                System.out.println(busqueda.getIdMateriales());
            }else{
                continuar = false;
                return busqueda;
            }
        }
        return null;
    }
    public static void main (String args[]){
        System.out.println(BetwMaterial());
    }
    public static Materiales BeforeMaterial(int busqueda){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Materiales limite = ConsultasMateriales.UnicoMaterial(busqueda);
        if(limite!=null){
            Materiales last = LastMaterial();
            boolean continuar =true;
            int id = limite.getIdMateriales();
            int index = last.getIdMateriales();
            while (continuar!=false) {                   
                if (id<index) {
                    id++;
                    Materiales material = ConsultasMateriales.UnicoMaterial(id);
                    if(material!=null){
                        System.out.println(id);
                        continuar =false;
                        return material;
                    }
                }else{
                    System.out.println(id);
                    continuar =false;
                    return limite;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ya no existe un despues registro");
            return limite;
        }
         return limite;
    }
    
    
    public static Materiales LastMaterial(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        int ids = (int) sesion.createCriteria(Materiales.class)
                    .setProjection(Projections.max("idMateriales"))
                    .setMaxResults(1)
                    .uniqueResult();
        Materiales id = ConsultasMateriales.UnicoMaterial(ids);
        sesion.close();
        return id;
    }
    public static Materiales FirtsMaterial(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        int ids = (int) sesion.createCriteria(Materiales.class)
                    .setProjection(Projections.min("idMateriales"))
                    .uniqueResult();
        Materiales id = ConsultasMateriales.UnicoMaterial(ids);
        sesion.close();
        return id;
    }
    public static Detallesmateriales AfterDetallesMaterial(int busqueda){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Detallesmateriales limite = ConsultasMateriales.UnicoDetalleMaterial(busqueda);
        if(limite!=null){
            Detallesmateriales last = LastDetallesMaterial();
            boolean continuar =true;
            int id = limite.getIdDetalleMaterial();
            int index = last.getIdDetalleMaterial();
            while (continuar!=false) {                   
                if (id<index) {
                    id++;
                    Detallesmateriales material = ConsultasMateriales.UnicoDetalleMaterial(id);
                    if(material!=null){
                        //System.out.println(id);
                        continuar =false;
                        return material;
                    }
                }else{
                    //System.out.println(id);
                    continuar =false;
                    return limite;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ya no existe un despues registro");
            return limite;
        }
         return limite;
    }
    public static Detallesmateriales BeforeDetallesMaterial(int busqueda){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Detallesmateriales limite = ConsultasMateriales.UnicoDetalleMaterial(busqueda);
        if(limite!=null){
            Detallesmateriales inicio = FirtsDetallesMaterial();
            boolean continuar =true;
            int id = limite.getIdDetalleMaterial();
            int index = inicio.getIdDetalleMaterial();
            while (continuar!=false) {                   
                if (id>index) {
                    id--;
                    Detallesmateriales material = ConsultasMateriales.UnicoDetalleMaterial(id);
                    if(material!=null){
                        //System.out.println(id);  
                        continuar =false;
                        return material;
                    }
                }else{
                    //System.out.println(id);
                    continuar =false;
                    return limite;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ya no existe un registro antes");
            
        }
         return limite;   
    }
    
    public static Detallesmateriales FirtsDetallesMaterial(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        int ids = (int) sesion.createCriteria(Detallesmateriales.class)
                    .setProjection(Projections.min("idDetalleMaterial"))
                    .uniqueResult();
        Detallesmateriales id = ConsultasMateriales.UnicoDetalleMaterial(ids);
        sesion.close();
        return id;
    }
    public static Detallesmateriales LastDetallesMaterial(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        int ids = (int) sesion.createCriteria(Detallesmateriales.class)
                    .setProjection(Projections.max("idDetalleMaterial"))
                    .uniqueResult();
        Detallesmateriales id = ConsultasMateriales.UnicoDetalleMaterial(ids);
        sesion.close();
        return id;
    }
    public static List<Materiales>ListaMaterial (){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        List<Materiales> lista = sesion.createCriteria(Materiales.class).list();
        return lista;
    }
    public static List<Materiales>ListaMaterial(String material){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        List<Materiales> lista = sesion.createCriteria(Materiales.class)
                .add(Restrictions.like("material", "%"+material+"%"))
                .list();
        return lista;
    }
    public static Materiales UnicoMaterial (int id){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Materiales material = (Materiales) sesion.createCriteria(Materiales.class)
                .add(Restrictions.eq("idMateriales", id))
                .uniqueResult();
        if(material!=null)
        {
            return material;
        }
        else
        {
            return null;
        }
    }
    
    public static List<Ubicacion> ListaUbicacion(){        
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        List<Ubicacion> lista = sesion.createCriteria(Ubicacion.class).list();
        return lista;
    }
    public static List<Ubicacion> ListaUbicacionSeccion(String seccion){        
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        List<Ubicacion> lista = sesion.createCriteria(Ubicacion.class)
                .add(Restrictions.like("seccion", "%"+seccion+"%"))
                .list();
        return lista;
    }
    public static List<Ubicacion> ListaUbicacionAnaquel(String anaquel){        
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        List<Ubicacion> lista = sesion.createCriteria(Ubicacion.class)
                .add(Restrictions.like("anaquel",anaquel, MatchMode.ANYWHERE))
                .list();
        return lista;
    }
    public static Ubicacion UnicaUbicacion (int id){        
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Ubicacion ubicacion = (Ubicacion) sesion.createCriteria(Ubicacion.class)
                .add(Restrictions.eq("idUbicacion", id))
                .uniqueResult();
        if(ubicacion!=null)
        {
        return ubicacion;
        }
        else
        {
            return null;
        }
    }
    
    public static List<Detallesmateriales> ListaDetallesMateriales (){
        Session sesion= HibernateUtil.getSessionFactory().openSession();        
        List<Detallesmateriales> lista = sesion.createCriteria(Detallesmateriales.class).list();
        return lista;
    }
    
    public static List<Detallesmateriales> ListaDetallesMaterialesCodigo (String codigo){
        Session sesion= HibernateUtil.getSessionFactory().openSession();        
        List<Detallesmateriales> lista = sesion.createCriteria(Detallesmateriales.class)
                //.add(Restrictions.ltProperty("codigo", "detalles"))
                .add(Restrictions.like("codigo", "%"+codigo+"%"))
                //.add(Restrictions.like("detalles", codigo))
                .list();
        return lista;
    }
    public static List<Detallesmateriales> ListaDetallesMaterialesDetalles (String detalles){
        Session sesion= HibernateUtil.getSessionFactory().openSession();        
        List<Detallesmateriales> lista = sesion.createCriteria(Detallesmateriales.class)
                .add(Restrictions.like("detalles","%"+detalles+"%"))
                .list();
        return lista;
    }
//    public static List<Detallesmateriales> ListaDetallesMaterialesCodigo2 (String codigo){
//        Session sesion= HibernateUtil.getSessionFactory().openSession();        
//        List<Detallesmateriales> lista = sesion.createCriteria(Detallesmateriales.class)
//                .add(Restrictions.ilike("codigo", "%"+codigo+"%"))
//                .list();
//        return lista;
//    }
//    
    public static Detallesmateriales UnicoDetalleMaterial (int id){        
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Detallesmateriales detalles = (Detallesmateriales) sesion.createCriteria(Detallesmateriales.class)
                .add(Restrictions.eq("idDetalleMaterial", id))
                .uniqueResult();
        if(detalles!=null)
        {
        return detalles;
        }
        else
        {
            return null;
        }
    }
    
    
    
    
    public static List<Unidades> ListaUnidades(){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        List<Unidades> lista = sesion.createCriteria(Unidades.class).list();
        return lista;
    }
    public static List<Unidades> ListaUnidades(String unidad){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        List<Unidades> lista = sesion.createCriteria(Unidades.class)
                .add(Restrictions.like("unidad", unidad, MatchMode.ANYWHERE))
                .list();
        return lista;
    }
    public static Unidades UnicaUnidad (int id){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Unidades unidad = (Unidades) sesion.createCriteria(Unidades.class)
                .add(Restrictions.eq("idUnidades", id))
                .uniqueResult();
        if(unidad!=null)
        {
        return unidad;
        }
        else
        {
            return null;
        }
    }
    public static Unidades UnicaUnidad (String id){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Unidades unidad = (Unidades) sesion.createCriteria(Unidades.class)
                .add(Restrictions.eq("unidad", id))
                .uniqueResult();
        if(unidad!=null)
        {
        return unidad;
        }
        else
        {
            return null;
        }
    }
    public static List<Estado> ListaEstado(){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        List<Estado> lista = sesion.createCriteria(Estado.class).list();
        return lista;
    }
    
    public static Estado UnicoEstado (int id){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Estado estado = (Estado) sesion.createCriteria(Estado.class)
                .add(Restrictions.eq("idEstado", id))
                .uniqueResult();
        if(estado!=null)
        {
        return estado;
        }
        else
        {
            return null;
        }
    }
    public static Estado UnicoEstado (String id){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Estado estado = (Estado) sesion.createCriteria(Estado.class)
                .add(Restrictions.eq("estado", id))
                .uniqueResult();
        if(estado!=null)
        {
        return estado;
        }
        else
        {
            return null;
        }
    }        
    public static List<Marcas> ListaMarca(){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        List<Marcas> lista = sesion.createCriteria(Marcas.class).list();
        return lista;
    }
    public static List<Marcas> ListaMarca(String marca){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        List<Marcas> lista = sesion.createCriteria(Marcas.class)
                .add(Restrictions.like("marca", "%"+marca+"%"))
                .list();
        return lista;
    }
    public static Marcas UnicaMarca (int id){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Marcas marca = (Marcas) sesion.createCriteria(Marcas.class)
                .add(Restrictions.eq("idMarca", id))
                .uniqueResult();
        if(marca!=null)
        {
        return marca;
        }
        else
        {
            return null;
        }
    }
    public static Marcas UnicaMarca (String id){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Marcas marca = (Marcas) sesion.createCriteria(Marcas.class)
                .add(Restrictions.eq("marca", id))
                .uniqueResult();
        if(marca!=null)
        {
        return marca;
        }
        else
        {
            return null;
        }
    }
    /*Este codigo es para probar las consultas
    public static void main (String args[]){
        //System.out.println(FirtsMaterial().getMaterial());
        //System.out.println(LastMaterial().getMaterial());        
        System.out.println(AfterMaterial(Integer.parseInt(JOptionPane.showInputDialog("After"))).getMaterial());
        //AfterMaterial(Integer.parseInt(JOptionPane.showInputDialog("After"))).getMaterial();
        System.out.println(BeforeMaterial(Integer.parseInt(JOptionPane.showInputDialog("Before"))));
    }
    */
}
