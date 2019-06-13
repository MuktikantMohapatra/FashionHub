<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="registration" method="post">
 <pre>
   Name :<input type="text" name="name" placeholder="John Sha" />
   Email :<input type="email" name="email" placeholder="kajal@gmail.com" />
   Phone :<input type="text" name="phone" placeholder="65465465" />
   Date Of Birth :<input type="date" name="dob" />
   Gender : Male<input type="radio" value="male" name="gender">
            Female<input type="radio" value="female" name="gender">   
   Password :<input type="password" name="password" placeholder="************" />
   Confirm Password :<input type="text" name="cpassword" placeholder="546546" />
   <button type="submit" >Next</button>
 </pre>
</form>
</body>
</html>