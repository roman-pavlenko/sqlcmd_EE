<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>SQLCmd</title>
    </head>
    Available tables:<br>
        <br><table border = "1">
            <c:forEach items="${tables}" var="table" varStatus="loop">
                <tr><td>${loop.count}</td>
                    <td align="center">
                        ${table}
                    </td>
                    </tr>
            </c:forEach>
        </table><br>
        Back to <a href="menu">menu</a><br>
    </body>
</html>
