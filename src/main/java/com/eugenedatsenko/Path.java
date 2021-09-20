package com.eugenedatsenko;

public class Path {

    public static final String PAGE_LOGIN = "/login.jsp";
    public static final String PAGE_REGISTER = "/register.jsp";
    public static final String PAGE_ERROR_PAGE = "/WEB-INF/jsp/error_page.jsp";
    public static final String PAGE_USERS_LIST = "/WEB-INF/jsp/admin/users_list.jsp";
    public static final String PAGE_PERIODICALS_LIST = "/WEB-INF/jsp/periodicals_list.jsp";
    public static final String PAGE_INSERT_PUBLICATION = "/WEB-INF/jsp/admin/add_publication.jsp";
    public static final String PAGE_EDIT_PUBLICATION = "/WEB-INF/jsp/admin/edit_publication.jsp";
    public static final String PAGE_SEARCH_PUBLICATIONS = "/WEB-INF/jsp/search_publications.jsp";
    public static final String PAGE_USER_ACCOUNT = "/WEB-INF/jsp/user/user_accounts.jsp";

    public static final String COMMAND_USERS_LIST = "/controller?command=listUsers";
    public static final String COMMAND_LOCK_UNLOCK_USER = "/controller?command=lockUnlockUser";

    public static final String COMMAND_PERIODICALS_LIST = "/controller?command=listPeriodicals";
    public static final String COMMAND_INSERT_PUBLICATION = "/controller?command=insertPagePublication";
    public static final String COMMAND_DELETE_PUBLICATION = "/controller?command=deletePublication";
    public static final String COMMAND_EDIT_PUBLICATION = "/controller?command=editPublication";
    public static final String COMMAND_SORT_PUBLICATION_BY_NAME = "/controller?command=sortByName";

    public static final String COMMAND_USER_ACCOUNT = "/controller?command=userAccount";
}
