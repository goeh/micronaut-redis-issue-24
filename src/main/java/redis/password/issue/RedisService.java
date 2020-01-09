package redis.password.issue;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
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
        RedisCommands<String, String> commands = redis.sync();
        commands.multi();
        commands.set(key, value);
        commands.exec();
        commands.discard();
        return value;
    }

    public String get(String key) {
        RedisCommands<String, String> commands = redis.sync();
        commands.multi();
        String value = commands.get(key);
        commands.exec();
        commands.discard();
        return value;
    }
}
