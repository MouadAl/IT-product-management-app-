<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Produits</title>
<link rel ="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
<%@include file="header.jsp" %>
<p>
<div class = "container col-md-10 col-md-offset-1">
 	<div class="card" style="width: 50rem;">
 	<h4 class="card-title">Confirmation du Produit:</h4>
  <div class="card-body">
   		
   		<div clas="form-group">
   			<label> ID:</label>
   			<label class="control-Label">${produit.id}</label>
   			
   		</div>
   		
   		<div clas="form-group">
   			<label> Designation::</label>
   			<label class="control-Label">${produit.designation}</label>
   		</div>
   		
   		<div clas="form-group">
   			<label> Prix:</label>
   			<label class="control-Label">${produit.prix}</label>	
   		</div>
   		
   		<div clas="form-group">
   			<label> Quantite:</label>
   			<label class="control-Label">${produit.quantite}</label>
   			
   		</div>
   		<p>
   		
 
   
   
   
   
   
   
  <!--   
  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a> -->
  </div>
</div>




</div>

</body>
</html>