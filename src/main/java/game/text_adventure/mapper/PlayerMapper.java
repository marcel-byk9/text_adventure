package game.text_adventure.mapper;

import game.text_adventure.dto.Player;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public final class PlayerMapper {
    public static Optional<Player> map(ResultSet rs) {
        try {
            Player player = new Player();
            String idString = rs.getString("Id");
            player.setId(UUID.fromString(idString));
            player.setName(rs.getString("Name"));
            player.setBackground(UUID.fromString(rs.getString("Background")));
            player.setPlayerClass(UUID.fromString(rs.getString("Class")));
            player.setStorySave(UUID.fromString(rs.getString("Story_Save")));
            player.setIsActive(rs.getBoolean("IsActive"));
            player.setSituationsCounter(rs.getInt("SituationsCounter"));
            return Optional.of(player);
        } catch (SQLException sqle) {
            log.debug(sqle.getMessage(), sqle);
        }
        return Optional.empty();
    }

    public static List<Player> mapMultiple(ResultSet rs) {
        List<Player> players = new ArrayList<>();
        try {
            while (rs.next()) {
                Optional<Player> p = map(rs);
                p.ifPresent(players::add);
            }
        } catch (SQLException sqle) {
            log.debug(sqle.getMessage(), sqle);
        }
        return players;
    }
}
