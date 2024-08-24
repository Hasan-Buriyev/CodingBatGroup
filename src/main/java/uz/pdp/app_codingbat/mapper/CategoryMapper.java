package uz.pdp.app_codingbat.mapper;

import uz.pdp.app_codingbat.entity.Category;
import uz.pdp.app_codingbat.entity.Language;
import uz.pdp.app_codingbat.payload.category.req.ReqCreateCategory;
import uz.pdp.app_codingbat.payload.category.req.ReqUpdateCategory;
import uz.pdp.app_codingbat.payload.category.res.ResCategory;

import static uz.pdp.app_codingbat.utils.CoreUtils.getIfExists;

public interface CategoryMapper {

    static ResCategory fromEntityToDto(Category category){
        return ResCategory.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .maxStars(category.getMaxStars())
                .languageName(category.getLanguage().getName())
                .createdAt(category.getCreatedAt())
                .updatedAt(category.getUpdatedAt())
                .deleted(category.isDeleted())
                .build();
    }

    static Category fromReqToEntity(ReqCreateCategory req, Language language) {
        return Category.builder()
                .name(req.getName())
                .description(req.getDescription())
                .language(language)
                .maxStars(req.getMaxStars())
                .build();
    }


    static void updateCategoryFromReq(Category category, ReqUpdateCategory req, Language newLanguage) {
        category.setName(getIfExists(req.getName(), category.getName()));
        category.setDescription(getIfExists(req.getDescription(), category.getDescription()));
        category.setMaxStars(getIfExists(req.getMaxStars(), category.getMaxStars()));
        category.setLanguage(getIfExists(newLanguage, category.getLanguage()));
//        category.setLanguageName(newLanguage);
    }

}
