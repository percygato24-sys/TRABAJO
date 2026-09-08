<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.miportafolio.model.Usuario" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Panel Principal - Portafolio</title>
</head>
<body>
    <h2>Bienvenido, <%= usuario.getNombre() %>!</h2>
    <p><a href="logout">Cerrar Sesión</a></p>

    <hr>

    <h3>Subir Nuevo Archivo</h3>
    <form action="subir-archivo" method="post" enctype="multipart/form-data">
        <input type="file" name="archivo" required>
        <button type="submit">Subir</button>
    </form>

    <hr>

    <h3>Tus Archivos Guardados</h3>
    <!-- Aquí renderizaremos la lista de archivos dinámicamente -->
</body>
</html>