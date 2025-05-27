package com.CricStats.Cricfuzz.Layers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PlayerRepoDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Player> get()
    {
        String sql = "SELECT * FROM player";
        return namedParameterJdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Player.class));
    }

    public int save(Player player)
    {
        String sql = "INSERT INTO player (name,nation,style,team) VALUES (:name,:nation,:style,:team)";
        return namedParameterJdbcTemplate.update(sql, Map.of("name",player.getName(),
                                                                "nation",player.getNation(),
                                                                "style",player.getStyle(),
                                                                "team",player.getTeam()));
    }

    public int update(Player player)
    {
        String sql = "UPDATE player SET name = :name, nation = :nation, style = :style, team = :team";
        return namedParameterJdbcTemplate.update(sql, Map.of("name",player.getName(),
                "nation",player.getNation(),
                "style",player.getStyle(),
                "team",player.getTeam()));
    }

    public int delete(String name)
    {
        String sql = " DELETE FROM player WHERE name = :name";
        return namedParameterJdbcTemplate.update(sql,Map.of("name", name));
    }


}
