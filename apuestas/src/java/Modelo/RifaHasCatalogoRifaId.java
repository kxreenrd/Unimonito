package Modelo;
// Generated 13/03/2019 12:05:59 AM by Hibernate Tools 4.3.1



/**
 * RifaHasCatalogoRifaId generated by hbm2java
 */
public class RifaHasCatalogoRifaId  implements java.io.Serializable {


     private int rifaIdRifa;
     private int rifaBoleteriaIdBoleteria;
     private int rifaBoleteriaApuestaIdApuesta;
     private int rifaPremioIdPremio;
     private int catalogoRifaIdCatalogoRifa;

    public RifaHasCatalogoRifaId() {
    }

    public RifaHasCatalogoRifaId(int rifaIdRifa, int rifaBoleteriaIdBoleteria, int rifaBoleteriaApuestaIdApuesta, int rifaPremioIdPremio, int catalogoRifaIdCatalogoRifa) {
       this.rifaIdRifa = rifaIdRifa;
       this.rifaBoleteriaIdBoleteria = rifaBoleteriaIdBoleteria;
       this.rifaBoleteriaApuestaIdApuesta = rifaBoleteriaApuestaIdApuesta;
       this.rifaPremioIdPremio = rifaPremioIdPremio;
       this.catalogoRifaIdCatalogoRifa = catalogoRifaIdCatalogoRifa;
    }
   
    public int getRifaIdRifa() {
        return this.rifaIdRifa;
    }
    
    public void setRifaIdRifa(int rifaIdRifa) {
        this.rifaIdRifa = rifaIdRifa;
    }
    public int getRifaBoleteriaIdBoleteria() {
        return this.rifaBoleteriaIdBoleteria;
    }
    
    public void setRifaBoleteriaIdBoleteria(int rifaBoleteriaIdBoleteria) {
        this.rifaBoleteriaIdBoleteria = rifaBoleteriaIdBoleteria;
    }
    public int getRifaBoleteriaApuestaIdApuesta() {
        return this.rifaBoleteriaApuestaIdApuesta;
    }
    
    public void setRifaBoleteriaApuestaIdApuesta(int rifaBoleteriaApuestaIdApuesta) {
        this.rifaBoleteriaApuestaIdApuesta = rifaBoleteriaApuestaIdApuesta;
    }
    public int getRifaPremioIdPremio() {
        return this.rifaPremioIdPremio;
    }
    
    public void setRifaPremioIdPremio(int rifaPremioIdPremio) {
        this.rifaPremioIdPremio = rifaPremioIdPremio;
    }
    public int getCatalogoRifaIdCatalogoRifa() {
        return this.catalogoRifaIdCatalogoRifa;
    }
    
    public void setCatalogoRifaIdCatalogoRifa(int catalogoRifaIdCatalogoRifa) {
        this.catalogoRifaIdCatalogoRifa = catalogoRifaIdCatalogoRifa;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RifaHasCatalogoRifaId) ) return false;
		 RifaHasCatalogoRifaId castOther = ( RifaHasCatalogoRifaId ) other; 
         
		 return (this.getRifaIdRifa()==castOther.getRifaIdRifa())
 && (this.getRifaBoleteriaIdBoleteria()==castOther.getRifaBoleteriaIdBoleteria())
 && (this.getRifaBoleteriaApuestaIdApuesta()==castOther.getRifaBoleteriaApuestaIdApuesta())
 && (this.getRifaPremioIdPremio()==castOther.getRifaPremioIdPremio())
 && (this.getCatalogoRifaIdCatalogoRifa()==castOther.getCatalogoRifaIdCatalogoRifa());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getRifaIdRifa();
         result = 37 * result + this.getRifaBoleteriaIdBoleteria();
         result = 37 * result + this.getRifaBoleteriaApuestaIdApuesta();
         result = 37 * result + this.getRifaPremioIdPremio();
         result = 37 * result + this.getCatalogoRifaIdCatalogoRifa();
         return result;
   }   


}

