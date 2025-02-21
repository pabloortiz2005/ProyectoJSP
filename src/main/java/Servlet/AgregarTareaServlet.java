/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ProyectoDAO;
import DAO.TareaDAO;
import Entities.Estado;
import Entities.Proyectos;
import Entities.Tareas;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(name = "AgregarTareaServlet", urlPatterns = {"/AgregarTarea"})
public class AgregarTareaServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int idProyecto = Integer.parseInt(request.getParameter("id_proyecto"));
        String descripcion = request.getParameter("descripcion_tarea");
        String responsable = request.getParameter("responsable");
        LocalDate fechaInicio = LocalDate.parse(request.getParameter("fecha_inicio"));
        LocalDate fechaFin = LocalDate.parse(request.getParameter("fecha_fin"));
        Estado estado = Estado.valueOf(request.getParameter("estado").toUpperCase());

        ProyectoDAO proyectoDAO = new ProyectoDAO();
        Proyectos proyecto = proyectoDAO.obtenerProyectoPorId(idProyecto);

        Tareas tarea = new Tareas();
        tarea.setProyecto(proyecto);
        tarea.setDescripcion_tarea(descripcion);
        tarea.setResponsable(responsable);
        tarea.setFecha_inicio(fechaInicio);
        tarea.setFecha_fin(fechaFin);
        tarea.setEstado(estado);

        TareaDAO tareaDAO = new TareaDAO();
        tareaDAO.guardarTarea(tarea);

        response.sendRedirect("listarTareas.jsp?id_proyecto=" + idProyecto + "");
    }
}