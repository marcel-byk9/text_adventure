package game.text_adventure.repository;

import game.text_adventure.dto.Player;
import game.text_adventure.dto.PlayerBackgroundOption;
import game.text_adventure.mapper.PlayerBackgroundOptionMapper;
import game.text_adventure.mapper.PlayerMapper;
import game.text_adventure.mapper.SituationMapper;
import lombok.extern.slf4j.Slf4j;

import java.sql.PreparedStatement;
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
        try {
            return PlayerBackgroundOptionMapper.mapMultiple(connection.prepareStatement(sql).executeQuery());
        } catch (SQLException sqle) {
            log.error(sqle.getMessage());
            return List.of();
        }
    }

    public Optional<PlayerBackgroundOption> findById(UUID id) {
        String sql = """
            SELECT * FROM PlayerBackgroundOption
            WHERE Id = ?;
            """;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, id.toString());
            return PlayerBackgroundOptionMapper.map(stmt.executeQuery());
        } catch (SQLException sqle) {
            log.error(sqle.getMessage());
            return Optional.empty();
        }
    }
}
