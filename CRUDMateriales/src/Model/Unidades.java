package Model;
// Generated 16/12/2013 11:11:36 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Unidades generated by hbm2java
 */
public class Unidades  implements java.io.Serializable {


     private Integer idUnidades;
     private String unidad;
     private Set<Detallesmateriales> detallesmaterialeses = new HashSet<Detallesmateriales>(0);

    public Unidades() {
    }

    public Unidades(String unidad, Set<Detallesmateriales> detallesmaterialeses) {
       this.unidad = unidad;
       this.detallesmaterialeses = detallesmaterialeses;
    }
   
    public Integer getIdUnidades() {
        return this.idUnidades;
    }
    
    public void setIdUnidades(Integer idUnidades) {
        this.idUnidades = idUnidades;
    }
    public String getUnidad() {
        return this.unidad;
    }
    
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    public Set<Detallesmateriales> getDetallesmaterialeses() {
        return this.detallesmaterialeses;
    }
    
    public void setDetallesmaterialeses(Set<Detallesmateriales> detallesmaterialeses) {
        this.detallesmaterialeses = detallesmaterialeses;
    }




}

