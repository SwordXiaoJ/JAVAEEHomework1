<%@ page import="java.util.List" %>
<%@ page import="com.java.code.class12.model.StudentHomework" %>
<%@ page import="com.java.code.class12.jdbc.StudentHomeworkJdbc" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/3/1
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>简易作业管理系统</title>
    <link id="css" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"  />
  </head>
  <body>


  <form action="" method="post" role="from" class="smart-green">
        <h1>简易作业管理系统
            <span> 请选择您的身份</span>
        </h1>

     
    <label>
      <span>&nbsp;</span>
    <a href="http://localhost:8080/JSP/Teacher/TeacherOperation.jsp" >

      <input type="button" class="button" value="老师"/>
    </a>
     </label>

    <label>
      <span>&nbsp;</span>
    <a href="http://localhost:8080/JSP/Student/StudentLogin.jsp" >
      <input type="button" class="button" value="学生"/>
    </a>
    </label>
       
  </form>

  </body>
</html>
