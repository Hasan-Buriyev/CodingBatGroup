package uz.pdp.app_codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.app_codingbat.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {

}
