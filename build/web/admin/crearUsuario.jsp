<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : crearUsuario
    Created on : 10 jun 2022, 20:14:13
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
        <title>Crear Usuario</title>
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
                            <li class="actual"><a href="MostrarUsuarios">Gestionar usuarios</a></li>
                            <li><a href="MostrarProductos?target=administrar">Gestionar productos</a></li>
                            <li><a href="MostrarPedidos">Gestionar pedidos</a></li>
                        </ul>
                    </div>
                </nav>
            </header>
        
                <section class="form-div">
                    <form action="CrearUsuario" method="post" class="form">
                        <div>
                          <label for="nombre" >Nombre</label>
                          <input type="text" name="nombre" id="nombre"/>
                        </div>

                        <div>
                          <label for="apellidos" class="form-label">Apellidos</label>
                          <input type="text" class="form-control" name="apellidos" id="apellidos" aria-describedby="emailHelp">
                        </div>

                        <div>
                          <label for="usuario" >Usuario</label>
                          <input type="text" name="usuario" id="usuario"/>
                        </div>

                        <div>
                          <label for="password1">Contraseña</label>
                          <input type="password1" name="password1" id="password1">
                        </div>

                        <div>
                          <label for="password2">Contraseña</label>
                          <input type="password2" name="password2" id="password2"/>
                        </div>

                        <div>
                          <label for="email">Email</label>
                          <input type="email" name="email" id="email"/>
                        </div>

                        <div>
                          <label for="telefono">Teléfono</label>
                          <input type="text" name="telefono" id="telefono"/>
                        </div>

                      <div>
                        <label for="rol">Rol</label>
                        <select name="rol">
                            <option value="Cliente">Cliente</option>
                            <option value="Entrenador">Entrenador</option>
                            <option value="Administrador">Administrador</option>
                        </select>
                      </div>


                        <div>
                            <p class="error">${errorCrear}</p> 
                        </div>

                      <input type="submit" name="crearAdmin" id="crearAdmin" value="Crear usuario"/>
                    </form>
                </section>    
            
    </body>
</html>
