<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<html>
<c:set var="title" value="Error"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<div class="container">
    <h1 class="text-center text-danger mt-5">Error Page!</h1>
    <p class="text-center text-danger mt-5"><c:out value="${errorMessage}"/></p>
</div>
<%@ include file="/WEB-INF/jspf/script.jspf" %>
</body>
</html>
