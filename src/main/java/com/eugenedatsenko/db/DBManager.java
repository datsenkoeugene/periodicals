package com.eugenedatsenko.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * DB manager. Works with Apache Derby DB.
 *
 * @author Y. Datsenko
 */
public class DBManager {

    private static DBManager instance;

    public static synchronized DBManager getInstance() {
        if (instance == null)
            instance = new DBManager();
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/FinalProject");
            connection = dataSource.getConnection();
        } catch (NamingException ex) {
            System.out.println(ex);
        }
        return connection;
    }

    private DBManager() {
    }

    /**
     * Commits and close the given connection.
     *
     * @param connection Connection to be committed and closed.
     */
    public void commitAndClose(Connection connection) {
        try {
            connection.commit();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Rollbacks and close the given connection.
     *
     * @param connection Connection to be rollbacked and closed.
     */
    public void rollbackAndClose(Connection connection) {
        try {
            connection.rollback();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

