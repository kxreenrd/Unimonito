/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.RifaDAO;
import Modelo.Rifa;
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
@WebServlet(name = "rifasServlet", urlPatterns = {"/rifasServlet"})
public class rifasServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String premio, num_boletas, f_inicio, f_fin;
    RifaDAO r = new RifaDAO();
     List<Rifa> u = new ArrayList<Rifa>();
     
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //u = r.getRifa();
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
            
            out.println("<div id=\"rifas\" class=\"container-fluid\">\n" +
"            <h2>Rifas</h2><br>\n" +
"            <div class=\"row\">\n" +
"                <table class=\"table\">\n" +
"                    <thead>\n" +
"                        <tr>\n" +
"                            <th>Premio</th>\n" +
"                            <th>Cantidad de boletas</th>\n" +
                    "<th>Fecha inicio</th>\n" +
                    "<th>Fecha fin</th>\n" +
"                        </tr>\n" +
"                    </thead>\n" +
"                    <tbody>\n" );
            for(Rifa p:u){
                out.println("<tr>\n" +
                            "<td>"+p.getPremio()+"</td>\n" +
"                            <td>\n" +
"                                <span class=\"label label-primary\">"+p.getNumeroBoletas()+"</span>\n" +
"                            </td>\n" +
                            "<td>"+p.getFechaInicio()+"</td>\n" +
                            "<td>"+p.getFechaFin()+"</td>\n" +
"                        </tr>\n");
            }
            
                    out.println("</tbody>\n" +
"                </table>\n" +
"            </div>\n" +
"        </div>");
            
            
            //out.println("<h1>Servlet rifasServlet at " + f_inicio + "</h1>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        
        
        premio = request.getParameter("premio");
        num_boletas = request.getParameter("num_boletas");
        f_inicio = request.getParameter("f_inicio");
        f_fin = request.getParameter("f_fin");
        
        u = r.setRifa(premio, Integer.parseInt(num_boletas), f_inicio, f_fin);
        
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
