package game.text_adventure.repository;

import game.text_adventure.dto.Situation;
import game.text_adventure.mapper.SituationMapper;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class SituationRepository extends RepositoryBase {
    public Optional<Situation> findById(UUID id) {
        String sql = """
                SELECT * FROM Situation
                WHERE Id = ?;
                """;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id.toString());
            return SituationMapper.map(stmt.executeQuery());
        } catch (SQLException sqle) {
            log.error(sqle.getMessage());
            return Optional.empty();
        }
    }

    public Optional<Situation> findNextSituationByOptionId(UUID situationId, UUID optionId) {
        String sql = """
            SELECT * FROM Situation
            WHERE Id = (
                SELECT Next_Situation
                FROM Storytelling
                WHERE Situation = ?
                AND Option = ?
            );
            """;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, situationId.toString());
            stmt.setString(2, optionId.toString());
            return SituationMapper.map(stmt.executeQuery());
        } catch (SQLException e) {
            log.error("Fehler beim Abrufen der nächsten Situation für Option {}: {}", situationId, e.getMessage());
            return Optional.empty();
        }
    }
}
