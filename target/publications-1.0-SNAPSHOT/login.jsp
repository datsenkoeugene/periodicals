<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ taglib prefix = "alert" uri = "/WEB-INF/tag/alertTag.tld"%>
<%@ page import="com.eugenedatsenko.Path" %>
<c:set var="requestPath" value="login"/>
<html lang="${sessionScope.lang}">
<c:set var="title" value="Login"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<div class="container">
    <%@include file="/WEB-INF/jspf/language.jspf" %>
    <c:if test="${errorMessage != null}">
        <alert:Alert type="${lang}" form="login"/>
    </c:if>
    <form class="form mt-5 needs-validation" method="post" action="controller" novalidate>
        <input name="command" type="hidden" value="login">
        <div class="mb-3 has-validation">
            <label for="email" class="form-label"><fmt:message key="login_jsp.label.email"/></label>
            <input type="email"
                   class="form-control"
                   id="email"
                   name="email"
                   placeholder="<fmt:message key="login_jsp.label.email"/>"
                   value="${email}"
                   required>
            <div class="invalid-feedback"><fmt:message key="login_jsp.error.email"/></div>
            <c:if test="${errorEmail != null}">
                <div class="text-danger"><fmt:message key="login_jsp.error.email"/></div>
            </c:if>
        </div>
        <div class="mb-3 has-validation">
            <label for="password" class="form-label"><fmt:message key="login_jsp.label.password"/></label>
            <input type="password"
                   class="form-control"
                   id="password"
                   name="password"
                   placeholder="<fmt:message key="login_jsp.label.password"/>"
                   minlength="6"
                   value="${password}"
                   required>
            <div class="invalid-feedback"><fmt:message key="login_jsp.error.password"/></div>
            <c:if test="${errorPassword != null}">
                <div class="text-danger"><fmt:message key="login_jsp.error.password"/></div>
            </c:if>
        </div>
        <button type="submit" class="btn btn-outline-dark"><fmt:message key="login_jsp.button.login"/></button>
        <a href="${Path.PAGE_REGISTER}" class="btn btn-link"><fmt:message key="login_jsp.label.question"/></a>
    </form>
</div>
<%@ include file="/WEB-INF/jspf/script.jspf" %>
</body>
</html>