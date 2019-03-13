package Modelo;
// Generated 13/03/2019 12:05:59 AM by Hibernate Tools 4.3.1



/**
 * RifaId generated by hbm2java
 */
public class RifaId  implements java.io.Serializable {


     private int idRifa;
     private int boleteriaIdBoleteria;
     private int boleteriaApuestaIdApuesta;
     private int premioIdPremio;

    public RifaId() {
    }

    public RifaId(int idRifa, int boleteriaIdBoleteria, int boleteriaApuestaIdApuesta, int premioIdPremio) {
       this.idRifa = idRifa;
       this.boleteriaIdBoleteria = boleteriaIdBoleteria;
       this.boleteriaApuestaIdApuesta = boleteriaApuestaIdApuesta;
       this.premioIdPremio = premioIdPremio;
    }
   
    public int getIdRifa() {
        return this.idRifa;
    }
    
    public void setIdRifa(int idRifa) {
        this.idRifa = idRifa;
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
    public int getPremioIdPremio() {
        return this.premioIdPremio;
    }
    
    public void setPremioIdPremio(int premioIdPremio) {
        this.premioIdPremio = premioIdPremio;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RifaId) ) return false;
		 RifaId castOther = ( RifaId ) other; 
         
		 return (this.getIdRifa()==castOther.getIdRifa())
 && (this.getBoleteriaIdBoleteria()==castOther.getBoleteriaIdBoleteria())
 && (this.getBoleteriaApuestaIdApuesta()==castOther.getBoleteriaApuestaIdApuesta())
 && (this.getPremioIdPremio()==castOther.getPremioIdPremio());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdRifa();
         result = 37 * result + this.getBoleteriaIdBoleteria();
         result = 37 * result + this.getBoleteriaApuestaIdApuesta();
         result = 37 * result + this.getPremioIdPremio();
         return result;
   }   


}

