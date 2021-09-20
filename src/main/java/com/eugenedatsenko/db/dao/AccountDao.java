package com.eugenedatsenko.db.dao;

import com.eugenedatsenko.db.DBManager;
import com.eugenedatsenko.db.entity.Account;
import com.eugenedatsenko.db.entity.EntityMapper;
import com.eugenedatsenko.db.entity.Fields;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object for Account entity.
 */
public class AccountDao {

    private static final String SQL_FIND_ALL_ACCOUNTS = "SELECT * FROM accounts WHERE id_user=";

    private static final String SQL_UPDATE_ACCOUNT = "UPDATE accounts SET amount=? WHERE id_user=?";

    private static final String SQL_FIND_ACCOUNT_BY_ID = "SELECT * FROM accounts WHERE id_user=?";

    /**
     * Returns a account with the given identifier.
     *
     * @param id
     *            Account identifier.
     * @return Account entity.
     */
    public Account findAccountById(int id) {
        Account account = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = DBManager.getInstance().getConnection();
            AccountMapper accountMapper = new AccountMapper();
            preparedStatement = connection.prepareStatement(SQL_FIND_ACCOUNT_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = accountMapper.mapRow(resultSet);
            }
            resultSet.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return account;
    }

    /**
     * Returns all user accounts.
     *
     * @return List<Account> account list.
     */
    public List<Account> findAllAccounts(int id) {
        List<Account> accountList = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = DBManager.getInstance().getConnection();
            AccountMapper accountMapper = new AccountMapper();
            resultSet = connection.createStatement().executeQuery(SQL_FIND_ALL_ACCOUNTS + id);
            while (resultSet.next()) {
                accountList.add(accountMapper.mapRow(resultSet));
            }
            resultSet.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        }finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return  accountList;

    }

    /**
     * Update account.
     *
     * @param account
     *            account to update.
     */
    public void updateAccount(Account account) {
        Connection connection = null;
        try {
            connection = DBManager.getInstance().getConnection();
            updateAccount(connection, account);
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
    }

    /**
     * Update account.
     *
     * @param account
     *            account to update.
     * @throws SQLException
     */
    public void updateAccount(Connection connection, Account account) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_ACCOUNT);
        int k = 1;
        preparedStatement.setBigDecimal(k++, account.getAmount());
        preparedStatement.setInt(k, account.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    /**
     * Extracts account from the result set row.
     */
    private static class AccountMapper implements EntityMapper<Account> {

        @Override
        public Account mapRow(ResultSet resultSet) {
            try {
                Account account = new Account();
                account.setId(resultSet.getInt(Fields.ACCOUNT_ID));
                account.setAmount(new BigDecimal(resultSet.getInt(Fields.ACCOUNT_AMOUNT)));
                account.setUserId(resultSet.getInt(Fields.ACCOUNT_USER_ID));
                return account;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
