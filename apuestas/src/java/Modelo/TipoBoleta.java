package Modelo;
// Generated 13/03/2019 12:05:59 AM by Hibernate Tools 4.3.1



/**
 * TipoBoleta generated by hbm2java
 */
public class TipoBoleta  implements java.io.Serializable {


     private int idTipoBoleta;
     private String nombre;

    public TipoBoleta() {
    }

	
    public TipoBoleta(int idTipoBoleta) {
        this.idTipoBoleta = idTipoBoleta;
    }
    public TipoBoleta(int idTipoBoleta, String nombre) {
       this.idTipoBoleta = idTipoBoleta;
       this.nombre = nombre;
    }
   
    public int getIdTipoBoleta() {
        return this.idTipoBoleta;
    }
    
    public void setIdTipoBoleta(int idTipoBoleta) {
        this.idTipoBoleta = idTipoBoleta;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}


