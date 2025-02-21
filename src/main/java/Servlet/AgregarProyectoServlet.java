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
@WebServlet(name = "AgregarProyectoServlet", urlPatterns = {"/AgregarProyecto"})
public class AgregarProyectoServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String nombre = request.getParameter("nombre_proyecto");
        String descripcion = request.getParameter("descripcion");
        LocalDate fechaInicio = LocalDate.parse(request.getParameter("fecha_inicio"));
        LocalDate fechaFin = LocalDate.parse(request.getParameter("fecha_fin"));
        Estado estado = Estado.valueOf(request.getParameter("estado").toUpperCase());

        Proyectos proyecto = new Proyectos();
        proyecto.setNombre_proyecto(nombre);
        proyecto.setDescripcion(descripcion);
        proyecto.setFecha_inicio(fechaInicio);
        proyecto.setFecha_fin(fechaFin);
        proyecto.setEstado(estado);

        ProyectoDAO proyectoDAO = new ProyectoDAO();
        proyectoDAO.guardarProyecto(proyecto);

        response.sendRedirect("listarProyectos.jsp");
    }
}

