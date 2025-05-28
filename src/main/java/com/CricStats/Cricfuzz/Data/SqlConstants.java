package com.CricStats.Cricfuzz.Data;

public class SqlConstants {

    public static final String GET_ALL = "SELECT * FROM player_stats";

    public static final String GET1 = "SELECT * FROM player_stats WHERE name =:name";

    public static final String SAVE = "INSERT INTO player_stats (name,nation,style,team) VALUES (:name,:nation,:style,:team)";

    public static final String UPDATE = "UPDATE player_stats SET name = :name, nation = :nation, style = :style, team = :team";

    public static final String DELETE = "DELETE FROM player_stats WHERE name = :name";
}
