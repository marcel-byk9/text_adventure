package game.text_adventure.mapper;

import game.text_adventure.dto.Situation;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public final class SituationMapper {
    public static Optional<Situation> map(ResultSet rs) {
        try {
            Situation situation = new Situation();
            situation.setId(UUID.fromString(rs.getString("Id")));
            situation.setDescription(rs.getString("Description"));
            situation.setIsEnding(rs.getBoolean("IsEnding"));
            return Optional.of(situation);
        } catch (SQLException sqle) {
            log.debug(sqle.getMessage(), sqle);
        }
        return Optional.empty();
    }

    public static List<Situation> mapMultiple(ResultSet rs) {
        List<Situation> situations = new ArrayList<>();
        try {
            while (rs.next()) {
                Optional<Situation> p = map(rs);
                p.ifPresent(situations::add);
            }
        } catch (SQLException sqle) {
            log.debug(sqle.getMessage(), sqle);
        }
        return situations;
    }
}
