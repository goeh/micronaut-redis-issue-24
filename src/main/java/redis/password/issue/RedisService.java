package redis.password.issue;

import io.lettuce.core.api.StatefulRedisConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class RedisService {

    private static final Logger log = LoggerFactory.getLogger(RedisService.class);

    private final StatefulRedisConnection<String, String> redis;

    public RedisService(StatefulRedisConnection<String, String> redis) {
        this.redis = redis;
    }

    public String set(String key, String value) {
        redis.sync().set(key, value);
        return value;
    }

    public String get(String key) {
        return redis.sync().get(key);
    }
}
