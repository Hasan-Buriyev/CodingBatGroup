package uz.pdp.app_codingbat.mapper;

import uz.pdp.app_codingbat.entity.Category;
import uz.pdp.app_codingbat.entity.Problem;
import uz.pdp.app_codingbat.payload.problem.req.ReqProblem;
import uz.pdp.app_codingbat.payload.problem.res.ResProblem;

public interface ProblemMapper {

    static Problem fromEntityToDto(ReqProblem reqProblem, Category category){
        return Problem.builder()
                .title(reqProblem.getTitle())
                .description(reqProblem.getDescription())
                .category(category)
                .methodName(reqProblem.getMethodName())
                .question(reqProblem.getQuestion())
                .solution(reqProblem.getSolution())
                .build();
    }
    static ResProblem fromDtoToEntity(Problem problem){
        return ResProblem.builder()
                .id(problem.getId())
                .title(problem.getTitle())
                .description(problem.getDescription())
                .category(problem.getCategory())
                .methodName(problem.getMethodName())
                .question(problem.getQuestion())
                .solution(problem.getSolution())
                .build();
    }

}
