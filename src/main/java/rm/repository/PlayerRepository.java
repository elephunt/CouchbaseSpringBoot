package rm.repository;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import rm.documents.Player;

/**
 * Created by roman on 25/06/17.
 */
public interface PlayerRepository extends CouchbaseRepository<Player, Long> {


}
