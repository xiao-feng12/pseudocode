package hexagonal_architecture.ordercontext.application.cache;

import java.util.Optional;

/**
 * DateTime 2018/8/7 14:01
 *
 * @author db
 **/
public interface CacheClient<T> {
    Optional<T> get(String key);

    void put(String key, T value);
}
