package com.CricStats.Cricfuzz.Data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Getter @Setter
@AllArgsConstructor
public class Player {

    private String name;
    private String nation;
    private String style;
    private String team;

}
