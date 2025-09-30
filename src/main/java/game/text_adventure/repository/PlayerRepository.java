package game.text_adventure.repository;

import game.text_adventure.dto.Player;
import game.text_adventure.mapper.PlayerMapper;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class PlayerRepository extends RepositoryBase {

    public Optional<Player> findById(UUID id) {
        String sql = """
                SELECT * FROM Player
                WHERE Id = ?;
                """;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

             stmt.setString(1, id.toString());

             try (ResultSet rs = stmt.executeQuery()) {
                 if (rs.next()) {
                     return PlayerMapper.map(rs);
                 }
             }
        } catch (SQLException ex) {
            log.error("Error fetching player by ID {}: {}", id, ex.getMessage(), ex);
        }

        return Optional.empty();
    }

    public List<Player> findAllByIsActiveTrue() {
        String sql = """
                SELECT *
                FROM Player
                WHERE IsActive = true;
                """;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            return PlayerMapper.mapMultiple(rs);

        } catch (SQLException sqle) {
            log.error("Error fetching active players: {}", sqle.getMessage(), sqle);
            return List.of();
        }
    }

    public void insert(Player player) {
        String sql = """
                INSERT INTO Player(Id, Name, Background, Class, Story_Save, IsActive, SituationsCounter)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, player.getId().toString());
            stmt.setString(2, player.getName());
            stmt.setString(3, player.getBackground().toString());
            stmt.setString(4, player.getPlayerClass().toString());
            stmt.setString(5, player.getStorySave().toString());
            stmt.setBoolean(6, player.getIsActive());
            stmt.setInt(7, player.getSituationsCounter());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            log.error("Error inserting player {}: {}", player.getId(), ex.getMessage(), ex);
        }
    }

    public void update(Player player) {
        String sql = """
                UPDATE Player
                SET Name = ?,
                    Background = ?,
                    Class = ?,
                    Story_Save = ?,
                    IsActive = ?,
                    SituationsCounter = ?
                WHERE Id = ?;
                """;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, player.getName());
            stmt.setString(2, player.getBackground().toString());
            stmt.setString(3, player.getPlayerClass().toString());
            stmt.setString(4, player.getStorySave().toString());
            stmt.setBoolean(5, player.getIsActive());
            stmt.setInt(6, player.getSituationsCounter());
            stmt.setString(7, String.valueOf(player.getId()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            log.error("Error updating player {}: {}", player.getId(), ex.getMessage(), ex);
        }
    }

    public void delete(Player player) {
        String sql = """
                DELETE FROM Player
                WHERE Id = ?;
                """;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, player.getId().toString());
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            log.error(sqle.getMessage());
        }
    }
}
