<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title>Zemoso Home Page</title>
</head>

<body>
	<h2>Zemoso Technologies Company Home Page</h2>
	<hr>

	<p>Welcome to the Zemoso Technologies home page!</p>


       <!-- logout button -->
       <form:form action="${pageContext.request.contextPath}/logout"
                  method="POST">

                  <input type="submit" value="Logout"/>

       </form:form>
</body>

</html>