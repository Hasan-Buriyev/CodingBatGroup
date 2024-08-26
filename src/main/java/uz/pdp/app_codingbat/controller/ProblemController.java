package uz.pdp.app_codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.app_codingbat.config.core.BaseURI;
import uz.pdp.app_codingbat.payload.base.ApiResult;
import uz.pdp.app_codingbat.payload.problem.req.ReqProblem;
import uz.pdp.app_codingbat.payload.problem.res.ResProblem;
import uz.pdp.app_codingbat.repository.UserRepository;
import uz.pdp.app_codingbat.service.AuthService;
import uz.pdp.app_codingbat.service.ProblemService;

@RestController
@RequestMapping(BaseURI.API1 + BaseURI.USER)
@RequiredArgsConstructor

public class ProblemController {

    private final ProblemService problemService;

    @PostMapping(BaseURI.CREATE)
    public ApiResult<ResProblem> create(@RequestBody ReqProblem reqProblem) {
        return ApiResult.successResponse(problemService.create(reqProblem));
    }

}
