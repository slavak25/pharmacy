<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><HTML>
  <HEAD>
    <TITLE>Pharmacy Home</TITLE>
  </HEAD>
  <BODY>    
    <table width="700" cellpadding="8">
      <tr>
        <td width="100"></td>
        <td>          
          <font face="Verdana,Geneva,Arial" size="+3" color="midnightblue">
            Customer Search
          </font>
          <br>
          <hr size="8">
        </td>
      </tr>
    </table>
    <table width="700" cellpadding="8">
      <tr>        
        <td width="100"></td>       
        <td valign="top">
          <font face="Verdana,Geneva,Arial" size="-1">          
            <p><i> Please enter first and last names of customer </i><p>            
            <form action="controller" method="get">
				<input type="hidden" name="command" value="get_customer_command"/>
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
                  <td colspan="2" align="center">
                    &nbsp;<p>
                    <input type="submit" value="Enter" />
                  </td>
                </tr>
            </form>
            <form action=newCustomer.jsp method="get">	
				<input type="submit" value="Add new customer" />		
			</form>       
          </font>
        </td>
    </table>
  </BODY>
</HTML>
