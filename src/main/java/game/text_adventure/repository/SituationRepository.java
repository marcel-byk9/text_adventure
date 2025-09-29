package game.text_adventure.repository;

import game.text_adventure.dto.Situation;
import game.text_adventure.mapper.SituationMapper;
import lombok.extern.slf4j.Slf4j;

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
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, id.toString());
            return SituationMapper.map(stmt.executeQuery());
        } catch (SQLException sqle) {
            log.error(sqle.getMessage());
            return Optional.empty();
        }
    }

    public Optional<Situation> findNextSituationByOptionId(UUID optionId) {
        String sql = """
            SELECT *
            FROM Situation
            WHERE Id = (
                SELECT Next_Situation
                FROM Storytelling
                WHERE Option = ?
            );
            """;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, optionId.toString());
            return SituationMapper.map(connection.prepareStatement(sql).executeQuery());
        } catch (SQLException e) {
            log.error("Fehler beim Abrufen der nächsten Situation für Option {}: {}", optionId, e.getMessage());
            return Optional.empty();
        }
    }
}
