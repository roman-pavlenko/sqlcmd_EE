<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>SQLCmd</title>
</head>
<body>
<form action="deleteRecord" method="post">
  <table>
    <tr>
      <td>Table name</td>
      <td><input type="text" name="tableName"/></td>
    </tr>

    <tr>
      <td>Column name</td>
      <td><input type="text" name="keyName"/></td>
    </tr>

    <tr>
      <td>Column value</td>
      <td><input type="text" name="keyValue"/></td>
    </tr>

    <tr>
      <td></td>
      <td><input type="submit" value="delete"/></td>
    </tr>
  </table>
  Back to <a href="menu">menu</a><br>
</form>
</body>
</html>