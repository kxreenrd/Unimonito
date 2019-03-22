/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.UsuarioDAO;
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
            
            out.println("<title>ADMIN</title>");            
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
                if(p.getRolIdrol() == 1){
                    out.println(admin());
                } else if(p.getRolIdrol() == 2){
                    out.println(user());
                }
                //out.println("<h2> ->"+p.getNombres()+"</h2>");
            }
            out.println("</div>");
            
            /*out.println("<script>\n" +
                    "        function click_btn(id){\n" +
                    "            document.getElementById(id).style.display = 'block';"
                    + "var con = document.getElementsByClassName('container');" +
                    "for(var i =1; i < con.length; i++){"
                        //+ "console.log(con[i]['style'].display);"
                        + "if(con[i].id != id){"
                            + "document.getElementById(con[i].id).style.siplay = 'none'; "
                        + "}"
                    + "}"+
                    "            console.log(document.getElementsByClassName('container'))" +
                    "        }\n" +
                    "        \n" +
                    "        \n" +
                    "    </script>");*/
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private String admin(){
        //tabla con rifa y apuestas
        String boton = 
                /*"<div class=\"btn-group btn-group-justified\">" +
"            <a href=\"#\" class=\"btn btn-primary\" onclick=\"click_btn('insert_torneo')\"> Crear Torneos </a>" +
"            <a href=\"#\" class=\"btn btn-primary\" onclick=\"click_btn('insert_apuesta')\">Crear Apuestas</a>" +
"            <a href=\"#\" class=\"btn btn-primary\" onclick=\"click_btn('insert_rifa')\">Crear rifa</a>" +
"        </div>"+*/
        
                
        "<div id=\"insert_apuesta\" class=\"container col-sm-4 container_ins\">\n" +
"            <h2>Registro de apuesta</h2>\n" +
"            <form action=\"apuestaServlet\" method=\"POST\">\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"nombre_usuario\">Nombres:</label>\n" +
"                    <input type=\"text\" class=\"form-control\" placeholder=\"Enter nombre\" name=\"nombre_usuario\">\n" +
"                </div>\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"apellido_usuario\">Apelidos:</label>\n" +
"                    <input type=\"text\" class=\"form-control\" placeholder=\"Enter apellido\" name=\"apellido_usuario\">\n" +
"                </div>\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"identificacion\">Identificación:</label>\n" +
"                    <input type=\"number\" class=\"form-control\" placeholder=\"Enter identificacion\" name=\"identificacion\">\n" +
"                </div>                \n" +
"                <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n" +
"            </form>\n" +
"        </div>"+
        
                
        "<div id=\"insert_rifa\" class=\"container col-sm-4 container_ins\">\n" +
"            <h2>Registro de rifa</h2>\n" +
"            <form action=\"rifasServlet\" method=\"POST\">\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"premio\">Premio:</label>\n" +
"                    <input type=\"text\" class=\"form-control\" placeholder=\"Enter premio\" name=\"premio\">\n" +
"                </div>\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"numero_boletas\">Número de boletas:</label>\n" +
"                    <input type=\"number\" class=\"form-control\" placeholder=\"Enter numero de boletas\" name=\"num_boletas\">\n" +
"                </div>                \n" +
                "<div class=\"form-group\">\n" +
"                    <label for=\"f_inicio\">Fecha inicio:</label>\n" +
"                    <input type=\"datetime-local\" class=\"form-control\"  name=\"f_inicio\">\n" +
"                </div>\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"f_fin\">Fecha fin:</label>\n" +
"                    <input type=\"datetime-local\" class=\"form-control\" name=\"f_fin\">\n" +
"                </div>                \n" +
"                <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n" +
"            </form>\n" +
"        </div>"
                
                
                
                
                
                ; 
        return boton;
    }
    
    private String user(){
        //tabla con rifa y apuestas
        String boton = "<div class=\"btn-group btn-group-justified\">" +
"            <a href=\"DeporteServlet\" class=\"btn btn-primary\"> Rifas</a>" +
"            <a href=\"#\" class=\"btn btn-primary\">Apuestas</a>" +
"        </div>"; 
        return boton;
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
