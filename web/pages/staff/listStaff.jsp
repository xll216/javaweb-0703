<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <script src="/js/jquery-3.2.1.js" type="text/javascript"></script>

    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>

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

        /*高级查询提交表单*/
        function condition(obj) {
            document.getElementById("conditionFormId").submit();
        }

    </script>
</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[员工管理]</td>

        <td width="57%" align="right">
            <%--高级查询 --%>
            <a href="javascript:void(0)" onclick="condition(this)">
                <img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif"/></a>
            <%--员工注入 --%>
            <a href="${pageContext.request.contextPath}/hr/staffAction_addStaff.action">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="${pageContext.request.contextPath}/hr/staffAction_findAll.action" method="post">
    <table width="88%" border="0" style="margin: 20px;">
        <td width="80px">部门：</td>
        <td width="200px">

            <select id="post.department.depID"
                    name="post.department.depID"
                    onchange="showPost(this)">
                <option value="-1">--请选择部门--</option>
                <s:iterator value="%{#departments}" var="list">
                    <option value="${list.depID}">${list.depName}</option>
                </s:iterator>
            </select>
        </td>
        <td width="80px">职务：</td>
        <td width="200px">

            <select id="post.postId" name="post.postId">
                <option value="-1">--请选择职务--</option>
            </select>
        </td>
        <td width="80px">姓名：</td>
        <td width="200px"><input type="text" name="staffName" size="12"/></td>
        <td></td>
    </table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1">
    <tr class="henglan" style="font-weight:bold;">
        <td width="10%" align="center">员工姓名</td>
        <td width="6%" align="center">性别</td>
        <td width="12%" align="center">入职时间</td>
        <td width="15%" align="center">所属部门</td>
        <td width="10%" align="center">职务</td>
        <td width="10%" align="center">编辑</td>
    </tr>
    <s:iterator value="%{#staffList}" var="list">
        <tr class="tabtd2">
            <td align="center">${list.staffName}</td>
            <td align="center">${list.gender}</td>
            <td align="center">${list.onDutyDate}</td>
            <td align="center">${list.post.department.depName}</td>
            <td align="center"><s:property value="post.postName"></s:property></td>
            <td width="7%" align="center">
                <a href="${pageContext.request.contextPath}/hr/staffAction_editStaff.action?staffId=${list.staffId}">
                    <img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
            </td>
        </tr>
    </s:iterator>
</table>


<%-- 
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
--%>
</body>
</html>
