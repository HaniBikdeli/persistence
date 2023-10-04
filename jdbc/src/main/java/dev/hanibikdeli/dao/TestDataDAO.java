package dev.hanibikdeli.dao;

import dev.hanibikdeli.datasource.DataSourceConnectionManager;
import dev.hanibikdeli.dto.TestData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TestDataDAO extends DataAccessObject<TestData> {

    private static final String INSERT = "insert into jpa.test_data (title, description) VALUES (? ,?)";


    public TestDataDAO(DataSourceConnectionManager dataSourceConnectionManager) {
        super(dataSourceConnectionManager);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TestData findById(Long id) {
        return null;
    }

    @Override
    public List<TestData> findAll() {
        return null;
    }

    @Override
    public TestData persist(TestData entity) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(INSERT);
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getDescription());
            int affected = preparedStatement.executeUpdate();
            this.connection.commit();
            if (affected == 0) {
                throw new RuntimeException("failed to execute update");
            } else {
                logger.debug("successfully persisted desired entity");
            }
            dataSourceConnectionManager.closeConnection(connection, null, null, preparedStatement);
        } catch (SQLException e) {
            logger.debug("persisting entity failed");
            try {
                this.connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        return null;
    }
}
