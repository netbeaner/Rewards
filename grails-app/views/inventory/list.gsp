<!doctype html>

<html>
<head>
	<title>List Products</title>
</head>

<body>

${allProducts}

<table>
	<g:each in="${allProducts }" var="thisProduct">
	<tr>
		<td>${thisProduct.name}</td>
		<td>${thisProduct.sku}</td>
		<td>${thisProduct.price}</td>
	</tr>
	
	</g:each>

</table>

</body>


</html>