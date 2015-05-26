<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Profile</title>
</head>

<body>
<table width="700" cellpadding="8">
      <tr>
        <td width="100"></td>
        <td>          
          <font face="Verdana,Geneva,Arial" size="+3" color="midnightblue">
            Customer Profile
          </font>
          <br>
          <hr size="8">
        </td>
      </tr>
    </table>
<table border="1" width="100%" cellpadding="5">
	<tr>
		<th>ID</th>
		<td><c:out value="${cust.id}"/></td>
	</tr>
	<tr>
		<th>First Name</th>
		<td><c:out value="${cust.firstName}"/></td>
	</tr>
	<tr>
		<th>Last Name</th>
		<td><c:out value="${cust.lastName}"/></td>
	</tr>
	<tr>
		<th>Date of birth</th>
		<td><c:out value="${cust.dateOfBirth}"/></td>
	</tr>
	<tr>
		<th>Address</th>
		<td><c:out value="${cust.address}"/></td>
	</tr>
	<tr>
		<th>Phone</th>
		<td><c:out value="${cust.phone}"/></td>
	</tr>
	<tr>
		<th>Email</th>
		<td><c:out value="${cust.email}"/></td>
	</tr>
	<tr>
		<th>Left eye</th>
		<td><c:out value="${cust.leftEye}"/></td>
	</tr>
	<tr>
		<th>Right eye</th>
		<td><c:out value="${cust.rightEye}"/></td>
	</tr>
</table>	


<table border="1" width="100%" cellpadding="5">
	<tr>
		<th>ID</th>
		<th>Date of visit</th>
		<th>Amount</th>
		<th>Order status</th>
	</tr>
	<c:forEach var="elem" items="${list}">
	<tr>
		<td><c:out value="${elem.id}"/></td>	
		<td><c:out value="${elem.visitDate}"/></td>
		<td><c:out value="${elem.amount}"/></td>
		<td><c:out value="${elem.status}"/></td>		
	</tr>
	</c:forEach>		
</table>
<table>
	<tr>
		<td><form action="newVisitPage.jsp" method="get">	
		<input type="submit" value="Add Visit" />
		</form></td>
		<td><form action="updateVisitPage.jsp" method="get">	
		<input type="submit" value="Modify Visit" />
		</form></td>
		<td><form action="deleteVisitPage.jsp" method="get">	
		<input type="submit" value="Delete Visit" />
		</form></td>
	</tr>	
</table>
<a href="index.jsp">Home</a>
</body>
</html>