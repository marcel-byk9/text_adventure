package game.text_adventure.repository;

import game.text_adventure.dto.Option;
import game.text_adventure.dto.Situation;
import game.text_adventure.mapper.SituationMapper;
import lombok.extern.slf4j.Slf4j;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public Optional<List<Option>> findOptionsBySituationId(UUID situationId) {
        String sql = """
                SELECT o.* 
                FROM StoryTelling s
                JOIN Option o ON s.Option = o.Id
                WHERE s.Situation = ?;
        """;

        List<Option> options = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, situationId.toString());
            options = OptionsMapper.mapAll(stmt.executeQuery());
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Optional.empty();
        }
        return Optional.of(options);
    }
}
