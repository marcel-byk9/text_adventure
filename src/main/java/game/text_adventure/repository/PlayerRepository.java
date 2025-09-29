package game.text_adventure.repository;

import game.text_adventure.dto.Player;
import game.text_adventure.mapper.PlayerMapper;
import lombok.extern.slf4j.Slf4j;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Slf4j
public class PlayerRepository extends RepositoryBase {
    public List<Player> findAllByIsActiveTrue() {
        String sql = """
                SELECT * FROM Player
                WHERE IsActive = true;
                """;
        try {
            return PlayerMapper.mapMultiple(connection.prepareStatement(sql).executeQuery());
        } catch (SQLException sqle) {
            log.error(sqle.getMessage());
            return List.of();
        }
    }

    public Optional<Player> save(Player player) {
        String searchSql = """
                SELECT * FROM Player
                WHERE Id = ?;
                """;
        String insertSql = """
                INSERT INTO Player(Name, Background, Class, Story_Save, IsActive, SituationsCounter, Id)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;
        String updateSql = """
                UPDATE Player
                SET Name = ?,
                    Background = ?,
                    Class = ?,
                    Story_Save = ?,
                    IsActive = ?,
                    SituationsCounter = ?
                WHERE Id = ?;
                """;
        try {
            PreparedStatement stmt = connection.prepareStatement(searchSql);
            stmt.setString(1, player.getId().toString());
            Optional<Player> optPlayer = PlayerMapper.map(stmt.executeQuery());
            if (optPlayer.isPresent()) {
                stmt = connection.prepareStatement(updateSql);
            } else {
                stmt = connection.prepareStatement(insertSql);
            }
            stmt.setString(1, player.getName());
            stmt.setString(2, String.valueOf(player.getBackground().getId()));
            stmt.setString(3, String.valueOf(player.getPlayerClass().getId()));
            stmt.setString(4, String.valueOf(player.getStorySave().getId()));
            stmt.setBoolean(5, player.getIsActive());
            stmt.setInt(6, player.getSituationsCounter());
            stmt.setString(7, String.valueOf(player.getId()));
            return PlayerMapper.map(stmt.executeQuery());
        } catch (SQLException sqle) {
            log.error(sqle.getMessage());
            return Optional.empty();
        }
    }
}
