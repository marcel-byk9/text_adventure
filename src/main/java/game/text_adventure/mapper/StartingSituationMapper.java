package game.text_adventure.mapper;

import game.text_adventure.dto.StartingSituation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public class StartingSituationMapper {
    public static Optional<StartingSituation> map(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return Optional.empty();
        }

        StartingSituation startingSituation = new StartingSituation();
        startingSituation.setId(UUID.fromString(rs.getString("id")));
        startingSituation.setClassOptionId(UUID.fromString(rs.getString("ClassOptionId")));
        startingSituation.setSituationId(UUID.fromString(rs.getString("SituationId")));
        return Optional.of(startingSituation);
    }
}
