package uz.pdp.app_codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.app_codingbat.entity.Category;
import uz.pdp.app_codingbat.entity.Language;
import uz.pdp.app_codingbat.enums.ErrorTypeEnum;
import uz.pdp.app_codingbat.exceptions.RestException;
import uz.pdp.app_codingbat.mapper.CategoryMapper;
import uz.pdp.app_codingbat.payload.category.req.ReqCreateCategory;
import uz.pdp.app_codingbat.payload.category.res.ResCategory;
import uz.pdp.app_codingbat.repository.CategoryRepository;
import uz.pdp.app_codingbat.repository.LanguageRepository;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final LanguageRepository languageRepository;
    private final CategoryRepository categoryRepository;

    public ResCategory create(ReqCreateCategory req) {

        Language language = getLanguage(req);

        Category category = CategoryMapper.fromReqToEntity(req, language);

        categoryRepository.save(category);

        return CategoryMapper.fromEntityToDto(category);
    }

    private Language getLanguage(ReqCreateCategory req) {
        return languageRepository.findById(req.getLanguageId())
                .orElseThrow(() -> RestException.restThrow(ErrorTypeEnum.LANGUAGE_NOT_FOUND));
    }
}
