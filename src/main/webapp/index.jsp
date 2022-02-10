
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>index</title>
</head>
<body>
<h1>系统主页</h1>

<ul>
    <shiro:hasAnyRoles name="root,admin">
    <li><a href="">用户管理</a>
          <ul>
              <shiro:hasPermission name="user:save:*">
                  <li><a href="">添加用户</a></li>
              </shiro:hasPermission>
              <shiro:hasPermission name="user:delete:*">
                  <li><a href="">删除用户</a></li>
               </shiro:hasPermission>
              <shiro:hasPermission name="user:update:*">
                   <li><a href="">修改用户</a></li>
              </shiro:hasPermission>
              <shiro:hasPermission name="user:select:*">
                   <li><a href="">查询用户</a></li>
              </shiro:hasPermission>
           </ul>
        </li>
    </shiro:hasAnyRoles>

    <shiro:hasRole name="root">
    <li><a href="">商品订单管理</a></li>
    </shiro:hasRole>
</ul>


<a href="${pageContext.request.contextPath}/user/logout">退出用户</a>
</body>
</html>