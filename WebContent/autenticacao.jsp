<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Servlet.Controlador" %>
    <%@ include file="login.jsp" %>
<%
String cpf = request.getParameter("inputEmail3");
String senha = request.getParameter("senha");	
if (cpf.equals("123.123.123-33") && senha.equals("1234") ){
	request.getSession().setAttribute("theName",cpf);
	response.sendRedirect("index.jsp");
}
else{
	response.sendRedirect("login.jsp");
}
%>

</body>
</html>