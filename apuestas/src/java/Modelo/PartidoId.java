package Modelo;
// Generated 13/03/2019 12:05:59 AM by Hibernate Tools 4.3.1



/**
 * PartidoId generated by hbm2java
 */
public class PartidoId  implements java.io.Serializable {


     private int idPartido;
     private int torneoIdTorneo;
     private int apuestaIdApuesta;

    public PartidoId() {
    }

    public PartidoId(int idPartido, int torneoIdTorneo, int apuestaIdApuesta) {
       this.idPartido = idPartido;
       this.torneoIdTorneo = torneoIdTorneo;
       this.apuestaIdApuesta = apuestaIdApuesta;
    }
   
    public int getIdPartido() {
        return this.idPartido;
    }
    
    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }
    public int getTorneoIdTorneo() {
        return this.torneoIdTorneo;
    }
    
    public void setTorneoIdTorneo(int torneoIdTorneo) {
        this.torneoIdTorneo = torneoIdTorneo;
    }
    public int getApuestaIdApuesta() {
        return this.apuestaIdApuesta;
    }
    
    public void setApuestaIdApuesta(int apuestaIdApuesta) {
        this.apuestaIdApuesta = apuestaIdApuesta;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PartidoId) ) return false;
		 PartidoId castOther = ( PartidoId ) other; 
         
		 return (this.getIdPartido()==castOther.getIdPartido())
 && (this.getTorneoIdTorneo()==castOther.getTorneoIdTorneo())
 && (this.getApuestaIdApuesta()==castOther.getApuestaIdApuesta());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdPartido();
         result = 37 * result + this.getTorneoIdTorneo();
         result = 37 * result + this.getApuestaIdApuesta();
         return result;
   }   


}


