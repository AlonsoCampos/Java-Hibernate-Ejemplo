package Model;
// Generated 16/12/2013 11:11:36 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Requesiciones generated by hbm2java
 */
public class Requesiciones  implements java.io.Serializable {


     private Integer idRequesiciones;
     private String requesicion;
     private Date fechaRequesicion;
     private Set<Detallespedidos> detallespedidoses = new HashSet<Detallespedidos>(0);

    public Requesiciones() {
    }

	
    public Requesiciones(String requesicion, Date fechaRequesicion) {
        this.requesicion = requesicion;
        this.fechaRequesicion = fechaRequesicion;
    }
    public Requesiciones(String requesicion, Date fechaRequesicion, Set<Detallespedidos> detallespedidoses) {
       this.requesicion = requesicion;
       this.fechaRequesicion = fechaRequesicion;
       this.detallespedidoses = detallespedidoses;
    }
   
    public Integer getIdRequesiciones() {
        return this.idRequesiciones;
    }
    
    public void setIdRequesiciones(Integer idRequesiciones) {
        this.idRequesiciones = idRequesiciones;
    }
    public String getRequesicion() {
        return this.requesicion;
    }
    
    public void setRequesicion(String requesicion) {
        this.requesicion = requesicion;
    }
    public Date getFechaRequesicion() {
        return this.fechaRequesicion;
    }
    
    public void setFechaRequesicion(Date fechaRequesicion) {
        this.fechaRequesicion = fechaRequesicion;
    }
    public Set<Detallespedidos> getDetallespedidoses() {
        return this.detallespedidoses;
    }
    
    public void setDetallespedidoses(Set<Detallespedidos> detallespedidoses) {
        this.detallespedidoses = detallespedidoses;
    }




}


