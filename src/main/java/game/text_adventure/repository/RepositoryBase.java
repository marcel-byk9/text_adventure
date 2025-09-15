package game.text_adventure.repository;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
public abstract class RepositoryBase {
    private static final String DATABASE_PATH = "../../../resources/text_adventure.db";

    protected Connection connection;

    public RepositoryBase() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_PATH);
        } catch (SQLException sqle) {
            log.error(sqle.getMessage());
        }
    }

    protected PreparedStatement preparedStatement(String sql) throws SQLException {
        return this.connection.prepareStatement(sql);
    }
}
