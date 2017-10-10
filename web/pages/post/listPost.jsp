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

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[职务管理]</td>

        <td width="57%" align="right">
            <%--添加职务 --%>
            <a href="${pageContext.request.contextPath}/hr/postAction_addOrEditPost.action">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1">

    <tr class="henglan" style="font-weight:bold;">
        <td width="6%" align="center">部门名称</td>
        <td width="6%" align="center">职务名称</td>
        <td width="7%" align="center">编辑</td>
    </tr>

    <s:iterator value="%{#pb.beanList}" var="list">
        <tr class="tabtd2">
            <td align="center">${list.department.depName}</td>
            <td align="center">${list.postName}</td>
            <td width="7%" align="center">
                <a href="${pageContext.request.contextPath}/hr/postAction_addOrEditPost.action?postId=${list.postId}">
                    <img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
            </td>
        </tr>
    </s:iterator>
</table>


<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">
            第<s:property value="%{#pb.pageNum }"/>页/共<s:property value="%{#pb.totalPage }"/> 页
            <s:a action="postAction_findAll">
                首页
                <s:param name="pageNum" value="'1'"/>
            </s:a>
            <s:if test="%{#pb.pageNum > 1 }">
                <s:a action="postAction_findAll">
                    上一页
                    <s:param name="pageNum" value="%{#pb.pageNum-1}"/>
                </s:a>
            </s:if>

            <%-- 循环遍历页码列表 --%>
            <s:iterator var="i" begin="%{#pb.begin}" end="%{#pb.end}">
                <s:if test="%{#i eq #pb.pageNum }">
                    <font color="blue">
                        <s:property value="%{#i}"/>
                    </font>
                </s:if>
                <s:else>
                    <s:a action="postAction_findAll">
                        [<s:property value="%{#i}"/> ]
                        <s:param name="pageNum" value="%{#i}"/>
                    </s:a>
                </s:else>
            </s:iterator>

            <s:if test="%{#pb.pageNum < #pb.totalPage }">
                <s:a action="postAction_findAll">
                    <s:param name="pageNum" value="%{#pb.pageNum+1}"/>
                    下一页
                </s:a>
            </s:if>

            <s:a action="postAction_findAll">
                <s:param name="pageNum" value="%{#pb.totalPage}"/>
                尾页
            </s:a>
        </td>
    </tr>
</table>
</body>
</html>
