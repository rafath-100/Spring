<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Student Confirmation</title>
</head>
<body>
    The student is confirmed: <strong> ${student.firstName} ${student.lastName} </strong>
    <br><br>

    Country: ${student.country}
    <br><br>

    Favourite Language: ${student.favouriteLanguage}
    <br><br>

    Operating Systems:
      <ul>
           <c:forEach var="temp" items="${student.operatingSystems}">
              <li> ${temp} </li>
           </c:forEach>
      </ul>

</body>
</html>