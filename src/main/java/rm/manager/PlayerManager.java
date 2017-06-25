package rm.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rm.documents.Player;
import rm.repository.PlayerRepository;

/**
 * Created by roman on 25/06/17.
 */
@Component
public class PlayerManager {

    @Autowired
    private PlayerRepository repository;

    public Player insertPlayer(Player player) {
        return this.repository.save(player);
    }

}
