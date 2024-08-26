package uz.pdp.app_codingbat.mapper;

import uz.pdp.app_codingbat.entity.Case;
import uz.pdp.app_codingbat.entity.Problem;
import uz.pdp.app_codingbat.payload.cases.req.ReqCreateCase;
import uz.pdp.app_codingbat.payload.cases.req.ReqUpdateCase;
import uz.pdp.app_codingbat.payload.cases.res.ResCase;

import static uz.pdp.app_codingbat.utils.CoreUtils.getIfExists;

public interface CaseMapper {

    static Case fromReqToEntity(ReqCreateCase req, Problem problem){
        return Case.builder()
                .args(req.getArgs())
                .expected(req.getExpected())
                .visible(req.getVisible())
                .problem(problem)
                .build();
    }

    static ResCase fromEntityToDto(Case aCase){
        return ResCase.builder()
                .id(aCase.getId())
                .args(aCase.getArgs())
                .expected(aCase.getExpected())
                .visible(aCase.getVisible())
                .problem(aCase.getProblem().getId())
                .createdAt(aCase.getCreatedAt())
                .updatedAt(aCase.getUpdatedAt())
                .deleted(aCase.isDeleted())
                .build();
    }

    static void updateCaseFromReq(Case aCase, ReqUpdateCase req, Problem problem){
        aCase.setArgs(getIfExists(req.getArgs(), aCase.getArgs()));
        aCase.setExpected(getIfExists(req.getExpected(), aCase.getExpected()));
        aCase.setVisible(getIfExists(req.getVisible(), aCase.getVisible()));
        aCase.setProblem(getIfExists(problem, aCase.getProblem()));
    }
}
