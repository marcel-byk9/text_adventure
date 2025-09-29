package game.text_adventure.mapper;

import game.text_adventure.dto.PlayerClassOption;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class PlayerClassOptionMapper {
    public static Optional<PlayerClassOption> map(ResultSet rs) {
        try {
            PlayerClassOption PlayerClassOption = new PlayerClassOption();
            PlayerClassOption.setId(UUID.fromString(rs.getString("Id")));
            PlayerClassOption.setName(rs.getString("Name"));
            PlayerClassOption.setDescription(rs.getString("Description"));
            return Optional.of(PlayerClassOption);
        } catch (SQLException sqle) {
            log.debug(sqle.getMessage(), sqle);
        }
        return Optional.empty();
    }

    public static List<PlayerClassOption> mapMultiple(ResultSet rs) {
        List<PlayerClassOption> PlayerClassOptions = new ArrayList<>();
        try {
            while (rs.next()) {
                Optional<PlayerClassOption> p = map(rs);
                p.ifPresent(PlayerClassOptions::add);
            }
        } catch (SQLException sqle) {
            log.debug(sqle.getMessage(), sqle);
        }
        return PlayerClassOptions;
    }
}
