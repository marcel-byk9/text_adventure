package game.text_adventure.mapper;

import game.text_adventure.dto.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class PlayerMapper {
    public static Player mapPlayer(ResultSet rs) throws SQLException {
        Player player = new Player();
        player.setId(UUID.fromString(rs.getString("Id")));
        player.setName(rs.getString("Name"));
        player.setBackground(rs.getString("Background"));
        player.setPlayerClass(rs.getString("PlayerClass"));
        player.setStorySave(rs.getString("Story_Save"));
        player.setIsActive(rs.getBoolean("IsActive"));
        player.setSituationsCounter(rs.getInt("SituationsCounter"));
        return player;
    }

    public static List<Player> mapPlayers(ResultSet rs) throws SQLException {
        List<Player> players = new ArrayList<>();
        while (rs.next()) {
            players.add(mapPlayer(rs));
        }
        return players;
    }
}
