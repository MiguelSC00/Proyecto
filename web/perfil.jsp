<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : perfil
    Created on : 10 may 2023, 23:56:51
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/styles.css"/>
        <link rel="stylesheet" type="text/css" href="css/stylesPerfil.css"/>
        <title>Mi cuenta</title>
    </head>
    <body>
        
        <c:choose>
            <c:when test="${empty usuario}">
                <jsp:include page="header.jsp"/>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${usuario.getRol().equals('Administrador')}">
                        <jsp:include page="headerAdmin.jsp"/>
                    </c:when>
                    <c:when test="${usuario.getRol().equals('Entrenador')}">
                        <jsp:include page="headerEntrenador.jsp"/>
                    </c:when>
                    <c:otherwise>
                        <jsp:include page="headerCliente.jsp"/>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
        
        <section>
            <div class="info">
                <div>
                    <p class="usuario">${usuario.getUsuario()}</p>
                </div>
                
                <div>
                    <p class="nombreCompleto">${usuario.getNombre()} ${usuario.getApellidos()}</p>
                </div>
                
            </div>
            
            <div class="cambiar">
                <div>
                    <form action="CambiarNombreUsuario" method="get">
                        <div>
                            <p class="title">Cambiar usuario</p>
                        </div>
                        <div>
                            <label for="usuarioNuevo">Usuario nuevo:</label>
                            <input type="text" name="usuarioNuevo" id="usuarioNuevo"/>
                        </div>
                        
                        <div>
                            <span class="error">${errorUsuario}</span>
                        </div>

                        <div>
                           <input type="submit" name="submit" value="Cambiar usuario"/>                          
                        </div>
                     </form>
                </div>

                <div>
                    <form action="CambiarPassword" method="get">
                        <div>
                            <p class="title">Cambiar contraseña</p>
                        </div>
                        <div>
                            <label for="passwordActual">Contraseña actual:</label>
                            <input type="password" name="passwordActual" id="passwordActual"/>
                        </div>
                        <div>
                            <label for="passwordNueva1">Contraseña actual:</label>
                            <input type="password" name="passwordNueva1" id="passwordNueva1"/>
                        </div>
                        <div>
                            <label for="passwordNueva2">Contraseña actual:</label>
                            <input type="password" name="passwordNueva2" id="passwordNueva2"/>
                        </div>

                        <div>
                            <span class="error">${errorPass}</span>
                        </div>
                        
                        <div>
                            <input type="submit" name="submit" value="Cambiar contraseña"/>
                        </div>
                    </form>
                </div>
                        
                <div>
                    <form action="CambiarNombreApellidos" method="get">
                        <div>
                            <p class="title">Nombre completo</p>
                        </div>
                        <div>
                            <label for="nombreNuevo">Nombre: </label>
                            <input type="text" name="nombreNuevo" id="nombreNuevo" value="${usuario.getNombre()}"/>
                        </div>
                        
                        <div>
                            <label for="apellidosNuevo">Apellidos: </label>
                            <input type="text" name="apellidosNuevo" id="apellidosNuevo" value="${usuario.getApellidos()}"/>
                        </div>
                        
                        <div>
                            <span class="error">${errorNombre}</span>
                        </div>

                        <div>
                           <input type="submit" name="submit" value="Guardar"/>                          
                        </div>
                     </form>
                </div>        

                <div>
                    <form action="CambiarEmail" method="get">
                        <div>
                            <p class="title">Email</p>
                        </div>
                        
                        <div>
                           <label for="emailNuevo">Email: </label>
                            <input type="email" name="emailNuevo" id="emailNuevo" value="${usuario.getEmail()}"/> 
                        </div>
                        
                        <div>
                            <span class="error">${errorEmail}</span>
                        </div>
                        
                        <div>
                            <input type="submit" name="submit" value="Guardar"/>
                        </div>
                     </form>
                </div>
                        
                <div class="ultimo">
                    <form action="CambiarTelefono" method="get">
                        <div>
                            <p class="title">Teléfono</p>
                        </div>
                        
                        <div>
                           <label for="telefonoNuevo">Teléfono: </label>
                            <input type="text" name="telefonoNuevo" id="telefonoNuevo" value="${usuario.getTelefono()}"/> 
                        </div>
                        
                        <div>
                            <span class="error">${errorTelefono}</span>
                        </div>
                        
                        <div>
                            <input type="submit" name="submit" value="Guardar"/>
                        </div>
                     </form>
                </div>
            </div>
                   
        </section>
                        
        <footer>
        <div>
            <div class="iconos-redes">
                <div>
                    <img src="img/iconos/instagram.png" alt="" width="32px" height="32px">
                </div>
                <div>
                    <img src="img/iconos/youtube.png" alt="" width="32px" height="32px">
                </div>
                <div>
                    <img src="img/iconos/twitter.png" alt="" width="32px" height="32px">
                </div>
            </div>
            <div>
                <p>Copyright 2022 &#169 Developed by Miguel Sánchez</p>
            </div>
        </div>
    </footer>                
        
    </body>
</html>
