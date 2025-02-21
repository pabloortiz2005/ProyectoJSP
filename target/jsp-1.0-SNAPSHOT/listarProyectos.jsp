<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Entities.Proyectos" %>
<html>
<head>
    <title>Lista de Proyectos</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
    <div class="contenedor">
        <h2>Lista de Proyectos</h2>

        <form action="ListarProyectos" method="GET">
            <label>Filtrar por estado:</label>
            <select name="estado">
                <option value="">Todos</option>
                <option value="EN_CURSO">En Curso</option>
                <option value="COMPLETADO">Completado</option>
            </select>
            <input type="submit" value="Filtrar">
        </form>

        <table border="2">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
            <%
                List<Proyectos> proyectos = (List<Proyectos>) request.getAttribute("proyectos");
                if (proyectos != null) {
                    for (Proyectos proyecto : proyectos) {
            %>
            <tr>
                <td><%= proyecto.getId() %></td>
                <td><%= proyecto.getNombre_proyecto() %></td>
                <td><%= proyecto.getDescripcion() %></td>
                <td><%= proyecto.getFecha_inicio() %></td>
                <td><%= proyecto.getFecha_fin() %></td>
                <td><%= proyecto.getEstado() %></td>
                <td>
                   <a href="ListarTareas?id_proyecto=<%= proyecto.getId() %>">Ver Tareas</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>

        <br>
        <a href="agregarProyecto.jsp">Agregar Nuevo Proyecto</a>
    </div>
</body>
</html>
