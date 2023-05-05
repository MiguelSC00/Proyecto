<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : modificarUsuario
    Created on : 10 jun 2022, 19:24:20
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/stylesGestionUsuarios.css">
    <title>Modificar usuario</title>
    </head>
    <body>
        
        <header>
            <jsp:include page="../headerAdmin.jsp"/>

            <nav class="nav-admin">
                <div>
                    <h3>Panel de control</h3>
                </div>

                <div>
                    <ul class="menu-admin">
                        <li class="actual"><a href="">Gestionar usuarios</a></li>
                        <li><a href="">Gestionar productos</a></li>
                        <li><a href="">Gestionar pedidos</a></li>
                    </ul>
                </div>
            </nav>
        </header>
            
            <section class="form-div">
                
                <form action="ModificarUsuario" method="post" class="form">
                    
                    <div>
                        <h1>Modificar usuario</h1>
                    </div>
                    
                    <div>
                        <label for="nombre">Nombre</label>
                        <input type="text" name="nombre" id="nombre" value="${usuarioModificar.nombre}"/>
                    </div>
                    
                    <div>
                        <label for="apellidos">Apellidos</label>
                        <input type="text" name="apellidos" id="apellidos" value="${usuarioModificar.apellidos}"/>
                    </div>
                    
                    <div>
                        <label for="usuario">Usuario</label>
                        <input type="text" name="usuario" id="usuario" value="${usuarioModificar.usuario}"/>
                    </div>
                    
                    <div>
                        <label for="password">Password</label>
                        <input type="password" name="password" id="password" value="${usuarioModificar.password}"/>
                    </div>
                    
                    <div>
                        <label for="email">Email</label>
                        <input type="email" name="email" id="email" value="${usuarioModificar.email}"/>
                    </div>
                    
                    <div>
                        <label for="telefono">Teléfono</label>
                        <input type="text" name="telefono" id="telefono" value="${usuarioModificar.telefono}"/>
                    </div>
                    
                    <div>
                        <label for="rol">Rol</label>
                        <select name="rol">
                            <option value="Cliente" ${usuarioModificar.rol.equals("Cliente")?"selected":""}>Cliente</option>
                            <option value="Entrenador" ${usuarioModificar.rol.equals("Entrenador")?"selected":""}>Entrenador</option>
                            <option value="Administrador" ${usuarioModificar.rol.equals("Administrador")?"selected":""}>Administrador</option>
                        </select>
                    </div>
                       
                        <div>
                            <input type="submit" class="input" name="modificar" value="Modificar"/>
                        </div>    
                        
                </form>
                
            </section>
    </body>
</html>
