<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<html>
<head>
</head>

<body>
	<table>
		<c:forEach var="stock" items="${stockList}">
			<tr>
				<td>
					${stock.stockCode}
				</td>
				<td>
					${stock.priceDate}
				</td>
				<td>
					${stock.startPrice}
				</td>
			</tr>
		</c:forEach>
	</table>
</body>

</html>