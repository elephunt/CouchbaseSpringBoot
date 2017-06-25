package rm.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Arrays;
import java.util.List;

/**
 * Created by roman on 25/06/17.
 */
@Configuration
@EnableCouchbaseRepositories
public class CouchBaseConfiguration extends AbstractCouchbaseConfiguration {

    private String bucketName = "roman";

    private String password = "adminadmin";

    private String userName = "admin";


    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList("localhost");
    }

    @Override
    protected String getBucketName() {
        return bucketName;
    }

    @Override
    protected String getBucketPassword() {
        return password;
    }
}
