package hexagonal_architecture.ordercontext.infrastructure.cache;

import hexagonal_architecture.ordercontext.application.cache.CacheClient;

import java.util.Optional;

/**
 * DateTime 2018/8/7 14:03
 *
 * @author db
 **/
public class RedisCacheClient<T> implements CacheClient<T> {

    @Override
    public Optional<T> get(String key) {
        return Optional.empty();
    }

    @Override
    public void put(String key, T value) {

    }
}
