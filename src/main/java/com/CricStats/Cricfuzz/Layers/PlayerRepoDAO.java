package com.CricStats.Cricfuzz.Layers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
public class PlayerRepoDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


}
