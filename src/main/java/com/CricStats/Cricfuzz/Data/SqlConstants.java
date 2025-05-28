package com.CricStats.Cricfuzz.Data;

public class SqlConstants {

    public static final String GET_ALL = "SELECT * FROM player";

    public static final String SAVE = "INSERT INTO player (name,nation,style,team) VALUES (:name,:nation,:style,:team)";

    public static final String UPDATE = "UPDATE player SET name = :name, nation = :nation, style = :style, team = :team";

    public static final String DELETE = "DELETE FROM player WHERE name = :name";
}
