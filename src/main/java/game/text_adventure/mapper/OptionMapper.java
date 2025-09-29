package game.text_adventure.mapper;

import game.text_adventure.dto.Option;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public final class OptionMapper {
    public static Optional<Option> map(ResultSet rs) {
        try {
            Option option = new Option();
            option.setId(UUID.fromString(rs.getString("Id")));
            option.setName(rs.getString("Name"));
            option.setDescription(rs.getString("Description"));
            return Optional.of(option);
        } catch (SQLException sqle) {
            log.debug(sqle.getMessage(), sqle);
        }
        return Optional.empty();
    }

    public static List<Option> mapMultiple(ResultSet rs) {
        List<Option> options = new ArrayList<>();
        try {
            while (rs.next()) {
                Optional<Option> p = map(rs);
                p.ifPresent(options::add);
            }
        } catch (SQLException sqle) {
            log.debug(sqle.getMessage(), sqle);
        }
        return options;
    }
}