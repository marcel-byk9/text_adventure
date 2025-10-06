package game.text_adventure.repository;

import game.text_adventure.dto.PlayerBackgroundOption;
import game.text_adventure.mapper.PlayerBackgroundOptionMapper;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class PlayerBackgroundOptionRepository extends RepositoryBase {
    public List<PlayerBackgroundOption> findAll() {
        String sql = """
                SELECT * FROM PlayerBackgroundOption;
                """;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            return PlayerBackgroundOptionMapper.mapMultiple(rs);
        } catch (SQLException ex) {
            log.error("Error fetching all PlayerBackgroundOptions: {}", ex.getMessage(), ex);
            return List.of();
        }
    }

    public Optional<PlayerBackgroundOption> findById(UUID id) {
        String sql = """
            SELECT * FROM PlayerBackgroundOption
            WHERE Id = ?;
            """;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                return PlayerBackgroundOptionMapper.map(rs);
            }
        } catch (SQLException ex) {
            log.error("Error fetching PlayerBackgroundOption by ID {}: {}", id, ex.getMessage(), ex);
            return Optional.empty();
        }
    }
}
