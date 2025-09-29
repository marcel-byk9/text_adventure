package game.text_adventure.mapper;

import game.text_adventure.dto.PlayerBackgroundOption;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class PlayerBackgroundOptionMapper {

    public static Optional<PlayerBackgroundOption> map(ResultSet rs) {
        try {
            PlayerBackgroundOption playerBackgroundOption = new PlayerBackgroundOption();
            playerBackgroundOption.setId(UUID.fromString(rs.getString("Id")));
            playerBackgroundOption.setName(rs.getString("Name"));
            playerBackgroundOption.setDescription(rs.getString("Description"));
            return Optional.of(playerBackgroundOption);
        } catch (SQLException sqle) {
            log.debug(sqle.getMessage(), sqle);
        }
        return Optional.empty();
    }

    public static List<PlayerBackgroundOption> mapMultiple(ResultSet rs) {
        List<PlayerBackgroundOption> playerBackgroundOptions = new ArrayList<>();
        try {
            while (rs.next()) {
                Optional<PlayerBackgroundOption> p = map(rs);
                p.ifPresent(playerBackgroundOptions::add);
            }
        } catch (SQLException sqle) {
            log.debug(sqle.getMessage(), sqle);
        }
        return playerBackgroundOptions;
    }
}
