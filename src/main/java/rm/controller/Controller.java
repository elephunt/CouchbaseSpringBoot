package rm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rm.documents.Player;
import rm.manager.PlayerManager;

/**
 * Created by roman on 25/06/17.
 */
@RestController
@RequestMapping("/players/")
public class Controller {

    @Autowired
    private PlayerManager manager;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllPlayers() {
        return "{\n" +
                "  \"name\":\"Roman\",\n" +
                "  \"lastname\":\"Margolin\"\n" +
                "}";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST, consumes = "application/json")
    public String insert(@RequestBody Player player) {
        return this.manager.insertPlayer(player).toString();
    }


}
