<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="css/stylesAsesoriasEspec.css">
    <title>Culturismo</title>
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
        <div class="info">
            <div>
                <img src="img/asesoria-power.jpg" width="640px" height="360px" alt="">
            </div>
            <div class="contenido">
                <div class="nombre">
                    <p>ASESORÍA ONLINE POWERLIFTING con JORGE TABET</p>
                </div>
                <div class="tiempo">
                    <p>Mensual</p>
                </div>
                <div class="precio">
                    <p>69,99$</p>
                </div>
                <div>
                    <button class="boton-contratar">CONTRATAR</button>
                </div>
            </div>
        </div>

        <div class="descripcion">
            <h3>Descripción</h3>

            <p>
                Creemos al 100% en que lo más importante para la obtención de objetivos es 
                una buena relación atleta y entrenador. Nosotros hemos conseguido eso durante
                 el tiempo que llevamos entrenando juntos y con todos los atletas que 
                 trabajan con nosotros. Eso es lo que queremos inculcar en todos y cada 
                 uno de vosotros para poder llevar vuestro objetivos al siguiente nivel. 
                 ¿Estás preparado?
            </p>

            <p>
                <h3>¿Que incluye este servicio de suscripción de entrenamiento?</h3>
            </p>

            <p>
                - Planificación de entrenamientos y objetivos enfocados a la ganancia de fuerza
            </p>

            <p>
                - Contacto y seguimiento diario por Whatsapp
            </p>
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