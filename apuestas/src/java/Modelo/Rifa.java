package Modelo;
// Generated 23/03/2019 12:44:13 AM by Hibernate Tools 4.3.1



/**
 * Rifa generated by hbm2java
 */
public class Rifa  implements java.io.Serializable {


     private int idrifa;
     private String premio;
     private int numeroBoletas;
     private String horaInicio;
     private String horaFin;
     private int valor;
     private int activo;

    public Rifa() {
    }

    public Rifa(int idrifa, String premio, int numeroBoletas, String horaInicio, String horaFin, int valor, int activo) {
       this.idrifa = idrifa;
       this.premio = premio;
       this.numeroBoletas = numeroBoletas;
       this.horaInicio = horaInicio;
       this.horaFin = horaFin;
       this.valor = valor;
       this.activo = activo;
    }
   
    public int getIdrifa() {
        return this.idrifa;
    }
    
    public void setIdrifa(int idrifa) {
        this.idrifa = idrifa;
    }
    public String getPremio() {
        return this.premio;
    }
    
    public void setPremio(String premio) {
        this.premio = premio;
    }
    public int getNumeroBoletas() {
        return this.numeroBoletas;
    }
    
    public void setNumeroBoletas(int numeroBoletas) {
        this.numeroBoletas = numeroBoletas;
    }
    public String getHoraInicio() {
        return this.horaInicio;
    }
    
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    public String getHoraFin() {
        return this.horaFin;
    }
    
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
    public int getValor() {
        return this.valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getActivo() {
        return this.activo;
    }
    
    public void setActivo(int activo) {
        this.activo = activo;
    }




}


