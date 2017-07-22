package rm.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rm.documents.Player;
import rm.repository.PlayerRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by roman on 25/06/17.
 */
@Component
public class PlayerManager {

    @Autowired
    private PlayerRepository repository;

    public Player insertPlayer(Player player) {
        repository.savePlayer(player);
        return  player;
    }

    public List<Player> getAllPlayers(){
        Map<Object, Object> allPlayers = repository.findAllPlayers();
        return   allPlayers.entrySet()
                .stream()
                .map(entry ->(Player)entry.getValue())
                .collect(Collectors.toList());
    }

}
