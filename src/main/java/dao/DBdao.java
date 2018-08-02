package dao;

import java.io.IOException;
import java.sql.Connection;

/**
 * Created by OleksiiF on 02.08.2018.
 */
public interface DBdao {

    void createDatabase(String name) throws IOException;
    Connection getConnection();
    void createStructureForDatabase(Connection conn);
}
