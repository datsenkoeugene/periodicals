<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ include file="/WEB-INF/jspf/response.jspf" %>
<html lang="${sessionScope.lang}">
<c:set var="title" value="User periodicals" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<c:if test="${not empty user}">
    <h1 class="text-center mt-5 mb-5">
        User periodicals (${userPublicationsList.size()})
    </h1>
    <div class="container">
        <div id="publicationTable" class="table-responsive">
            <table class="table table-bordered table-dark table-hover text-center">
                <thead>
                <tr>
                    <th><fmt:message key="periodicals_list_jsp.table.name"/></th>
                    <th><fmt:message key="periodicals_list_jsp.table.theme"/></th>
                </tr>
                </thead>
                <tbody class="table-light">
                <c:forEach var="publication" items="${userPublicationsList}" varStatus="theCount">
                    <tr>
                        <td><c:out value="${publication.name}"/></td>
                        <td><c:out value="${publication.theme}"/></td>
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
