package dev.hanibikdeli.dao;

import dev.hanibikdeli.datasource.DataSourceConnectionManager;
import dev.hanibikdeli.log.AbstractLogger;

import java.sql.Connection;
import java.util.List;

public abstract class DataAccessObject<T extends DataTransferObject> extends AbstractLogger {

    protected final Connection connection;
    protected final DataSourceConnectionManager dataSourceConnectionManager;

    public DataAccessObject(
            DataSourceConnectionManager dataSourceConnectionManager
    ) {
        this.dataSourceConnectionManager = dataSourceConnectionManager;
        this.connection = dataSourceConnectionManager.getConnection();
    }

    public abstract void delete(Long id);

    public abstract T findById(Long id);

    public abstract List<T> findAll();

    public abstract T persist(T entity);

}
