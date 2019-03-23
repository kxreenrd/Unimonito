/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.DeportesDAO;
import DAO.UsuarioDAO;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karen Rodriguez
 */
@WebServlet(name = "crearUsuario", urlPatterns = {"/crearUsuario"})
public class crearUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String nombre, apellido, id, identificacion;
    boolean usuario;
    
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
            
            out.println("<title>USER NEW </title>");            
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
            
            out.println("<div class=\"jumbotron text-center\">\n" +
"            <h1>¡Bienvenido "+ nombre +"  "+ apellido + "! </h1> \n" +
"            <p>Su usuario ha sifo creado con exito, por favor ingrese.</p> \n" +
"        </div>");
            
            out.println("<div class='contenido_pagina'>");
            if(usuario){
                out.println("<div id=\"ingresar_us_creado\" class=\"card col-sm-4\" >\n" +
"            <h2>Ingresar</h2>\n" +
"            <form action=\"ingresar_usuario\" method=\"POST\">\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"identificacion\">Identificacion:</label>\n" +
"                    <input type=\"number\" class=\"form-control\" placeholder=\"Enter email\" name=\"identificacion\">\n" +
"                </div>\n" +
"                <div class=\"checkbox\">\n" +
"                    <label><a onclick=\"click_btn()\">Registrarme</a></label>\n" +
"                </div>\n" +
"                <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n" +
"            </form>\n" +
"        </div>");
            } else {
                out.println("<h1>Lo sentimos su usuario ya esta registrado </h1>");
            }
            out.println("</div>");
            
            
            out.println("</body>");
            out.println("</html>");
        }
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
        
        
        nombre = request.getParameter("nombre_usuario");
        apellido = request.getParameter("apellido_usuario");
        identificacion = request.getParameter("identificacion");
        
        usuario = us.setUsuario(nombre, apellido, Integer.parseInt(identificacion));
        
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
