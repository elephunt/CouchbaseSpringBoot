package rm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rm.documents.Player;
import rm.manager.PlayerManager;

import java.util.List;
import java.util.Random;

/**
 * Created by roman on 25/06/17.
 */
@RestController
@RequestMapping("/players/")
public class Controller {

    @Autowired
    private PlayerManager manager;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<Player> getAllPlayers() {
        return manager.getAllPlayers();
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST, consumes = "application/json")
    public String insert(@RequestBody Player player) {
        return this.manager.insertPlayer(player).toString();
    }


    @RequestMapping(value = "mock" , method = RequestMethod.GET)
    public void insertPlayer(){
        Random random = new Random();
        Player player = new Player();
        player.setId(random.nextLong());
        player.setName("Roman");
        player.setLastName("Margolin");
        manager.insertPlayer(player);
    }

}
