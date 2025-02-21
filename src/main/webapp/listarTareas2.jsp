<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Entities.Tareas" %>
<html>
<head>
    <title>Lista de Tareas</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
    <div class="contenedor">
        <h2>Lista de Tareas</h2>

        <form action="ListarTareas2" method="GET">
            <input type="hidden" name="id_proyecto" value="<%= request.getParameter("id_proyecto") %>">
            <button type="submit">Actualizar Lista</button>
        </form>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Descripción</th>
                <th>Responsable</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
                <th>Estado</th>
            </tr>
            <%
                List<Tareas> tareas = (List<Tareas>) request.getAttribute("tareas");
                if (tareas != null) {
                    for (Tareas tarea : tareas) {
            %>
            <tr>
                <td><%= tarea.getId() %></td>
                <td><%= tarea.getDescripcion_tarea() %></td>
                <td><%= tarea.getResponsable() %></td>
                <td><%= tarea.getFecha_inicio() %></td>
                <td><%= tarea.getFecha_fin() %></td>
                <td><%= tarea.getEstado() %></td>    
            </tr>
            <%
                    }
                }
            %>
        </table>

        <br>
        <br>
        <a href="listarProyectos2.jsp">Volver a Proyectos</a>
    </div>
</body>
</html>
