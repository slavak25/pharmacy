<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Visit</title>
</head>
<body>
<table width="700" cellpadding="8">
      <tr>
        <td width="100"></td>
        <td>          
          <font face="Verdana,Geneva,Arial" size="+3" color="midnightblue">
            Deleting Visit
          </font>
          <br>
          <hr size="8">
        </td>
      </tr>
    </table>
<form action="controller" method="get">
	<input type="hidden" name="command" value="delete_visit_command"/>
	<table>
	<tr>
                  <td> Visit ID: </td>
                  <td> <input type="text" name="id" value=""/> </td>
                </tr>
                
                <tr>
                  <td colspan="2" align="center">                    
                    <input type="submit" value="Delete" />
                  </td>
                </tr>
</form>
</body>
</html>