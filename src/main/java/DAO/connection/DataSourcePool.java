package DAO.connection;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by edik2 on 16.05.2018.
 */
public class DataSourcePool {

//    private Logger logger = Logger.getLogger(DataSourcePool.class);

    private BasicDataSource bds;


    public DataSourcePool(String bundle) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(bundle);
        String url = resourceBundle.getString("url");
        String login = resourceBundle.getString("login");
        String password = resourceBundle.getString("password");
        String driverName = resourceBundle.getString("driverName");
        bds = new BasicDataSource();
        bds.setDriverClassName(driverName);
        bds.setUrl(url);
        bds.setUsername(login);
        bds.setPassword(password);

        bds.setMinIdle(10);
        bds.setMaxIdle(50);
        bds.setMaxOpenPreparedStatements(300);
//        logger.info("DataSource successful configure");
    }

    /**
     * Method for getting a connection
     *
     * @return {@link Connection}
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return bds.getConnection();

    }

    public DataSource getDS() {
        return bds;
    }

    public void close() throws SQLException {
        bds.close();
    }

}
