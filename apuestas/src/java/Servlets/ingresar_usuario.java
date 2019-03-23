/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.ApuestaDAO;
import DAO.UsuarioDAO;
import DAO.DeportesDAO;
import DAO.RifaDAO;
import Modelo.Apuesta;
import Modelo.Deporte;
import Modelo.Rifa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Karen Rodriguez
 */
@WebServlet(name = "ingresar_usuario", urlPatterns = {"/ingresar_usuario"})
public class ingresar_usuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String identificacion;
    List<Usuario> u = new ArrayList<Usuario>();
    RifaDAO r = new RifaDAO();
    List<Rifa> rifa = new ArrayList<Rifa>();
    ApuestaDAO a = new ApuestaDAO();
    List<Apuesta> apuesta = new ArrayList<Apuesta>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">");
            out.println("<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\">");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>");
            out.println("<link rel=\"stylesheet\"  type='text/css' href=\"css/cssIndex.css\">");
            
            out.println("<title>Unimonito</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<nav class=\"navbar navbar-default navbar-fixed-top\">\n" +
                "            <div class=\"container\">\n" +
                "                <div class=\"navbar-header\">\n" +
                "                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n" +
                "                        <span class=\"icon-bar\"></span>\n" +
                "                        <span class=\"icon-bar\"></span>\n" +
                "                        <span class=\"icon-bar\"></span>                        \n" +
                "                    </button>\n" +
                "                    <a class=\"navbar-brand\" href=\"index.html\">Unimonito</a>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </nav>");
            out.println("<div class='contenido_pagina'>");
            for(Usuario p:u){
                //out.println("<h3>"+u+"</h3>");
                if(p.getRolIdrol() == 1){
                    out.println(admin());
                } else if(p.getRolIdrol() == 2){
                    out.println("<div class=\"jumbotron text-center\">\n" +
                        "            <h1> Catalogo de Rifas y Apuestas </h1> \n" +
                        "            <p>Seleccione su preferida</p> \n" +
                        "        </div>");
                    out.println(user());
                } else{
                    out.println("<h1> Lo sentimos usted no esta registrado </h1>");
                }
                //out.println("<h2> ->"+p.getNombres()+"</h2>");
            }
            out.println("</div>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private String admin(){
        //tabla con rifa y apuestas
        
        String boton = 
                
        "<div id=\"insert_torneo\" class=\"container col-sm-5 container_ins\">\n" +
"            <h2>Registro de partido y apuesta</h2>\n" +
"            <form action=\"torneoServlet\" method=\"POST\">\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"nombre_usuario\">Equipo local:</label>\n" +
                        "<select name=\"local\">\n" +
                            "  <option value=\"1\">Los primeros</option>\n" +
                            "  <option value=\"2\">Los segundos</option>\n" +
                        "</select>"+
"                </div>\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"nombre_usuario\">Equipo visitante:</label>\n" +
                        "<select name=\"visitante\">\n" +
                            "  <option value=\"1\">Los primeros</option>\n" +
                            "  <option value=\"2\">Los segundos</option>\n" +
                        "</select>"+
"                </div>\n" +
                "<div class=\"form-group\">\n" +
"                    <label for=\"fecha\">Fecha:</label>\n" +
"                    <input type=\"date\" class=\"form-control\"  name=\"fecha\" min=\"2019-03-24\" value=\"2019-03-24\">\n" +
"                </div>\n" +
                "<div class=\"form-group\">\n" +
"                    <label for=\"h_inicio\">Hora inicio:</label>\n" +
"                    <input type=\"time\" class=\"form-control\"  name=\"h_inicio\" value=\"10:00\">\n" +
"                </div>\n" +
                "<div class=\"form-group\">\n" +
"                    <label for=\"h_fin\">Hora fin:</label>\n" +
"                    <input type=\"time\" class=\"form-control\"  name=\"h_fin\" value=\"10:00\">\n" +
"                </div>\n" +
                "<label > APUESTA </label>"+
"                <div class=\"form-group\">\n" +
"                    <label for=\"vmax\">Valor máximo:</label>\n" +
"                    <input type=\"number\" class=\"form-control\" name=\"vmax\" value=\"50000\">\n" +
"                </div>                \n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"vmin\">Valor minimo:</label>\n" +
"                    <input type=\"number\" class=\"form-control\" name=\"vmin\" value=\"10000\">\n" +
"                </div>                \n" +
"                <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n" +
"            </form>\n" +
"        </div>"+
                
        "<div id=\"insert_rifa\" class=\"container col-sm-5 container_ins\">\n" +
"            <h2>Registro de rifa</h2>\n" +
"            <form action=\"rifasServlet\" method=\"POST\">\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"premio\">Premio:</label>\n" +
"                    <input type=\"text\" class=\"form-control\" placeholder=\"premio\" name=\"premio\">\n" +
"                </div>\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"numero_boletas\">Número de boletas:</label>\n" +
"                    <input type=\"number\" class=\"form-control\" placeholder=\"numero de boletas\" name=\"num_boletas\">\n" +
"                </div>                \n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"valor_boleta\">Valor boleta:</label>\n" +
"                    <input type=\"number\" class=\"form-control\" placeholder=\"valor de boleta\" name=\"valor_boleta\">\n" +
"                </div>                \n" +
                "<div class=\"form-group\">\n" +
"                    <label for=\"f_inicio\">Hora inicio:</label>\n" +
"                    <input type=\"time\" class=\"form-control\"  name=\"f_inicio\">\n" +
"                </div>\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"f_fin\">Hora fin:</label>\n" +
"                    <input type=\"time\" class=\"form-control\" name=\"f_fin\">\n" +
"                </div>                \n" +
"                <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n" +
"            </form>\n" +
"        </div>"; 
        return boton;
    }
    
    private String user(){
        //tabla con rifa y apuestas
        String trifa ="";
        for(Rifa p:rifa){
            trifa += 
"                        <tr>\n" +
"                            <td>"+p.getPremio()+"</td>\n" +
"                            <td>"+p.getNumeroBoletas()+"</td>\n" +
"                            <td>"+p.getValor()+"</td>\n" +
"                            <td>"+p.getHoraFin()+"</td>\n" +
"                            <td><span class=\"label label-success\">"
                    + "<a href=\"boletaServlet\">Seleccionar</a>  </span></td>\n" +
"                        </tr>\n" ;
        }
        
        String tapuesta ="";
        for(Apuesta a:apuesta){
            tapuesta += 
"                        <tr>\n" +
"                            <td>"+a.getPartidoIdpartido()+"</td>\n" +
"                            <td>"+a.getValorMaximo()+"</td>\n" +
"                            <td>"+a.getValorMinimo()+"</td>\n" +
"                            <td><span class=\"label label-success\"> "
                    + "<a href=\"boletaServlet\">Seleccionar</a>  </span></td>\n" +
"                        </tr>\n" ;
        }
        
        String tabla = "<div id=\"ganadores\" class=\"container-fluid\">\n" +
"            <div class=\"text-center\">\n" +
//"                <h2>Ganadores</h2>\n" +
//"                <h4>En la siguiente lista se encontraran los ganadores de las diferentes rifas y apuestas</h4>\n" +
"            </div>\n" +
"            <div class=\"row \">\n" +
"                <div class=\"col-sm-6\">\n" +
"                    <div class=\"panel panel-default text-center\">\n" +
"                        <div class=\"panel-heading\">\n" +
"                            <h1>Rifas</h1>\n" +
"                        </div>\n" +
"                        <div class=\"panel-body\">\n" +
"                            <table class=\"table\">\n" +
"                    <thead>\n" +
"                        <tr>\n" +
"                            <th>Premio</th>\n" +
"                            <th>Numero boletas</th>\n" +
"                            <th>Valor boleta</th>\n" +
"                            <th>Hora fin</th>\n" +
"                            <th></th>\n" +
"                        </tr>\n" +
"                    </thead>\n" +
"                    <tbody>\n" + trifa +
"                    </tbody>\n" +
"                </table>\n" +
"                        </div>\n" +
"                        <div class=\"panel-footer\">\n" +
"                            \n" +
"                        </div>\n" +
"                    </div>      \n" +
"                </div>     \n" +
"                <div class=\"col-sm-6\">\n" +
"                    <div class=\"panel panel-default text-center\">\n" +
"                        <div class=\"panel-heading\">\n" +
"                            <h1>Apuestas</h1>\n" +
"                        </div>\n" +
"                        <div class=\"panel-body\">\n" +
"                            <table class=\"table\">\n" +
"                    <thead>\n" +
"                        <tr>\n" +
"                            <th>Id partido</th>\n" +
"                            <th>Valor máximo </th>\n" +
"                            <th>Valor minimo </th>\n" +
"                            <th> </th>\n" +
"                        </tr>\n" +
"                    </thead>\n" +
"                    <tbody>\n" + tapuesta +
"                    </tbody>\n" +
"                </table>\n" +
"                        </div>\n" +
"                        <div class=\"panel-footer\">\n" +
"                            \n" +
"                        </div>\n" +
"                    </div>      \n" +
"                </div>         \n" +
"            </div>\n" +
"        </div>";
        
        return tabla;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuarioDAO us = new UsuarioDAO();
        
        identificacion = request.getParameter("identificacion");
        
        u = us.getUsuario(Integer.parseInt(identificacion));
        apuesta = a.getApuesta();
        rifa = r.getRifa();
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
