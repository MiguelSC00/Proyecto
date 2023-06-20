<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"> -->
    <!--- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> -->
    <title>Inicio</title>
</head>
<body>
    
    
    <header class="main-header">
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
        
        

        <div class="titulo">
            <div class="texto-titulo">
                <h1>PowerHouse</h1>
            </div>
            
        </div>
    </header>

    <section class="contenedor seccion nosotros">
        <div>
            <h1>SOBRE NOSOTROS</h1>
        </div>
        <div class="contenido-nosotros">
            <div class="iconos-nosotros">
                <div class="fondo-iconos">
                    <img src="img/iconos/icono_plan_personalizado.webp" alt="" width="120px" height="63px">
                </div>
                <div>
                    <h2>PLANES PERSONALIZADOS</h2>
                    <p>
                        Todas nuestras planificaciones son 100% personalizadas
                         y adaptadas a los objetivos y necesidades de cada 
                         atleta.
                    </p>
                </div>
            </div>
            <div class="iconos-nosotros">
                <div class="fondo-iconos">
                    <img src="img/iconos/icono_tu_eliges.webp" alt="" width="120px" height="63px">
                </div>
                <div>
                    <h2>¡TU DECIDES QUE ENTRENAR!</h2>
                    <p>
                        El deportista decide la modalidad deportiva que quiere 
                        entrenar. Nos adaptamos a todas las disciplinas. 
                        Powerlifting, culturismo, etc.
                    </p>
                </div>
            </div>
            <div class="iconos-nosotros">
                <div class="fondo-iconos">
                    <img src="img/iconos/icono_247.webp" alt="" width="120px" height="63px">
                </div>
                <div>
                    <h2>APOYO DIRECTO 24/7</h2>
                    <p>
                        El apoyo y motivación del entrenador hace sacar lo 
                        mejor de cada atleta. Estaremos encantado de guiarte
                         y ayudarte en tu camino.
                    </p>
                </div>
            </div>
        </div>
            
        <div>
            <button class="boton-mas" onclick="location.href='nosotros.jsp'">Saber más</button>
        </div>
    </section>
    
    <section class="contenedor seccion">
        <div class="contenedor asesorias flex-sb">
            <div>
                <h1>ASESORÍAS</h1>
            </div>
            
            <div class="contenedor flex-se">
                <div>
                    <img src="img/tabet.jpg" width="400px" height="400px" alt="">
                </div>

                <div class="contenedor p-asesorias">
                    <p>
                        - Entrena Online con nuestro entrenador Jorge Tabet, licenciado en ciencias deporte.</del>
                    </p>

                    <p>
                        - Con una experiencia de 7 años en el sector del Fitness, consiguiendo la 
                        tarjeta IFBB Pro y habiendo competido en EEUU como profesional del culturismo.
                    </p>

                    <p>
                        - Elige la modalidad que quieras entrenar y cumple tus objetivos de nuestra mano.
                    </p>

                    <p>
                        - Especialistas en Culturismo y Powerlifting.
                    </p>
                </div>
            </div>

            <div>
                <button class="boton-mas" onclick="location.href='asesorias.jsp'">Ver asesorías</button>
            </div>
        </div>
    </section>
    <!-- comment
    <section class="contenedor seccion">
        <div>
            <h1>TIENDA</h1>
        </div>
        --> 
        <!---<div class="contenedor carrusel">
            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <img src="img/cinturon.webp" class="d-block w-100" alt="...">
                  </div>
                  <div class="carousel-item">
                    <img src="img/slipperswebp.webp" class="d-block w-100" alt="...">
                  </div>
                  <div class="carousel-item">
                    <img src="img/straps-rojos.jpg" class="d-block w-100" alt="...">
                  </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Next</span>
                </button>
              </div>
        </div> 

        <div>
            <button class="boton-mas" onclick="location.href='tienda.jsp'">Ir a la tienda</button>
        </div>
    </section>
--->
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