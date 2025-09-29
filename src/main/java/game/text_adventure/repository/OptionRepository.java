package game.text_adventure.repository;

import lombok.extern.slf4j.Slf4j;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

// TODO improve rough implementation
@Slf4j
public class OptionRepository extends RepositoryBase {

    public Optional<UUID> findNextSituationIdByOptionId(UUID optionId) {
        String sql = """
            SELECT Next_Situation FROM Storytelling
            WHERE Option = ?;
        """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, optionId.toString());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nextId = rs.getString("Next_Situation");
                return Optional.of(UUID.fromString(nextId));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            log.error("Fehler beim Abrufen der nächsten Situation für Option {}: {}", optionId, e.getMessage());
            return Optional.empty();
        }
    }
}