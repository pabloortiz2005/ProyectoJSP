<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Proyecto</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
    <div class="contenedor">
        <h2>Agregar Nuevo Proyecto</h2>
        <form action="AgregarProyecto" method="POST">
            <label>Nombre del Proyecto:</label>
            <input type="text" name="nombre_proyecto" required><br>

            <label>Descripción:</label>
            <textarea name="descripcion" required></textarea><br>

            <label>Fecha Inicio:</label>
            <input type="date" name="fecha_inicio" required><br>

            <label>Fecha Fin:</label>
            <input type="date" name="fecha_fin" required><br>

            <label>Estado:</label>
            <select name="estado">
                <option value="EN_CURSO">En Curso</option>
                <option value="COMPLETADO">Completado</option>
            </select><br>

            <input type="submit" value="Guardar">
        </form>

        <br>
        <a href="listarProyectos.jsp">Volver a la lista</a>
    </div>
</body>
</html>
