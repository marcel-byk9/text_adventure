package game.text_adventure.repository;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public abstract class RepositoryBase {
    private static final String DATABASE_PATH = "src/main/resources/text_adventure.db";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + DATABASE_PATH);
    }
}
