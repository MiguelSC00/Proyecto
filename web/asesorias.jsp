<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="css/stylesAsesorias.css">
    <title>Asesorías</title>
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

    <div class="nav-invisible">
        
    </div>

    <section>
        <div class="asesoria-borde">
            <div onclick="location.href='culturismo.jsp'">
                <img src="img/asesoria-culturismo.jpg" class="img" width="512px" height="288" alt="">
            </div>
            <div class="info" onclick="location.href='culturismo.jsp'">
                <div class="nombre">
                    <p>ASESORÍA ONLINE CULTURISMO</p>
                </div>
                <div class="tiempo">
                    <p>Mensual</p>
                </div>
                <div class="precio">
                    <p>59,99$</p>
                </div>
            </div>
            <div>
                <button class="boton-contratar" onclick="location.href='SuscribirCulturismo'">CONTRATAR</button>
            </div>
        </div>

        <div class="asesoria-borde">
            <div onclick="location.href='powerlifting.jsp'">
                <img src="img/asesoria-power.jpg" class="img" width="512px" height="288" alt="">
            </div>
            <div class="info" onclick="location.href='powerlifting.jsp'">
                <div class="nombre">
                    <p>ASESORÍA ONLINE POWERLIFTING</p>
                </div>
                <div class="tiempo">
                    <p>Mensual</p>
                </div>
                <div class="precio">
                    <p>69,99$</p>
                </div>
            </div>
            <div>
                <button class="boton-contratar" onclick="location.href='SuscribirPowerlifting'">CONTRATAR</button>
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
