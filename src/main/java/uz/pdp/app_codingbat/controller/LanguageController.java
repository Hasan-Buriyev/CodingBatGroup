package uz.pdp.app_codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.app_codingbat.config.core.BaseURI;
import uz.pdp.app_codingbat.payload.base.ApiResult;
import uz.pdp.app_codingbat.payload.language.req.ReqLanguage;
import uz.pdp.app_codingbat.payload.language.req.ReqUpdateLanguage;
import uz.pdp.app_codingbat.payload.language.res.ResLanguage;
import uz.pdp.app_codingbat.payload.language.res.ResLanguageAndCategory;
import uz.pdp.app_codingbat.service.LanguageService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API1 + BaseURI.LANGUAGE)
public class LanguageController {

    private final LanguageService languageService;

    @PostMapping(BaseURI.CREATE)
    public ApiResult<ResLanguage> createLanguage(@RequestBody ReqLanguage req) {
        return ApiResult.successResponse(languageService.create(req));
    }

    @PutMapping(BaseURI.UPDATE)
    public ApiResult<ResLanguage> updateLanguage(@RequestBody ReqUpdateLanguage req) {
    return ApiResult.successResponse(languageService.update(req));
    }

    @DeleteMapping(BaseURI.DELETE)
    public ApiResult<ResLanguage> deleteLanguage(@RequestParam UUID id) {
        return ApiResult.successResponse(languageService.deleteLanguageById(id));
    }

    @GetMapping(BaseURI.GET_ALL)
    public ApiResult<List<ResLanguageAndCategory>> getLanguages() {
        return ApiResult.successResponse(languageService.getLanguages());
    }

    @GetMapping(BaseURI.GET_BY_ID)
    public ApiResult<ResLanguageAndCategory> getLanguageById(@RequestParam UUID id) {
        return ApiResult.successResponse(languageService.getLanguagesById(id));
    }

}
