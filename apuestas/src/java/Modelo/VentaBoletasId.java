package Modelo;
// Generated 13/03/2019 12:05:59 AM by Hibernate Tools 4.3.1



/**
 * VentaBoletasId generated by hbm2java
 */
public class VentaBoletasId  implements java.io.Serializable {


     private int idVentaBoletas;
     private int boleteriaIdBoleteria;
     private int boleteriaApuestaIdApuesta;

    public VentaBoletasId() {
    }

    public VentaBoletasId(int idVentaBoletas, int boleteriaIdBoleteria, int boleteriaApuestaIdApuesta) {
       this.idVentaBoletas = idVentaBoletas;
       this.boleteriaIdBoleteria = boleteriaIdBoleteria;
       this.boleteriaApuestaIdApuesta = boleteriaApuestaIdApuesta;
    }
   
    public int getIdVentaBoletas() {
        return this.idVentaBoletas;
    }
    
    public void setIdVentaBoletas(int idVentaBoletas) {
        this.idVentaBoletas = idVentaBoletas;
    }
    public int getBoleteriaIdBoleteria() {
        return this.boleteriaIdBoleteria;
    }
    
    public void setBoleteriaIdBoleteria(int boleteriaIdBoleteria) {
        this.boleteriaIdBoleteria = boleteriaIdBoleteria;
    }
    public int getBoleteriaApuestaIdApuesta() {
        return this.boleteriaApuestaIdApuesta;
    }
    
    public void setBoleteriaApuestaIdApuesta(int boleteriaApuestaIdApuesta) {
        this.boleteriaApuestaIdApuesta = boleteriaApuestaIdApuesta;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VentaBoletasId) ) return false;
		 VentaBoletasId castOther = ( VentaBoletasId ) other; 
         
		 return (this.getIdVentaBoletas()==castOther.getIdVentaBoletas())
 && (this.getBoleteriaIdBoleteria()==castOther.getBoleteriaIdBoleteria())
 && (this.getBoleteriaApuestaIdApuesta()==castOther.getBoleteriaApuestaIdApuesta());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdVentaBoletas();
         result = 37 * result + this.getBoleteriaIdBoleteria();
         result = 37 * result + this.getBoleteriaApuestaIdApuesta();
         return result;
   }   


}

