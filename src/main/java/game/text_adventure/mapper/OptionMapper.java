package game.text_adventure.mapper;

import game.text_adventure.dto.Option;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OptionMapper {

    public static List<Option> mapAll(ResultSet rs) throws SQLException {
        List<Option> options = new ArrayList<>();
        while (rs.next()) {
            Option option = new Option();
            option.setId(rs.getString("Id"));
            option.setDescription(rs.getString("Description"));
            options.add(option);
        }
        return options;
    }
}