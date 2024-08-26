package uz.pdp.app_codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.app_codingbat.entity.Category;
import uz.pdp.app_codingbat.entity.Problem;
import uz.pdp.app_codingbat.enums.ErrorTypeEnum;
import uz.pdp.app_codingbat.exceptions.RestException;
import uz.pdp.app_codingbat.mapper.ProblemMapper;
import uz.pdp.app_codingbat.payload.problem.req.ReqProblem;
import uz.pdp.app_codingbat.payload.problem.res.ResProblem;
import uz.pdp.app_codingbat.repository.CategoryRepository;
import uz.pdp.app_codingbat.repository.ProblemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProblemService {
    private final ProblemRepository problemRepository;
    private final CategoryRepository categoryRepository;

    public ResProblem create(ReqProblem req) {
        Category category1 = getCategoryById(req.getCategoryId());

        Problem problem = ProblemMapper.fromEntityToDto(req,category1);

        return ProblemMapper.fromDtoToEntity(problemRepository.save(problem));

    }

    public ResProblem update(ReqProblem req) {
        Category category2 = getCategoryById(req.getCategoryId());

        Problem problem = ProblemMapper.fromEntityToDto(req,category2);

        return ProblemMapper.fromDtoToEntity(problemRepository.save(problem));


    }


    private Problem getProblemById(Long id) {
        return problemRepository.findById(id).orElseThrow(RestException.thew(ErrorTypeEnum.PROBLEM_NOT_FOUND));
    }

    private Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(RestException.thew(ErrorTypeEnum.CATEGORY_NOT_FOUND));
    }

}
