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
 	<h4 class="card-title">Recherche des produits</h4>
  <div class="card-body">
   	<form action="chercher.do" method="get" >
   		<label>Mot Clé</label>
   		<input type="text" name="motCle" value="${model.motCle}"/>
   		<button type="submit" class=" btn btn-primary">Chercher</button> 
   	</form>
   	
   	<table class="table table-striped">
   		<tr>
   			<th>ID</th><th>Designation</th><th>Prix</th><th>Quantite</th>
   		</tr>
   		<c:forEach items="${model.produits}" var="p">
   			<tr>
   			<td>${p.id}</td>
   			<td>${p.designation}</td>
   			<td>${p.prix}</td>
   			<td>${p.quantite}</td>
   			<td><a onclick="return confirm('Etes vous sûre ?')"href="supprimer.do?id=${p.id}">Supprimer</a>
			<td><a href="edit.do?id=${p.id}">Edit</a>   			
   			</tr>
   		</c:forEach>	
   	</table>
   
   
   
   
   
   
  <!--   
  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a> -->
  </div>
</div>




</div>

</body>
</html>