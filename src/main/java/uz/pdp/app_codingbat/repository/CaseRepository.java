package uz.pdp.app_codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.app_codingbat.entity.Case;

import java.util.List;
import java.util.Optional;

public interface CaseRepository extends JpaRepository<Case, Long> {
    Optional<List<Case>> findAllByProblemId(Long projectId);
}
