<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ include file="/WEB-INF/jspf/response.jspf" %>
<html>
<c:set var="title" value="List users" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<h1 class="text-center mt-5 mb-5"><fmt:message key="users_list_jsp.label.users"/> (${usersList.size()})</h1>
<div class="container">
    <div class="table-responsive">
        <table class="table table-bordered table-dark table-hover text-center">
            <thead>
            <tr>
                <th>#</th>
                <th><fmt:message key="users_list_jsp.label.table.users.firstName"/></th>
                <th><fmt:message key="users_list_jsp.label.table.users.lastName"/></th>
                <th><fmt:message key="users_list_jsp.label.table.users.email"/></th>
                <th><fmt:message key="users_list_jsp.label.table.users.editing"/></th>
            </tr>
            </thead>
            <tbody class="table-light">
            <c:forEach var="user" items="${usersList}" varStatus="theCount">
                <tr>
                    <td><c:out value="${theCount.count}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td>
                        <a href="${Path.COMMAND_LOCK_UNLOCK_USER}&id=${user.id}" class="btn btn-outline-danger rounded">
                            <c:if test="${user.lock == false}">
                                <i class="fas fa-lock"></i>
                            </c:if>
                            <c:if test="${user.lock == true}">
                                <i class="fas fa-unlock"></i>
                            </c:if>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
<%@ include file="/WEB-INF/jspf/script.jspf" %>
</body>
</html>
