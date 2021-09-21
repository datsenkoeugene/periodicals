package com.eugenedatsenko.db.entity;

/**
 * Holder for fields names of DB tables and beans.
 *
 * @author Y. Datsenko
 *
 */
public class Fields {

    public static final String USER_ID = "user_id";
    public static final String USER_EMAIL = "email";
    public static final String USER_FIRST_NAME = "first_name";
    public static final String USER_LAST_NAME = "last_name";
    public static final String USER_PASSWORD = "password";
    public static final String USER_IS_LOCK = "is_lock";
    public static final String USER_ROLE_ID = "role_id";

    public static  final String PUBLICATION_ID = "publication_id";
    public static  final String PUBLICATION_NAME = "name";
    public static  final String PUBLICATION_THEME = "theme";
    public static  final String PUBLICATION_PRICE = "price";

    public static  final String ACCOUNT_ID = "account_id";
    public static  final String ACCOUNT_AMOUNT = "amount";
    public static  final String ACCOUNT_USER_ID = "id_user";

    public static  final String USER_PUBLICATIONS_ID = "id";
    public static  final String USER_PUBLICATIONS_USER_ID = "id_user";
    public static  final String USER_PUBLICATIONS_PUBLICATION_ID = "id_publication";

}
