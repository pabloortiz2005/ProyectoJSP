

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Agregar Proyecto</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
     <form action="seleccionarRol" method="POST">
        <label>Seleccione su rol:</label>
        <select name="rol">
            <option value="usuario">Usuario</option>
            <option value="admin">Administrador</option>
        </select>
        <br><br>
        <input type="submit" value="Continuar">
    </form>
   
</body>
</html>

