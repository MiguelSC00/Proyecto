<%-- 
    Document   : subirPdfEntrenador
    Created on : 7 jun 2023, 10:27:01
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/styles.css"> 
        <link rel="stylesheet" type="text/css" href="css/styles.css"> 
        <title>Subir archivo</title>
    </head>
    <body>
        
        <jsp:include page="../headerEntrenador.jsp"/>
        
        <section>
            
            <form action="../CrearPdfEntrenador" method="post" enctype="multipart/form-data">
            
                <div>
                    <input type="text" name="nombreFichero"/>
                </div>
                
                <div>
                    <input type="file" name="fichero"/>
                </div>
                
                <div>
                    <input type="hidden" name="nombreUsuario" value="${nombreUsuario}"/>
                    <input type="submit" name="submitEntrenador" value="Aceptar"/>
                </div>
                
            </form>
            
        </section>
        
        
        
    </body>
</html>
