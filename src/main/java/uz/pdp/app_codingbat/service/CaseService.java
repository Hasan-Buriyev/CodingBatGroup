package uz.pdp.app_codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.app_codingbat.entity.Case;
import uz.pdp.app_codingbat.entity.Problem;
import uz.pdp.app_codingbat.enums.ErrorTypeEnum;
import uz.pdp.app_codingbat.exceptions.RestException;
import uz.pdp.app_codingbat.mapper.CaseMapper;
import uz.pdp.app_codingbat.payload.cases.req.ReqCreateCase;
import uz.pdp.app_codingbat.payload.cases.req.ReqUpdateCase;
import uz.pdp.app_codingbat.payload.cases.res.ResCase;
import uz.pdp.app_codingbat.repository.CaseRepository;
import uz.pdp.app_codingbat.repository.ProblemRepository;

@Service
@RequiredArgsConstructor
public class CaseService {
    private final CaseRepository caseRepository;
    private final ProblemRepository problemRepository;

    public ResCase create(ReqCreateCase req){
        Problem problem = getProblem(req.getProblem());

        Case aCase = CaseMapper.fromReqToEntity(req, problem);

        caseRepository.save(aCase);

        return CaseMapper.fromEntityToDto(aCase);
    }

    public ResCase update(ReqUpdateCase req){
        Problem problem = getProblem(req.getProblem());

        Case aCase = getCase(req.getId());

        CaseMapper.updateCaseFromReq(
                aCase,
                req,
                problem
        );

        caseRepository.save(aCase);

        return CaseMapper.fromEntityToDto(aCase);
    }

    public ResCase delete(Long id){
        Case aCase = getCase(id);
        caseRepository.delete(aCase);
        return CaseMapper.fromEntityToDto(aCase);
    }


    private Problem getProblem(Long id){
        return problemRepository.findById(id)
                .orElseThrow(() -> RestException.restThrow(ErrorTypeEnum.PROBLEM_NOT_FOUND));
    }
    private Case getCase(Long id){
        return caseRepository.findById(id)
                .orElseThrow(() -> RestException.restThrow(ErrorTypeEnum.CASE_NOT_FOUND));
    }
}
