/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ProyectoDAO;
import Entities.Estado;
import Entities.Proyectos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(name = "ListarProyectosServlet", urlPatterns = {"/ListarProyectos"})
public class ListarProyectosServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String estadoParam = request.getParameter("estado");
        Estado estado = null;

        if (estadoParam != null && !estadoParam.isEmpty()) {
            try {
                estado = Estado.valueOf(estadoParam.toUpperCase());
            } catch (IllegalArgumentException e) {
                estado = null;
            }
        }

        ProyectoDAO proyectoDAO = new ProyectoDAO();
        List<Proyectos> proyectos = proyectoDAO.obtenerProyectosPorEstado(estado);

        request.setAttribute("proyectos", proyectos);
        request.getRequestDispatcher("listarProyectos.jsp").forward(request, response);
    }
}
