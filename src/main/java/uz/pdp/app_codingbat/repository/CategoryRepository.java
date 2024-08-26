package uz.pdp.app_codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.app_codingbat.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<List<Category>> findAllByLanguageId(UUID language_id);

    @Query(value = "SELECT CASE WHEN count(*) = 0 THEN true ELSE false END FROM coding_bat.category c  WHERE c.name = :categoryName AND c.language_id != :languageId"
            ,nativeQuery = true)
    boolean checkCategoryNameForUnique(String categoryName, UUID languageId);

    @Query(value = "SELECT CASE WHEN count(*) = 0 THEN true ELSE false END FROM coding_bat.category c WHERE c.name = :newCategoryName AND c.id != :categoryId AND c.language_id = :languageId"
            ,nativeQuery = true)
    boolean checkUnique(String newCategoryName, Long categoryId, UUID languageId);
}
