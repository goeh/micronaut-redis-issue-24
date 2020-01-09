package redis.password.issue;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

@Controller("/")
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @Get("/{key}")
    public String get(String key) {
        return redisService.get(key);
    }

    @Post
    public String set(String key, @Body String value) {
        return redisService.set(key, value);
    }
}
