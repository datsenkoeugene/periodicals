<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ include file="/WEB-INF/jspf/response.jspf" %>
<html lang="${sessionScope.lang}">
<c:set var="title" value="List periodicals" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<c:if test="${not empty user}">
    <h1 class="text-center mt-5 mb-5">
        <fmt:message key="periodicals_list_jsp.label.title"/> (${publicationsList.size()})
    </h1>
    <div class="container">
        <div id="publicationTable" class="table-responsive">
            <table class="table table-bordered table-dark table-hover text-center">
                <thead>
                <tr>
                    <th>#</th>
                    <th><fmt:message key="periodicals_list_jsp.table.name"/></th>
                    <th><fmt:message key="periodicals_list_jsp.table.theme"/></th>
                    <th><fmt:message key="periodicals_list_jsp.table.price"/></th>
                    <c:if test="${userRole.name == 'admin' }">
                        <th><fmt:message key="periodicals_list_jsp.table.editing"/></th>
                    </c:if>
                    <c:if test="${userRole.name == 'user' }">
                        <th><fmt:message key="periodicals_list_jsp.table.subscribe"/></th>
                    </c:if>
                </tr>
                </thead>
                <tbody class="table-light">
                <c:forEach var="publication" items="${publicationsList}" varStatus="theCount">
                    <tr>
                        <td><c:out value="${theCount.count}"/></td>
                        <td><c:out value="${publication.name}"/></td>
                        <td><c:out value="${publication.theme}"/></td>
                        <td><c:out value="${publication.price}"/></td>
                        <td>
                            <c:if test="${userRole.name == 'admin' }">
                                <div class="btn-group" role="group">
                                    <a href="${Path.COMMAND_EDIT_PUBLICATION}&id=${publication.id}"
                                       id="${publication.id}" data-btn="editBtn" class="btn btn-outline-danger rounded">
                                        <i class="fas fa-pencil-alt"></i>
                                    </a>
                                    <a href="${Path.COMMAND_DELETE_PUBLICATION}&id=${publication.id}"
                                       id="${publication.id}" data-btn="removeBtn" class="btn btn-outline-danger rounded ms-2">
                                        <i class="fas fa-trash"></i>
                                    </a>
                                </div>
                            </c:if>
                            <c:if test="${userRole.name == 'user' }">
                                <div class="btn-group" role="group">
                                    <a href="#"
                                       class="btn btn-outline-danger rounded">
                                        <i class="fas fa-pencil-alt"></i>
                                    </a>
                                </div>
                            </c:if>
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
