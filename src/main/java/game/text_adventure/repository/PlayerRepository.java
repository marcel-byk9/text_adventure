package game.text_adventure.repository;

import game.text_adventure.dto.Player;
import game.text_adventure.mapper.PlayerMapper;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.util.List;

@Slf4j
public class PlayerRepository extends RepositoryBase {
    public List<Player> findAllByIsActiveTrue() {
        String sql = """
                SELECT * FROM Player WHERE IsActive = true
                """;
        try {
            return PlayerMapper.mapPlayers(super.preparedStatement(sql).executeQuery());
        } catch (SQLException sqle) {
            log.error(sqle.getMessage());
            return null;
        }
    }
}
