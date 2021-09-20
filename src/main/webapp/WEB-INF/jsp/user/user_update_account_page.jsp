<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ include file="/WEB-INF/jspf/response.jspf" %>
<html lang="${sessionScope.lang}">
<c:set var="title" value="User update account" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<c:if test="${not empty user}">
    <h1 class="text-center mt-5 mb-5">
        <fmt:message key="user_accounts.jsp.title"/>
    </h1>
    <div class="container">
        <form class="form mt-5" method="post" action="controller">
            <input name="command" type="hidden" value="updateAccount">
            <input type="hidden" min="0" name="userId" value="${user.id}" />
            <div class="input-group mb-3">
                <input type="number" class="form-control" name="amount" placeholder="Amount">
                <button type="submit" class="btn btn-outline-dark">Top up</button>
            </div>
        </form>
    </div>
</c:if>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
<%@ include file="/WEB-INF/jspf/script.jspf" %>
</body>
</html>
