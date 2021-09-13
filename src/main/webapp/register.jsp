<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ taglib prefix = "alert" uri = "/WEB-INF/tag/alertTag.tld"%>
<%@ page import="com.eugenedatsenko.Path" %>
<c:set var="requestPath" value="register"/>
<html lang="${sessionScope.lang}">
<c:set var="title" value="Register"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<div class="container">
    <%@include file="/WEB-INF/jspf/language.jspf" %>
    <c:if test="${errorMessage != null}">
        <alert:Alert type="${lang}" form="register"/>
    </c:if>
    <form class="form mt-5 needs-validation" method="post" action="controller" novalidate>
        <input name="command" type="hidden" value="register">
        <div class="mb-3 has-validation">
            <label for="email" class="form-label"><fmt:message key="register_jsp.label.email"/></label>
            <input type="email"
                   class="form-control"
                   id="email"
                   name="email"
                   placeholder="<fmt:message key="register_jsp.label.email"/>"
                   value="${email}"
                   required>
            <div class="invalid-feedback"><fmt:message key="register_jsp.error.email"/></div>
            <c:if test="${errorEmail != null}">
                <div class="text-danger"><fmt:message key="register_jsp.error.email"/></div>
            </c:if>
        </div>
        <div class="mb-3 has-validation">
            <label for="firstName" class="form-label"><fmt:message key="register_jsp.label.firstName"/></label>
            <input type="text"
                   class="form-control"
                   id="firstName"
                   name="firstName"
                   placeholder="<fmt:message key="register_jsp.label.firstName"/>"
                   value="${firstName}"
                   required>
            <div class="invalid-feedback"><fmt:message key="register_jsp.error.firstName"/></div>
            <c:if test="${errorFirstName != null}">
                <div class="text-danger"><fmt:message key="register_jsp.error.firstName"/></div>
            </c:if>
        </div>
        <div class="mb-3 has-validation">
            <label for="lastName" class="form-label"><fmt:message key="register_jsp.label.lastName"/></label>
            <input type="text"
                   class="form-control"
                   id="lastName"
                   name="lastName"
                   placeholder="<fmt:message key="register_jsp.label.lastName"/>"
                   value="${lastName}"
                   required>
            <div class="invalid-feedback"><fmt:message key="register_jsp.error.lastName"/></div>
            <c:if test="${errorLastName != null}">
                <div class="text-danger"><fmt:message key="register_jsp.error.lastName"/></div>
            </c:if>
        </div>
        <div class="mb-3 has-validation">
            <label for="password" class="form-label"><fmt:message key="register_jsp.label.password"/></label>
            <input type="password"
                   class="form-control"
                   id="password"
                   name="password"
                   placeholder="<fmt:message key="register_jsp.label.password"/>"
                   minlength="6"
                   value="${password}"
                   required>
            <div class="invalid-feedback"><fmt:message key="register_jsp.error.password"/></div>
            <c:if test="${errorPassword != null}">
                <div class="text-danger"><fmt:message key="register_jsp.error.password"/></div>
            </c:if>
        </div>
        <button type="submit" class="btn btn-outline-dark"><fmt:message key="register_jsp.button.register"/></button>
        <a href="${Path.PAGE_LOGIN}" class="btn btn-link"><fmt:message key="register_jsp.label.question"/></a>
    </form>
</div>
<%@ include file="/WEB-INF/jspf/script.jspf" %>
</body>
</html>
