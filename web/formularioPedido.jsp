<%-- 
    Document   : formularioPedido
    Created on : 23 may 2023, 14:09:03
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styles.css"/>
        <link rel="stylesheet" type="text/css" href="css/stylesFormPedido.css"/>
        <title>Document</title>
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
            <form action="CrearPedido">
                <fieldset>
                <legend>Dirección de envío</legend>

                    <div class="part">
                        <label for="provincia">Provincia: </label>
                        <input type="text" name="provincia" id="provincia">
                    </div>

                    <div>
                        <label for="codigoPostal">Código postal: </label>
                        <input type="text" name="codigoPostal" id="codigoPostal">
                    </div>

                    <div>
                        <label for="calle">Calle: </label>
                        <input type="text" name="calle" id="calle">
                    </div>

                    <div>
                        <label for="numero">Número: </label>
                        <input type="number" name="numero" id="numero" required="">
                    </div>
                </fieldset>

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
                        <input type="submit" name="confirmarPedido" value="Confirmar pedido">
                    </div>
                </fieldset>
            </form>
        </section>
        
    </body>
</html>
