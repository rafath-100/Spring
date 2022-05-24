<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Hello World - Website</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">

		First name: <form:input path="firstName" />
		<br><br>

		Last name: <form:input path="lastName" />
		<br><br>

		Country:
		<form:select path="country">
		    <form:options items="${student.countryOptions}" />
		</form:select>

		<br><br>

        Favourite Language:
                    Java <form:radiobutton path="favouriteLanguage" value="Java" />
                    Python <form:radiobutton path="favouriteLanguage" value="Python" />
                    C++ <form:radiobutton path="favouriteLanguage" value="C++" />
                    Javascript <form:radiobutton path="favouriteLanguage" value="Javascript" />
        <br><br>

        Operating Systems:
                 		Linux <form:checkbox path="operatingSystems" value="Linux" />
                 		Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
                 		Windows <form:checkbox path="operatingSystems" value="Windows" />
        <br><br>


        <input type="submit" value="Submit"/>
	</form:form>

</body>
</html>