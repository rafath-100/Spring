<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Confirmation</title>

</head>
<body>
    <h3>The customer is confirmed: ${customer.firstName} ${customer.lastName}</h3>
    <br>

    <h3>Free Passes: ${customer.freePasses}</h3>
    <br>

    <h3>Postal Code: ${customer.postalCode}</h3>
    <br>

    <h3>Course Code: ${customer.courseCode}</h3>


</body>
</html>