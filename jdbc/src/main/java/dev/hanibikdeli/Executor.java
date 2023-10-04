package dev.hanibikdeli;

import dev.hanibikdeli.dao.TestDataDAO;
import dev.hanibikdeli.datasource.DataSourceConnectionManager;
import dev.hanibikdeli.dto.TestData;

public class Executor {

    public static void main(String[] args) {
        DataSourceConnectionManager dataSourceManager = new DataSourceConnectionManager();
        TestDataDAO testDataDAO = new TestDataDAO(dataSourceManager);
        TestData testData = new TestData();
        testData.setTitle("title 8");
        testData.setDescription("desc 8");
        testDataDAO.persist(testData);
    }
}
