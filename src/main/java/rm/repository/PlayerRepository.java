package rm.repository;

import rm.documents.Player;

import java.util.Map;

/**
 * Created by roman on 22/07/17.
 */
public interface PlayerRepository {

    void savePlayer(Player player);

    void updatePlayer(Player player);

    Player findPlayer(String id);

    Map<Object,Object> findAllPlayers();

}
