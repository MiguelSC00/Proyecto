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
                <img src="img/asesoria-culturismo.jpg" width="640px" height="360px" alt="">
            </div>
            <div class="contenido">
                <div class="nombre">
                    <p>ASESOR�A ONLINE CULTURISMO - JORGE TABET</p>
                </div>
                <div class="tiempo">
                    <p>Mensual</p>
                </div>
                <div class="precio">
                    <p>59,99$</p>
                </div>
                <div>
                    <button class="boton-contratar">CONTRATAR</button>
                </div>
            </div>
        </div>

        <div class="descripcion">
            <h3>Descripci�n</h3>

            <p>Si quieres llevar tu rendimiento a otro nivel y maximizar la hipertrofia, podemos trabajar juntos para ello.</p>
        
            <p>
                Y esa es la clave, juntos, trabajando en equipo y con un seguimiento y buena relaci�n 
                entrenador-atleta, haremos todo lo posible para conseguir tus objetivos. 
                Por parte del entrenador vas a contar con la m�xima involucraci�n y profesionalidad. 
                Mejorar tus marcas en los b�sicos y ganar masa muscular van de la mano, y como tal, 
                combin�moslo, consiguiendo sacar el m�ximo partido en ambos aspectos.
            </p>

            <p>
                <h3>�Que incluye este servicio de suscripci�n de entrenamiento?</h3>
            </p>

            <p>
                - Planificaci�n de entrenamientos y objetivos enfocados a la ganancia de masa 
                muscular y p�rdida de grasa
            </p>

            <p>
                - Contacto y seguimiento diario por Whatsapp
            </p>

            <p>
                - Readaptaci�n de lesiones deportivas
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
                <p>Copyright 2022 &#169 Developed by Miguel S�nchez</p>
            </div>
        </div>
    </footer>

</body>
</html>