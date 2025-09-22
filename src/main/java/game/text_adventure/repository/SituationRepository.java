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
}
