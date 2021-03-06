package Model;
// Generated 16/12/2013 11:11:36 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Salidas generated by hbm2java
 */
public class Salidas  implements java.io.Serializable {


     private Integer idSalidas;
     private Pedidos pedidos;
     private Date fechaSalida;
     private String nota;
     private Set<Devoluciones> devolucioneses = new HashSet<Devoluciones>(0);

    public Salidas() {
    }

	
    public Salidas(Pedidos pedidos, Date fechaSalida, String nota) {
        this.pedidos = pedidos;
        this.fechaSalida = fechaSalida;
        this.nota = nota;
    }
    public Salidas(Pedidos pedidos, Date fechaSalida, String nota, Set<Devoluciones> devolucioneses) {
       this.pedidos = pedidos;
       this.fechaSalida = fechaSalida;
       this.nota = nota;
       this.devolucioneses = devolucioneses;
    }
   
    public Integer getIdSalidas() {
        return this.idSalidas;
    }
    
    public void setIdSalidas(Integer idSalidas) {
        this.idSalidas = idSalidas;
    }
    public Pedidos getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
    public Date getFechaSalida() {
        return this.fechaSalida;
    }
    
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public String getNota() {
        return this.nota;
    }
    
    public void setNota(String nota) {
        this.nota = nota;
    }
    public Set<Devoluciones> getDevolucioneses() {
        return this.devolucioneses;
    }
    
    public void setDevolucioneses(Set<Devoluciones> devolucioneses) {
        this.devolucioneses = devolucioneses;
    }




}


