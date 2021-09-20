<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ include file="/WEB-INF/jspf/response.jspf" %>
<html lang="${sessionScope.lang}">
<c:set var="title" value="User accounts" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<c:if test="${not empty user}">
    <h1 class="text-center mt-5 mb-5">
        <fmt:message key="user_accounts.jsp.title"/>
    </h1>
    <div class="container">
        <div id="publicationTable" class="table-responsive">
            <table class="table table-bordered table-dark table-hover text-center">
                <thead>
                <tr>
                    <th>#</th>
                    <th><fmt:message key="user_accounts.jsp.table.amount"/></th>
                    <th><fmt:message key="user_accounts.jsp.table.topUpAccount"/></th>
                </tr>
                </thead>
                <tbody class="table-light">
                <c:forEach var="account" items="${accountList}" varStatus="theCount">
                    <tr>
                        <td><c:out value="${theCount.count}"/></td>
                        <td><c:out value="${account.amount}"/></td>
                        <td>
                            <div class="btn-group" role="group">
                                <a href="#"
                                   class="btn btn-outline-danger rounded">
                                    <i class="fas fa-wallet"></i>
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</c:if>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
<%@ include file="/WEB-INF/jspf/script.jspf" %>
</body>
</html>
