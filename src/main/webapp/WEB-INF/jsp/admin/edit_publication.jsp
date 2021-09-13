<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ include file="/WEB-INF/jspf/response.jspf" %>
<html>
<c:set var="title" value="Edit publication" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<h1 class="text-center mt-5 mb-5">
    <fmt:message key="edit.periodicals.title"/>
</h1>
<div class="container">
    <form class="form mt-5 needs-validation" method="post" action="controller" novalidate>
        <input name="command" type="hidden" value="updatePublication">
        <input name="id" type="hidden" value="<c:out value="${publication.id}"/>">
        <div class="mb-3 has-validation">
            <label for="name" class="form-label"><fmt:message key="edit.periodicals.name"/></label>
            <input type="text"
                   class="form-control"
                   id="name"
                   name="name"
                   placeholder="<fmt:message key="edit.periodicals.name"/>"
                   value="<c:out value="${publication.name}"/>"
                   required>
            <div class="invalid-feedback"><fmt:message key="edit.periodicals.error.name"/></div>
            <c:if test="${errorName != null}">
                <div class="text-danger"><fmt:message key="edit.periodicals.error.name"/></div>
            </c:if>
        </div>
        <div class="mb-3 has-validation">
            <label for="theme" class="form-label"><fmt:message key="edit.periodicals.theme"/></label>
            <input type="text"
                   class="form-control"
                   id="theme"
                   name="theme"
                   placeholder="<fmt:message key="edit.periodicals.theme"/>"
                   value="<c:out value="${publication.theme}"/>"
                   required>
            <div class="invalid-feedback"><fmt:message key="edit.periodicals.error.theme"/></div>
            <c:if test="${errorTheme != null}">
                <div class="text-danger"><fmt:message key="edit.periodicals.error.theme"/></div>
            </c:if>
        </div>
        <div class="mb-3 has-validation">
            <label for="price" class="form-label"><fmt:message key="edit.periodicals.price"/></label>
            <input type="number"
                   class="form-control"
                   min="0"
                   id="price"
                   name="price"
                   placeholder="<fmt:message key="edit.periodicals.price"/>"
                   value="<c:out value="${publication.price}"/>"
                   required>
            <div class="invalid-feedback"><fmt:message key="edit.periodicals.error.price"/></div>
            <c:if test="${errorPrice != null}">
                <div class="text-danger"><fmt:message key="edit.periodicals.error.price"/></div>
            </c:if>
        </div>
        <button type="submit" class="btn btn-outline-dark"><fmt:message key="edit.periodicals.button"/></button>
    </form>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
<%@ include file="/WEB-INF/jspf/script.jspf" %>
</body>
</html>
