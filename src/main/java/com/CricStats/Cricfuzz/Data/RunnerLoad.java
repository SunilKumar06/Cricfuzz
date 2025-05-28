package com.CricStats.Cricfuzz.Data;

import com.CricStats.Cricfuzz.DAO.PlayerRepoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunnerLoad {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepoDAO playerRepoDAO){
        return args -> {
            Player Dhoni = new Player("MS Dhoni","India","W-Batsman","CSK");
            playerRepoDAO.save(Dhoni);
            System.out.println("Success: Player Record Saved");
        };
    }
}
