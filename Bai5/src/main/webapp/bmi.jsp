<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tính BMI</title>
</head>
<body>
    <h2>Nhập thông tin để tính BMI</h2>
    <form action="bmi" method="post">
        Cân nặng (kg): <input type="text" name="weight" /><br/>
        Chiều cao (m): <input type="text" name="height" /><br/>
        <input type="submit" value="Tính BMI"/>
    </form>

    <c:if test="${not empty bmi}">
        <h3>Kết quả BMI: <c:out value="${bmi}"/></h3>
        <c:choose>
            <c:when test="${bmi lt 18.5}">
                <p>Gầy</p>
            </c:when>
            <c:when test="${bmi lt 25}">
                <p>Bình thường</p>
            </c:when>
            <c:otherwise>
                <p>Thừa cân</p>
            </c:otherwise>
        </c:choose>
    </c:if>

    <c:if test="${not empty error}">
        <p style="color:red;"><c:out value="${error}"/></p>
    </c:if>
</body>
</html>
