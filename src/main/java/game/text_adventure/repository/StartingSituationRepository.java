package game.text_adventure.repository;

import game.text_adventure.dto.StartingSituation;
import game.text_adventure.mapper.StartingSituationMapper;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class StartingSituationRepository extends RepositoryBase {
    public Optional<StartingSituation> findByClassAndBackground(UUID classOptionId, UUID backgroundOptionId) {
        String sql = """
                SELECT * FROM StartingSituation
                WHERE ClassOptionId = ? AND BackgroundOptionId = ?;
                """;

        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, classOptionId.toString());
            stmt.setString(2, backgroundOptionId.toString());

            return StartingSituationMapper.map(stmt.executeQuery());
        } catch (SQLException e) {
            log.error("Fehler beim Laden der StartingSituation: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
