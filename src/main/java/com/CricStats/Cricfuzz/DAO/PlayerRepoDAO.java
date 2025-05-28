package com.CricStats.Cricfuzz.DAO;

import com.CricStats.Cricfuzz.Data.Player;
import com.CricStats.Cricfuzz.Data.SqlConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public class PlayerRepoDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Player> get()
    {
        return namedParameterJdbcTemplate.query(SqlConstants.GET_ALL,new BeanPropertyRowMapper<>(Player.class));
    }

    public List<Player> get1()
    {
        return namedParameterJdbcTemplate.query(SqlConstants.GET1,new BeanPropertyRowMapper<>(Player.class));
    }

    @Transactional
    public int save(Player player)
    {
        return namedParameterJdbcTemplate.update(SqlConstants.SAVE, Map.of("name",player.getName(),
                                                                "nation",player.getNation(),
                                                                "style",player.getStyle(),
                                                                "team",player.getTeam()));
    }

    @Transactional
    public int update(Player player)
    {
        return namedParameterJdbcTemplate.update(SqlConstants.UPDATE, Map.of("name",player.getName(),
                "nation",player.getNation(),
                "style",player.getStyle(),
                "team",player.getTeam()));
    }

    @Transactional
    public int delete(String name)
    {
        return namedParameterJdbcTemplate.update(SqlConstants.DELETE,Map.of("name", name));
    }


}
