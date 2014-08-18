package Model;
// Generated 16/12/2013 11:11:36 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Ubicacion generated by hbm2java
 */
public class Ubicacion  implements java.io.Serializable {


     private Integer idUbicacion;
     private String anaquel;
     private String seccion;
     private Set<Materiales> materialeses = new HashSet<Materiales>(0);

    public Ubicacion() {
    }

	
    public Ubicacion(String anaquel, String seccion) {
        this.anaquel = anaquel;
        this.seccion = seccion;
    }
    public Ubicacion(String anaquel, String seccion, Set<Materiales> materialeses) {
       this.anaquel = anaquel;
       this.seccion = seccion;
       this.materialeses = materialeses;
    }
   
    public Integer getIdUbicacion() {
        return this.idUbicacion;
    }
    
    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }
    public String getAnaquel() {
        return this.anaquel;
    }
    
    public void setAnaquel(String anaquel) {
        this.anaquel = anaquel;
    }
    public String getSeccion() {
        return this.seccion;
    }
    
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    public Set<Materiales> getMaterialeses() {
        return this.materialeses;
    }
    
    public void setMaterialeses(Set<Materiales> materialeses) {
        this.materialeses = materialeses;
    }




}


