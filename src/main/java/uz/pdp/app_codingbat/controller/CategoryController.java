package uz.pdp.app_codingbat.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.app_codingbat.config.core.BaseURI;
import uz.pdp.app_codingbat.payload.base.ApiResult;
import uz.pdp.app_codingbat.payload.category.req.ReqUpdateCategory;
import uz.pdp.app_codingbat.payload.category.res.ResCategory;


@RequestMapping(BaseURI.API1 + BaseURI.CATEGORY)
@RestController
public class CategoryController {

    @PutMapping(BaseURI.UPDATE)
    public ApiResult<ResCategory> updateCategory(ReqUpdateCategory req) {
        return null;
    }

}
