<%-- 
    Document   : iniciarSesion
    Created on : 7 jun 2022, 21:01:11
    Author     : Miguel
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <link rel="stylesheet" href="css/stylesLogin.css">
    <title>Iniciar sesión</title>
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

    <section class="contenedor">
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link <c:if test="${errorRegistro==null}">active</c:if>" id="home-tab" data-bs-toggle="tab" data-bs-target="#iniciar-sesion" 
                type="button" role="tab" aria-controls="home" aria-selected="true">Iniciar sesión</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link <c:if test="${errorRegistro!=null}">active</c:if>" id="profile-tab" data-bs-toggle="tab" data-bs-target="#registrarse" type="button" 
                role="tab" aria-controls="profile" aria-selected="false">Registrarse</button>
            </li>
        </ul>
    
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade <c:if test="${errorRegistro==null}">show active</c:if>" id="iniciar-sesion" role="tabpanel" aria-labelledby="home-tab">
              <form action="IniciarSesion" method="post">
              <div class="mb-3">
                <label for="usuarioI" class="form-label">Usuario</label>
                <input type="text" class="form-control" name="usuarioI" id="usuarioI" aria-describedby="emailHelp">
              </div>
    
              <div class="mb-3">
                <label for="passwordI" class="form-label">Contraseña</label>
                <input type="password" class="form-control" name="passwordI" id="passwordI">
              </div>
                  
              <div >
                  <p class="error">${error}</p>
              </div>
    
              <input type="submit" name="submitI" id="submitI" value="Iniciar sesión"/>
            </form>
          </div>
          <div class="tab-pane fade <c:if test="${errorRegistro!=null}">show active</c:if>" id="registrarse" role="tabpanel" aria-labelledby="profile-tab">
              <form action="CrearUsuario" method="post">
              <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombreR" id="nombre" aria-describedby="emailHelp">
              </div>
      
              <div class="mb-3">
                <label for="apellidos" class="form-label">Apellidos</label>
                <input type="text" class="form-control" name="apellidosR" id="apellidos" aria-describedby="emailHelp">
              </div>
      
              <div class="mb-3">
                <label for="usuarioR" class="form-label">Usuario</label>
                <input type="text" class="form-control" name="usuarioR" id="usuarioR" aria-describedby="emailHelp">
              </div>
      
              <div class="mb-3">
                <label for="passwordR" class="form-label">Contraseña</label>
                <input type="password" class="form-control" name="passwordR" id="passwordR">
              </div>
                
              <div class="mb-3">
                <label for="passwordR2" class="form-label">Repite la contraseña</label>
                <input type="password" class="form-control" name="passwordR2" id="passwordR2">
              </div>
    
              <div class="mb-3">
                <label for="emailR" class="form-label">Correo electrónico</label>
                <input type="email" class="form-control" name="emailR" id="emailR" aria-describedby="emailHelp">
              </div>

              <div class="mb-3">
                <label for="telefonoR" class="form-label">Número de teléfono</label>
                <input type="text" class="form-control" name="telefonoR" id="telefonoR" aria-describedby="emailHelp">
              </div>
                
                <div>
                    <p class="error">${errorRegistro}</p> 
                </div>
    
              <input type="submit" name="submitR" id="submitR" value="Registrarse"/>
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

    


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>
