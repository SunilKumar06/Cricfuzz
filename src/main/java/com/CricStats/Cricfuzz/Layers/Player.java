package com.CricStats.Cricfuzz.Layers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Getter @Setter
public class Player {

    private String name;
    private String nation;
    private String role;
    private String style;
    private int age;
    private int ranking;
    private double runs;
    private double wickets;
    private String team;

}
