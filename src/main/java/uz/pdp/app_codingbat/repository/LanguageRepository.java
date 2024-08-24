package uz.pdp.app_codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.app_codingbat.entity.Language;

import java.util.Optional;
import java.util.UUID;

public interface LanguageRepository extends JpaRepository<Language, UUID> {

    Optional<Language> findByName(String name);
    boolean existsByName(String name);

    @Query(value = "SELECT count(*)==0 as name  FROM language l WHERE l.name = :name AND l.id != :id",nativeQuery = true)
    boolean existsByNameAndNotId(String name, UUID id);

}
