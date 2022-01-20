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
 	<h4 class="card-title">Saisie d'un Produit</h4>
  <div class="card-body">
   	<form action="saveProduit.do" method="POST">
   		<div clas="form-group">
   			<label class="control-Label">Désignation</label>
   			<input type="text" name="designation" class="form-control" value="Entrer un produit" required="required"/>
   			<span></span>
   		</div>
   		
   		<div clas="form-group">
   			<label class="control-Label">Prix</label>
   			<input type="text" name="prix" class="form-control" value="0.0"/>
   			<span></span>
   		</div>
   		
   		<div clas="form-group">
   			<label class="control-Label">Quantite</label>
   			<input type="text" name="quantite" class="form-control" value="0"/>
   			<span></span>
   		</div>
   		<p>
   		<div>
   			<button type="submit" class="btn btn-primary">Save</button>
   		</div>
   	</form>
 
   
   
   
   
   
   
  <!--   
  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a> -->
  </div>
</div>




</div>

</body>
</html>