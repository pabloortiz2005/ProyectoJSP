package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SeleccionarRolServlet", urlPatterns = {"/seleccionarRol"})
public class SeleccionarRolServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rol = request.getParameter("rol");

        if ("admin".equals(rol)) {
            response.sendRedirect("admin.jsp"); // Página para el administrador
        } else {
            response.sendRedirect("usuario.jsp"); // Página para usuario normal
        }
    }
}
