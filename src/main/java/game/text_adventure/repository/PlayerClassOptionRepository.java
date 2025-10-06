package game.text_adventure.repository;

import game.text_adventure.dto.PlayerClassOption;
import game.text_adventure.mapper.PlayerClassOptionMapper;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class PlayerClassOptionRepository extends RepositoryBase{
    public List<PlayerClassOption> findAll() {
        String sql = """
                SELECT * FROM PlayerClassOption;
                """;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            return PlayerClassOptionMapper.mapMultiple(rs);
        } catch (SQLException sqle) {
            log.error("Error fetching all PlayerClassOptions: {}", sqle.getMessage(), sqle);
            return List.of();
        }
    }

    public Optional<PlayerClassOption> findById(UUID id) {
        String sql = """
            SELECT * FROM PlayerClassOption
            WHERE Id = ?;
            """;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());

            try (ResultSet rs = stmt.executeQuery()) {
                return PlayerClassOptionMapper.map(rs);
            }
        } catch (SQLException sqle) {
            log.error("Error fetching PlayerClassOption by ID {}: {}", id, sqle.getMessage(), sqle);
            return Optional.empty();
        }
    }
}
