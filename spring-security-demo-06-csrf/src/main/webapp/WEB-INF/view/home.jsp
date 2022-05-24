<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Zemoso Home Page</title>
</head>

<body>
	<h2>Zemoso Technologies Company Home Page</h2>
	<hr>

	<p>Welcome to the Zemoso Technologies home page!</p>

	<hr>

    	<!-- display user name and role -->

    	<p>
    		User: <security:authentication property="principal.username" />
    		<br><br>
    		Role(s): <security:authentication property="principal.authorities" />
    	</p>

    	<hr>


       <!-- logout button -->
       <form:form action="${pageContext.request.contextPath}/logout"
                  method="POST">

                  <input type="submit" value="Logout"/>

       </form:form>
</body>

</html>