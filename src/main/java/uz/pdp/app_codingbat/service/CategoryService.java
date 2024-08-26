package uz.pdp.app_codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.app_codingbat.entity.Category;
import uz.pdp.app_codingbat.entity.Language;
import uz.pdp.app_codingbat.enums.ErrorTypeEnum;
import uz.pdp.app_codingbat.exceptions.RestException;
import uz.pdp.app_codingbat.mapper.CategoryMapper;
import uz.pdp.app_codingbat.payload.category.req.ReqCreateCategory;
import uz.pdp.app_codingbat.payload.category.req.ReqUpdateCategory;
import uz.pdp.app_codingbat.payload.category.res.ResCategory;
import uz.pdp.app_codingbat.repository.CategoryRepository;
import uz.pdp.app_codingbat.repository.LanguageRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final LanguageRepository languageRepository;
    private final CategoryRepository categoryRepository;

    public ResCategory create(ReqCreateCategory req) {

        Language language = getLanguage(req.getLanguageId());

        Category category = CategoryMapper.fromReqToEntity(req, language);

        categoryRepository.save(category);

        return CategoryMapper.fromEntityToDto(category);
    }


    public ResCategory update(ReqUpdateCategory req) {
        Category category = getCategory(req.getId());

        CategoryMapper.updateCategoryFromReq(
                category,
                req,
                getLanguageFromUpdateReq(req.getLanguageId(), category.getLanguage()));

        categoryRepository.save(category);

        return CategoryMapper.fromEntityToDto(category);
    }

    public ResCategory delete(Long id) {
        Category category = getCategory(id);
        categoryRepository.delete(category);
        return CategoryMapper.fromEntityToDto(category);
    }

    private Language getLanguageFromUpdateReq(UUID languageId, Language language) {
        if (languageId != null) {
            return getLanguage(languageId);
        }
        return language;
    }

    private Category getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(RestException.thew(ErrorTypeEnum.CATEGORY_NOT_FOUND));
    }

    private Language getLanguage(UUID id) {
        return languageRepository.findById(id)
                .orElseThrow(() -> RestException.restThrow(ErrorTypeEnum.LANGUAGE_NOT_FOUND));
    }


}
