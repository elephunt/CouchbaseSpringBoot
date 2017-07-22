package rm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import rm.documents.Player;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by roman on 22/07/17.
 */
@Repository
public class PlayerRepositoryImpl implements PlayerRepository {

    private static final String KEY = "Player";

    private RedisTemplate<String,Player> redisTemplate;

    private HashOperations hashOperations;

    @Autowired
    public PlayerRepositoryImpl(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init(){
        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public void savePlayer(Player player) {
             hashOperations.put(KEY,player.getId(),player);
    }

    @Override
    public void updatePlayer(Player player) {
        hashOperations.put(KEY,player.getId(),player);
    }

    @Override
    public Player findPlayer(String id) {
      return (Player) hashOperations.get(KEY,id);
    }

    @Override
    public Map<Object, Object> findAllPlayers() {
       return hashOperations.entries(KEY);
    }
}
