package guru.springframework.repositories;

import guru.springframework.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {

    Optional<Category> findByDescription(String description);

    List<Category> findAllByDescription(String description);
}
