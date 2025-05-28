package com.CricStats.Cricfuzz.Data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Getter @Setter
public class Player {

    private String name;
    private String nation;
    private String style;
    private String team;

}
