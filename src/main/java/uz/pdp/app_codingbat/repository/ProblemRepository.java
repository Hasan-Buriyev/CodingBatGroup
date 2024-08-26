package uz.pdp.app_codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.app_codingbat.entity.Problem;

import java.util.List;
import java.util.Optional;


public interface ProblemRepository extends JpaRepository<Problem, Long> {
  Optional<List<Problem>>findAllByCategoryId(Long categoryId);
  Optional<Problem> findByTitle(String title, String noteCategory);
}
