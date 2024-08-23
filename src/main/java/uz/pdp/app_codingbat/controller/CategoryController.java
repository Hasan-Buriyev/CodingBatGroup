package uz.pdp.app_codingbat.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.app_codingbat.config.core.BaseURI;
import uz.pdp.app_codingbat.entity.Category;
import uz.pdp.app_codingbat.payload.base.ApiResult;
import uz.pdp.app_codingbat.payload.category.req.ReqCreateCategory;
import uz.pdp.app_codingbat.payload.category.res.ResCategory;
import uz.pdp.app_codingbat.service.CategoryService;
import uz.pdp.app_codingbat.payload.base.ApiResult;
import uz.pdp.app_codingbat.payload.category.req.ReqUpdateCategory;
import uz.pdp.app_codingbat.payload.category.res.ResCategory;


@RequestMapping(BaseURI.API1 + BaseURI.CATEGORY)
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(BaseURI.CREATE)
    public ApiResult<ResCategory> createCategory(@Valid @RequestBody ReqCreateCategory req) {
        return ApiResult.successResponse(categoryService.create(req));
    }
    @PutMapping(BaseURI.UPDATE)
    public ApiResult<ResCategory> updateCategory(ReqUpdateCategory req) {
        return null;
    }

}
