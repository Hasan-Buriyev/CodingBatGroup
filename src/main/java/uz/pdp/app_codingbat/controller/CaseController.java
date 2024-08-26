package uz.pdp.app_codingbat.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.app_codingbat.config.core.BaseURI;
import uz.pdp.app_codingbat.payload.base.ApiResult;
import uz.pdp.app_codingbat.payload.cases.req.ReqCreateCase;
import uz.pdp.app_codingbat.payload.cases.req.ReqUpdateCase;
import uz.pdp.app_codingbat.payload.cases.res.ResCase;
import uz.pdp.app_codingbat.service.CaseService;

@RequestMapping(BaseURI.API1 + BaseURI.CASE)
@RestController
@RequiredArgsConstructor
public class CaseController {
    private final CaseService caseService;

    @PostMapping(BaseURI.CREATE)
    public ApiResult<ResCase> createCase(@Valid @RequestBody ReqCreateCase req) {
        return ApiResult.successResponse(caseService.create(req));
    }

    @PutMapping(BaseURI.UPDATE)
    public ApiResult<ResCase> updateCase(@Valid @RequestBody ReqUpdateCase req) {
        return ApiResult.successResponse(caseService.update(req));
    }

    @DeleteMapping(BaseURI.DELETE)
    public ApiResult<ResCase> deleteCase(@RequestParam Long id) {
        return ApiResult.successResponse(caseService.delete(id));
    }
}
