package domain.core.concepts;

import java.util.Optional;

public interface Repository<T> {
    void save(T t);

    T findById(String id);

    void deleteById(String id);

}
