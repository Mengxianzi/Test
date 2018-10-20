<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>短网址服务</title>
    <link rel="stylesheet" type="text/css" href="CSS/index.css">
    <script type="text/javascript" src="JS/val.js"></script>
</head>
<body>
<%!
    int count = 0;
    synchronized void count() {
        count++;
    }
%>
<%
    count();
    out.print("访问量："+count+"</br>");
%>
    <div id="hed">
        <form action="/URL" method="post" onsubmit="return validate()">
            <span id="linkMsg" name="linkMsg"></span>
            <input type="text" placeholder="输入将要缩短的长网址" id="link" name="link" onblur="checkUrl()">
            <input type="submit" id="put" name="put" value="提交">
            <p><ul>
                <li><input type="radio" name="shortsite" value="sina.cn" checked>&nbsp;sina.cn</li>
                <li><input type="radio" name="shortsite" value="jd.cn.hn">&nbsp;jd.cn.hn</li>
                <li><input type="radio" name="shortsite" value="dwz.cn">&nbsp;dwz.cn</li>
                <li><input type="radio" name="shortsite" value="qq.cn.hn">&nbsp;qq.cn.hn</li>
            </ul></p>
        </form>

    </div>
    <div id="mid">
        <c:if test="${path!=null}" var="res">
            <p>原网址：</p>
            <p><a href="${link}" target="view_window">${link}</a></p>
            <p>下面是生成的短链接，您可以访问他：</p>
            <p><a href="/AccessUrl?path=${path}" target="view_window">${path}</a></p>
        </c:if>
    </div>
</body>
</html>
