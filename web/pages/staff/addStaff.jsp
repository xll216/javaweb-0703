<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
    <script src="/js/jquery-3.2.1.js" type="text/javascript"></script>

    <script type="text/javascript">
        //显示职务
        function showPost(obj) {
            // 1. 获取选中部门
            var depId = obj.value;

            //2. 发起post请求
            var url = "${pageContext.request.contextPath}/hr/postAction_findAllWithDepartment.action?department.depID=" + depId;
            $.post(url, function (jsonData) {

                //3. 处理返回结果
                var postSelectObject = document.getElementById("post.postId");

                postSelectObject.innerHTML = "<option value='-1'>--请选择职务--</option>";

                for (var i = 0; i < jsonData.length; i++) {
                    var postObj = jsonData[i];
                    // @3.1 编号
                    var postId = postObj.postId;
                    // @3.2 名称
                    var postName = postObj.postName;

                    postSelectObject.innerHTML = postSelectObject.innerHTML + "<option value='" + postId + "'>" + postName + "</option>";
                }
            });
        }

    </script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="44%" align="left">[员工管理]</td>

        <td width="52%" align="right">
            <!-- 提交表单 -->
            <a href="javascript:void(0)" onclick="document.forms[0].submit()">
                <img src="${pageContext.request.contextPath}/images/button/save.gif"/>
            </a>
            <!-- 执行js，进行返回 -->
            <a href="javascript:void(0)" onclick="window.history.go(-1)"><img
                    src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<form action="${pageContext.request.contextPath}/hr/staffAction_edit.action" method="post">
    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td>登录名：</td>
            <td><input type="text" name="loginName" value=""/></td>
            <td>密码：</td>
            <td><input type="password" name="loginPwd" value=""/></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="staffName" value="" id="staffAction_add_staffName"/></td>
            <td>性别：</td>
            <td><input type="radio" name="gender" checked="checked" value="男"/>男
                <input type="radio" name="gender" value="女"/>女
            </td>
        </tr>
        <tr>
            <td width="10%">所属部门：</td>
            <td width="20%">
                <select id="post.department.depID"
                        name="post.department.depID"
                        onchange="showPost(this)">
                    <option value="-1">--请选择部门--</option>
                    <s:iterator value="%{#departments}" var="list">
                        <option value="${list.depID}">${list.depName}</option>
                    </s:iterator>
                </select>

            </td>
            <td width="8%">职务：</td>
            <td width="62%">

                <select id="post.postId" name="post.postId">
                    <option value="-1">--请选择职务--</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%">入职时间：</td>
            <td width="20%">
                <input type="text" name="onDutyDate" value="" readonly="readonly"
                       onfocus="c.showMoreDay=true; c.show(this);"/>
            </td>
            <td width="8%"></td>
            <td width="62%"></td>
        </tr>
    </table>
</form>
</body>
</html>
