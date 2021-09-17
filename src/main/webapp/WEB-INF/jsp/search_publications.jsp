<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ include file="/WEB-INF/jspf/response.jspf" %>
<html lang="${sessionScope.lang}" page="${param.page}">
<c:set var="title" value="Search periodical" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<c:if test="${not empty user}">
    <div class="container">
        <c:if test="${searchPublication == null }">
            <h1 class="text-center mt-5">Publication not found</h1>
        </c:if>
        <c:if test="${searchPublication != null }">
            <div class="table-responsive">
                <table class="table table-bordered table-dark table-hover text-center mt-5">
                    <thead>
                    <tr>
                        <th>
                            <fmt:message key="periodicals_list_jsp.table.name"/>
                        </th>
                        <th>
                            <fmt:message key="periodicals_list_jsp.table.theme"/>
                        </th>
                        <th>
                            <fmt:message key="periodicals_list_jsp.table.price"/>
                        </th>
                        <c:if test="${userRole.name == 'admin' }">
                            <th><fmt:message key="periodicals_list_jsp.table.editing"/></th>
                        </c:if>
                        <c:if test="${userRole.name == 'user' }">
                            <th><fmt:message key="periodicals_list_jsp.table.subscribe"/></th>
                        </c:if>
                    </tr>
                    </thead>
                    <tbody id="publicationTableBody" class="table-light">
                    <tr>
                        <td><c:out value="${searchPublication.name}"/></td>
                        <td><c:out value="${searchPublication.theme}"/></td>
                        <td><c:out value="${searchPublication.price}"/></td>
                        <td>
                            <c:if test="${userRole.name == 'admin' }">
                                <div class="btn-group" role="group">
                                    <a href="${Path.COMMAND_EDIT_PUBLICATION}&id=${searchPublication.id}"
                                       id="${searchPublication.id}"
                                       data-btn="editBtn"
                                       class="btn btn-outline-danger rounded">
                                        <i class="fas fa-pencil-alt"></i>
                                    </a>
                                    <a href="${Path.COMMAND_DELETE_PUBLICATION}&id=${searchPublication.id}"
                                       id="${searchPublication.id}"
                                       data-btn="removeBtn"
                                       class="btn btn-outline-danger rounded ms-2">
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
                    </tbody>
                </table>
            </div>
        </c:if>

    </div>
</c:if>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
<%@ include file="/WEB-INF/jspf/script.jspf" %>
</body>
</html>
