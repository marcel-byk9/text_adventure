package game.text_adventure.repository;

import game.text_adventure.dto.Option;
import game.text_adventure.mapper.OptionMapper;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Slf4j
public class OptionRepository extends RepositoryBase {
    public List<Option> findOptionsBySituationId(UUID id) {
        String sql = """
                SELECT o.*
                FROM StoryTelling s
                JOIN Option o ON s.Option = o.Id
                WHERE s.Situation = ?;
                """;
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                return OptionMapper.mapMultiple(rs);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            return List.of();
        }
    }
}