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
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styles.css"> 
        <link rel="stylesheet" type="text/css" href="css/stylesSubirPdf.css"> 
        <title>Subir archivo</title>
    </head>
    <body>
        
        <jsp:include page="headerCliente.jsp"/>
        
        <section> 
            
            <h1>Subir PDF</h1>
            <form action="CrearPdfCliente" method="post" enctype="multipart/form-data">
            
                <div>
                    <label for="titilo">Título</label>
                    <input type="text" name="titulo"/>
                </div>
                
                <div>
                    <input type="file" name="fichero"/>
                </div>
                
                <div>
                    <input type="submit" name="submitCliente" value="Aceptar"/>
                </div>
            </form>  
            
            <a href="DetallesUsuario?usuario=${usuario.getUsuario()}">Cancelar</a>
        </section>
        
        
        
    </body>
</html>
