<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/stylesNosotros.css">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <title>Nosotros</title>
</head>
<body>
    <header>
        <div>
            <nav class="nav-transparente fixed-nav">
                <img src="../img/barbell.webp" alt="" class="icono-mancuerna">
            </nav>
            
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
        </div>
        
                    
        
        
        <div class="header-img">
            <h1>¿Quiénes somos?</h1>
        </div>            
    </header>
        

    <section class="seccion contenedor">
        <div class="contenedor info">
            <p>
                Somos un equipo de apasionados por el deporte que contamos con años de experiencia en el sector
                tanto profesionalmente como por ocio. 
            </p>
            <p>
                Nuestra prioridad es que disfrutéis y aprendais durante el proceso, lo que conllevará, por supuesto, 
                una notable mejora en vuestra salud, físico y capacidad 
            </p>
            <p>
                Si quieres formar parte de nuestro equipo, contrata una de las asesorías con nuestro
                entrenador Jorge Tabet, licenciado en ciencias del deporte, culturista profesional desde 
                hace 2 años y powerlifter.
            </p>
        </div>
    </section>

    <section class="seccion contenedor">
        <div class="contenedor">
            <h2>ESPECIALISTAS EN DOS MODALIDADES</h2>
            
            <div class="contenedor modalidades">
                <div>
                    <h3>CULTURISMO</h3>

                    <div class="box" onclick="location.href='culturismo.jsp'">
                        
                        <img src="img/cbum.webp" width="378px" height="472.5px" onclick="location.href='culturismo.html'">
                        
                        <div class="hover">
                            <p>Si quieres centrarte en mejorar tu estética, ganando masa muscular y perdiendo
                                grasa, esta es tu modalidad.
                            </p>
                        </div>
                    </div>
                </div>

                <div>
                    <h3>POWERLIFTING</h3>

                    <div class="box" onclick="location.href='powerlifting.jsp'">
                            <img src="img/larry-wheels.webp" width="378px" height="472.5px" alt="">
                        
                            <div class="hover">
                                <p>Si quieres centrarte en mejorar tu fuerza en los básicos, esta es tu modalidad.</p>
                            </div>
                    </div>
                    
                </div>
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