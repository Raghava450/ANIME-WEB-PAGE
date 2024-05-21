<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
>
<html>

<body>
    <%
        // Retrieve the session object
        HttpSession currentSession = request.getSession(false);

        if (currentSession!= null){
        	currentSession.invalidate();
        }
            // Redirect to the login page if the session is not valid
            response.sendRedirect("index.html");
        
    %>


</body>
</html>