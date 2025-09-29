package game.text_adventure.repository;

import game.text_adventure.dto.PlayerBackgroundOption;
import game.text_adventure.dto.PlayerClassOption;
import game.text_adventure.mapper.PlayerBackgroundOptionMapper;
import game.text_adventure.mapper.PlayerClassOptionMapper;
import lombok.extern.slf4j.Slf4j;

import java.sql.PreparedStatement;
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
        try {
            return PlayerClassOptionMapper.mapMultiple(connection.prepareStatement(sql).executeQuery());
        } catch (SQLException sqle) {
            log.error(sqle.getMessage());
            return List.of();
        }
    }

    public Optional<PlayerClassOption> findById(UUID id) {
        String sql = """
            SELECT * FROM PlayerClassOption
            WHERE Id = ?;
            """;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, id.toString());
            return PlayerClassOptionMapper.map(stmt.executeQuery());
        } catch (SQLException sqle) {
            log.error(sqle.getMessage());
            return Optional.empty();
        }
    }
}
