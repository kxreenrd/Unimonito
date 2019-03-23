/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.TorneoDAO;
import DAO.ApuestaDAO;
import Modelo.Apuesta;
import Modelo.Partido;
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
@WebServlet(name = "torneoServlet", urlPatterns = {"/torneoServlet"})
public class torneoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String e_local, e_visitante, fecha, h_i, h_f, vmx, vmn;
    int id;
    
    TorneoDAO r = new TorneoDAO();
    ApuestaDAO ap = new ApuestaDAO();
    List<Apuesta> u = new ArrayList<Apuesta>();
    List<Partido> pa = new ArrayList<Partido>();
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
            
            out.println("<title>APUESTA</title>");            
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
            
            /*out.println("<div class=\"jumbotron text-center\">\n" +
"            <h1>Información:</h1> \n" +
"            <p>El ganador de la rifa se seleccionara al acabar el tiempo de forma aleatoria.</p> \n" +
"        </div>");*/
            
            out.println("<div class='contenido_pagina'>");
            
            out.println("<div id=\"rifas\" class=\"container-fluid\">\n" +
"            <h2>APUESTAS</h2><br>\n" +
"            <div class=\"row\">\n" +
"                <table class=\"table\">\n" +
"                    <thead>\n" +
"                        <tr>\n" +
"                            <th>Id apuesta</th>\n" +
"                            <th>Valor máximo</th>\n" +
                            "<th>Valor minimo</th>\n" +
                            "<th>ID Partido</th>\n" +
                            "<th></th>\n" +
"                        </tr>\n" +
"                    </thead>\n" +
"                    <tbody>\n" );
            for(Apuesta p:u){
                out.println("<tr>\n" +
                            "<td>"+p.getIdapuesta()+"</td>\n" +
                            "<td>"+p.getValorMaximo()+"</td>\n" +
                            "<td>"+p.getValorMinimo()+"</td>\n" +
                            "<td>"+p.getPartidoIdpartido()+"</td>\n" +
"                            <td>\n" +
                                "<span class=\"label label-success\"> Editar </span>\n" +
                                "<span class=\"label label-danger\"> Eliminar </span>\n" +
                                "<span class=\"label label-warning\"> Cerrar </span>\n" +
"                            </td>\n" +
"                        </tr>\n");
            }
            
                    out.println("</tbody>\n" +
"                </table>\n" +
"            </div>\n" +
"        </div>");
            
            
            //out.println("<h1>Servlet rifasServlet at " + pa + "</h1>");
            
            
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
        
        e_local = request.getParameter("local");
        e_visitante= request.getParameter("visitante"); 
        fecha = request.getParameter("fecha");
        h_i = request.getParameter("h_inicio"); 
        h_f = request.getParameter("h_fin");
        
        vmx = request.getParameter("vmax");
        vmn = request.getParameter("vmin");
        
        pa = r.setPartido(Integer.parseInt(e_local), Integer.parseInt(e_visitante), fecha, h_i, h_f);
        for(Partido p:pa){
            id = p.getIdpartido();
        }
        u = ap.setApuesta(id, Integer.parseInt(vmx), Integer.parseInt(vmn));
        
        
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
