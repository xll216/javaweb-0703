<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>

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
        <td width="44%" align="left">[编辑课程]</td>

        <td width="52%" align="right">
            <a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();"><img
                    src="${pageContext.request.contextPath}/images/button/save.gif"/></a>
            <a href="${pageContext.request.contextPath}/education/courseTypeAction_findAll.action"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<form action="${pageContext.request.contextPath}/education/courseTypeAction_addOrEditCourse.action" method="post">

    <s:if test="courseType !=null">
        <input type="hidden" name="courseTypeID" value="${courseType.courseTypeID}"/>
    </s:if>
    <s:else>
        <input type="hidden" name="courseTypeID" value="-1"/>
    </s:else>

    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td width="10%">课程类别：</td>
            <td width="20%"><input type="text" name="courseName" value="${courseType.courseName}"/></td>
            <td width="8%">总学时：</td>
            <td width="62%"><input type="text" name="total" value="${courseType.total}"/></td>
        </tr>
        <tr>
            <td>课程费用：</td>
            <td><input type="text" name="courseCost" value="${courseType.courseCost}"/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>课程简介：</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td colspan="4"><textarea name="remark" cols="60" rows="10">${courseType.remark}</textarea></td>
        </tr>
    </table>
</form>
</body>
</html>
