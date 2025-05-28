package com.CricStats.Cricfuzz.Controller;

import com.CricStats.Cricfuzz.DAO.PlayerRepoDAO;
import com.CricStats.Cricfuzz.Data.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/players")
public class PlayerController {


    private PlayerRepoDAO playerRepoDAO;

    @Autowired
    public PlayerController(PlayerRepoDAO playerRepoDAO) {
        this.playerRepoDAO = playerRepoDAO;
    }

    @GetMapping
    public List<Player> getPlayers()
    {
        return playerRepoDAO.get();
    }

    @PostMapping
    public String addPlayer(@RequestBody Player player)
    {
        playerRepoDAO.save(player);
        return "Added Successfully";
    }

    @PutMapping
    public String udpatePlayer(@RequestBody Player player)
    {
        playerRepoDAO.update(player);
        return "Updated Successfully";
    }

    @DeleteMapping
    public String deletePlayer(String name)
    {
        playerRepoDAO.delete(name);
        return "Deleted Successfully";
    }

}

