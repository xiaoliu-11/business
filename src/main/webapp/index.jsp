
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
    <shiro:hasAnyRoles name="owner,carrier">
          <ul>
              <shiro:hasPermission name="owner:publish:*">
                  <li><a href="">发布货源</a></li>
              </shiro:hasPermission>
              <shiro:hasPermission name="owner:speed:*">
                  <li><a href="">催促订单</a></li>
               </shiro:hasPermission>
              <shiro:hasPermission name="owner:update:*">
                   <li><a href="">修改地址</a></li>
              </shiro:hasPermission>
              <shiro:hasPermission name="owner:choice:*">
                   <li><a href="">选择承运商</a></li>
              </shiro:hasPermission>
              <shiro:hasPermission name="*:see:*">
                  <li><a href="">查看所有订单</a></li>
              </shiro:hasPermission>
              <shiro:hasPermission name="carrier:see:*">
                  <li><a href="">承运查看车辆及驾驶员信息</a></li>
              </shiro:hasPermission>

           </ul>
    </shiro:hasAnyRoles>



    <shiro:hasRole name="admin">
    <li><a href="">商品订单管理，货主和承运商管理</a></li>
    </shiro:hasRole>

    <shiro:guest>
        <h2>你没有任何操作权限</h2>
    </shiro:guest>

</ul>


<a href="${pageContext.request.contextPath}/user/logout">退出用户</a>
</body>
</html>