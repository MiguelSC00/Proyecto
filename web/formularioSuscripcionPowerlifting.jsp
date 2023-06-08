<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <link rel="stylesheet" type="text/css" href="css/stylesFormPedido.css"/>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    
    <title>Información de pago</title>
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
        <form action="SuscribirPowerlifting">
                <fieldset>
                    <legend>Información de pago</legend>

                    <div>
                        <label for="tarjeta">Tarjeta bancaria:</label>
                        <input type="text" name="tarjeta" id="tarjeta">
                    </div>

                    <div>
                        <label for="fechaCaducidad">Fecha de caducidad:</label>
                        <input type="text" name="fechaCaducidad" id="fechaCaducidad">
                    </div>

                    <div>
                        <label for="cvv">CVV:</label>
                        <input type="text" name="cvv" id="cvv">
                    </div>
                    
                    <div>
                        <p class="error">${error}</p> 
                    </div>
                    
                    <div>
                        <input type="submit" name="confirmarSuscripcion" value="Confirmar suscripción">
                    </div>
                </fieldset>
        </form>
        
        
    </section>
    
</body>
