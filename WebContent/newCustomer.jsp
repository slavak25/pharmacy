<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>New Customer</title>
</head>
<body>
<table width="700" cellpadding="8">
      <tr>
        <td width="100"></td>
        <td>          
          <font face="Verdana,Geneva,Arial" size="+3" color="midnightblue">
            Creating a new profile
          </font>
          <br>
          <hr size="8">
        </td>
      </tr>
    </table>

<form action="controller" method="get">
	<input type="hidden" name="command" value="add_customer_command"/>
<table>
                <tr>
                  <td> First Name: </td>
                  <td> <input type="text" name="firstName" value=""/> </td>
                </tr>
                <tr>
                  <td> Last Name: </td>
                  <td> <input type="text" name="lastName" value="" /> </td>
                </tr>
                <tr>
                  <td> Date of birth: </td>
                  <td> <input type="text" name="dateOfBirth" value="" /> </td>
                </tr>
                <tr>
                  <td> Address: </td>
                  <td> <input type="text" name="address" value="" /> </td>
                </tr>
                <tr>
                  <td> Phone: </td>
                  <td> <input type="text" name="phone" value="" /> </td>
                </tr>
                <tr>
                  <td> E-mail: </td>
                  <td> <input type="text" name="email" value="" /> </td>
                </tr>
                <tr>
                  <td> Left Eye: </td>
                  <td> <input type="text" name="leftEye" value="" /> </td>
                </tr>
                <tr>
                  <td> Right Eye: </td>
                  <td> <input type="text" name="rightEye" value="" /> </td>
                </tr>
                <tr>
                  <td colspan="2" align="center">
                    &nbsp;<p>
                    <input type="submit" value="Enter" />
                  </td>
                </tr>	
</form>
</body>