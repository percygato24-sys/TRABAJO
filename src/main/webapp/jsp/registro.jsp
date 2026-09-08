<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Usuario</title>
</head>
<body>
    <h2>Crear Cuenta</h2>
    <form action="registro" method="post">
        <label>Nombre Completo:</label><br>
        <input type="text" name="nombre" required><br><br>
        
        <label>Correo Electrónico:</label><br>
        <input type="email" name="email" required><br><br>
        
        <label>Contraseña:</label><br>
        <input type="password" name="password" required><br><br>
        
        <button type="submit">Registrarse</button>
    </form>
    <p>¿Ya tienes cuenta? <a href="login.jsp">Inicia Sesión</a></p>
</body>
</html>