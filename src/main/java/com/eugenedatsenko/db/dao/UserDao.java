package com.eugenedatsenko.db.dao;

import com.eugenedatsenko.db.DBManager;
import com.eugenedatsenko.db.entity.EntityMapper;
import com.eugenedatsenko.db.entity.Fields;
import com.eugenedatsenko.db.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object for User entity.
 */
public class UserDao {

    private static final String SQL_FIND_USER_BY_ID = "SELECT * FROM users WHERE user_id=?";

    private static final String SQL_FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email=?";

    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM users";

    private static final String SQL_UPDATE_USER = "UPDATE users SET is_lock=? WHERE user_id=?";

    private static final String SQL_INSERT_USER = "INSERT INTO users (email, first_name, last_name, password, is_lock, role_id) values (?, ?, ?, ?, ?, ?)";

    /**
     * Create a new user with the given user.
     *
     * @param user
     *            User user.
     */
    public void insertUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBManager.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
            int k = 1;
            preparedStatement.setString(k++, user.getEmail());
            preparedStatement.setString(k++, user.getFirstName());
            preparedStatement.setString(k++, user.getLastName());
            preparedStatement.setString(k++, user.getPassword());
            preparedStatement.setBoolean(k++, user.getLock());
            preparedStatement.setInt(k, user.getRoleId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
    }

    /**
     * Returns a user with the given identifier.
     *
     * @param id
     *            User identifier.
     * @return User entity.
     */
    public User findUserById(int id) {
        User user = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = DBManager.getInstance().getConnection();
            UserMapper userMapper = new UserMapper();
            preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = userMapper.mapRow(resultSet);
            }
            resultSet.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return user;
    }

    /**
     * Returns a user with the given email.
     *
     * @param email
     *            User email.
     * @return User entity.
     */
    public User findUserByEmail(String email) {
        User user = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = DBManager.getInstance().getConnection();
            UserMapper userMapper = new UserMapper();
            preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_EMAIL);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = userMapper.mapRow(resultSet);
            }
            resultSet.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return user;
    }

    /**
     * Returns all users.
     *
     * @return List<User> user list.
     */
    public List<User> findAllUsers() {
        List<User> userList = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DBManager.getInstance().getConnection();
            UserMapper userMapper = new UserMapper();
            resultSet = connection.createStatement().executeQuery(SQL_FIND_ALL_USERS);
            while (resultSet.next()) {
                userList.add(userMapper.mapRow(resultSet));
            }
            resultSet.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return userList;
    }

    /**
     * Update user.
     *
     * @param user
     *            user to update.
     */
    public void updateUser(User user) {
        Connection connection = null;
        try {
            connection = DBManager.getInstance().getConnection();
            updateUser(connection, user);
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
    }

    /**
     * Update user.
     *
     * @param user
     *            user to update.
     * @throws SQLException
     */
    public void updateUser(Connection connection, User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
        int k = 1;
        preparedStatement.setBoolean(k++, user.getLock());
        preparedStatement.setInt(k, user.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    /**
     * Extracts a user from the result set row.
     */
    private static class UserMapper implements EntityMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet) {
            try {
                User user = new User();
                user.setId(resultSet.getInt(Fields.USER_ID));
                user.setRoleId(resultSet.getInt(Fields.USER_ROLE_ID));
                user.setFirstName(resultSet.getString(Fields.USER_FIRST_NAME));
                user.setLastName(resultSet.getString(Fields.USER_LAST_NAME));
                user.setEmail(resultSet.getString(Fields.USER_EMAIL));
                user.setPassword(resultSet.getString(Fields.USER_PASSWORD));
                user.setLock(resultSet.getBoolean(Fields.USER_IS_LOCK));
                return user;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        }
    }

}
