<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by 蓝鸥科技有限公司  www.lanou3g.com.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/js/jquery-3.2.1.js"></script>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#listid").change(function (e) {
                var pageIndex = document.getElementById("listid");
                alert(e + "---" + pageIndex.value)
            });
            $("#queryObjectId").change(function (e) {
                var pageIndex = document.getElementById("queryObjectId");
                alert(e + "---" + pageIndex.value)
            });


        })
    </script>
</head>
<body>
<form name="form1" method="post">
    <s:property value="%{#departments}"></s:property>
    <br><br>

    <s:select
            id="listid"
            list="%{#departments}"
            listKey="depID"
            listValue="depName"
            headerKey=""
            headerValue="----请--选--择----"
            theme="simple"
            name="test"
            label="部门"/>

    <br><br>
    <select id="queryObjectId" name="queryObjectId">
        <option value="">--请选择--</option>
        <s:iterator value="%{#departments}" var="list">
            <option value="${list.depID}">${list.depName}</option>
        </s:iterator>
    </select>
</form>

</body>
</html>
