package gadour.springboot.energy.Services;

import java.util.Set;

public interface CrudService <T, ID> {
    Set<T> findAll();
    T save(T object);
}
