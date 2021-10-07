package com.eugenedatsenko.db.dao;

import com.eugenedatsenko.db.DBManager;
import com.eugenedatsenko.db.entity.EntityMapper;
import com.eugenedatsenko.db.entity.Fields;
import com.eugenedatsenko.db.entity.Publication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object for Publication entity.
 */
public class PublicationDao {

    private static final String SQL_FIND_PUBLICATION_BY_ID = "SELECT * FROM publications WHERE publication_id=?";

    private static final String SQL_FIND_ALL_PUBLICATIONS = "SELECT * FROM publications";

    private static final String SQL_UPDATE_PUBLICATION = "UPDATE publications SET name=?, theme=?, price=?  WHERE publication_id=?";

    private static final String SQL_INSERT_PUBLICATION = "INSERT INTO publications (name, theme, price) values (?, ?, ?)";

    private static final String SQL_DELETE_PUBLICATION = "DELETE FROM publications WHERE publication_id=?";

    private static final String SQL_LIMIT_PUBLICATIONS = "SELECT * FROM publications LIMIT";

    private static final String SQL_FIND_PUBLICATIONS_BY_NAME = "SELECT * FROM publications WHERE name=?";


    /**
     * Returns a publication with the given name.
     *
     * @param name Publication name.
     * @return User entity.
     */
    public Publication findPublicationsByName(String name) {
        Publication publication = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = DBManager.getInstance().getConnection();
            PublicationMapper publicationMapper = new PublicationMapper();
            preparedStatement = connection.prepareStatement(SQL_FIND_PUBLICATIONS_BY_NAME);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                publication = publicationMapper.mapRow(resultSet);
            }
            resultSet.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return publication;
    }

    public List<Publication> getRecords(int start, int total) {
        List<Publication> publicationList = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DBManager.getInstance().getConnection();
            PublicationMapper publicationMapper = new PublicationMapper();
            resultSet = connection.createStatement().executeQuery(SQL_LIMIT_PUBLICATIONS + " " + (start - 1) + "," + total);
            while (resultSet.next()) {
                publicationList.add(publicationMapper.mapRow(resultSet));
            }
            resultSet.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return publicationList;
    }

    public List<Publication> getRecordsByName(int start, int total) {
        List<Publication> publicationList = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DBManager.getInstance().getConnection();
            PublicationMapper publicationMapper = new PublicationMapper();
            resultSet = connection.createStatement().executeQuery("SELECT * FROM publications ORDER BY name limit " + (start - 1) + "," + total);
            while (resultSet.next()) {
                publicationList.add(publicationMapper.mapRow(resultSet));
            }
            resultSet.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return publicationList;
    }

    public List<Publication> getRecordsByPrice(int start, int total) {
        List<Publication> publicationList = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DBManager.getInstance().getConnection();
            PublicationMapper publicationMapper = new PublicationMapper();
            resultSet = connection.createStatement().executeQuery("SELECT * FROM publications ORDER BY price limit " + (start - 1) + "," + total);
            while (resultSet.next()) {
                publicationList.add(publicationMapper.mapRow(resultSet));
            }
            resultSet.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return publicationList;
    }

    public void insertPublication(Publication publication) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBManager.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT_PUBLICATION);
            int k = 1;
            preparedStatement.setString(k++, publication.getName());
            preparedStatement.setString(k++, publication.getTheme());
            preparedStatement.setBigDecimal(k++, publication.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
    }

    public void deletePublication(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBManager.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_PUBLICATION);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
    }

    public Publication findPublicationById(int id) {
        Publication publication = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = DBManager.getInstance().getConnection();
            PublicationMapper publicationMapper = new PublicationMapper();
            preparedStatement = connection.prepareStatement(SQL_FIND_PUBLICATION_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                publication = publicationMapper.mapRow(resultSet);
            }
            resultSet.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return publication;
    }

    public List<Publication> findAllPublications() {
        List<Publication> publicationList = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DBManager.getInstance().getConnection();
            PublicationMapper publicationMapper = new PublicationMapper();
            resultSet = connection.createStatement().executeQuery(SQL_FIND_ALL_PUBLICATIONS);
            while (resultSet.next()) {
                publicationList.add(publicationMapper.mapRow(resultSet));
            }
            resultSet.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return publicationList;
    }

    public void updatePublication(Publication publication) {
        Connection connection = null;
        try {
            connection = DBManager.getInstance().getConnection();
            updatePublication(connection, publication);
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
    }

    public void updatePublication(Connection connection, Publication publication) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_PUBLICATION);
        int k = 1;
        preparedStatement.setString(k++, publication.getName());
        preparedStatement.setString(k++, publication.getTheme());
        preparedStatement.setBigDecimal(k++, publication.getPrice());
        preparedStatement.setLong(k, publication.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private static class PublicationMapper implements EntityMapper<Publication> {

        @Override
        public Publication mapRow(ResultSet resultSet) {
            try {
                Publication publication = new Publication();
                publication.setId(resultSet.getInt(Fields.PUBLICATION_ID));
                publication.setName(resultSet.getString(Fields.PUBLICATION_NAME));
                publication.setTheme(resultSet.getString(Fields.PUBLICATION_THEME));
                publication.setPrice(resultSet.getBigDecimal(Fields.PUBLICATION_PRICE));
                return publication;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
