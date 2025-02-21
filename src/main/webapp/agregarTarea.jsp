<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Tarea</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
    <div class="contenedor">
        <h2>Agregar Nueva Tarea</h2>
        <form action="AgregarTarea" method="POST">
            <input type="hidden" name="id_proyecto" value="<%= request.getParameter("id_proyecto") %>">

            <label>Descripción:</label>
            <textarea name="descripcion_tarea" required></textarea><br>

            <label>Responsable:</label>
            <input type="text" name="responsable" required><br>

            <label>Fecha Inicio:</label>
            <input type="date" name="fecha_inicio" required><br>

            <label>Fecha Fin:</label>
            <input type="date" name="fecha_fin" required><br>

            <label>Estado:</label>
            <select name="estado">
                <option value="PENDIENTE">Pendiente</option>
                <option value="EN_PROGRESO">En Progreso</option>
                <option value="COMPLETADA">Completada</option>
            </select><br>

            <input type="submit" value="Guardar">
        </form>

        <br>
        <a href="listarTareas?id_proyecto=<%= request.getParameter("id_proyecto") %>">Volver a la lista de tareas</a>
    </div>
</body>
</html>
