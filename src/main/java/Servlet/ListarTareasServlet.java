/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.TareaDAO;
import Entities.Tareas;
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
@WebServlet(name = "ListarTareasServlet", urlPatterns = {"/ListarTareas"})
public class ListarTareasServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int idProyecto = Integer.parseInt(request.getParameter("id_proyecto"));

        TareaDAO tareaDAO = new TareaDAO();
        List<Tareas> tareas = tareaDAO.obtenerTareasPorProyecto(idProyecto);

        request.setAttribute("tareas", tareas);
        request.getRequestDispatcher("listarTareas.jsp").forward(request, response);
    }
}
