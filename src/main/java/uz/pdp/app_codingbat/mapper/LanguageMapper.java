package uz.pdp.app_codingbat.mapper;

import uz.pdp.app_codingbat.entity.Language;
import uz.pdp.app_codingbat.payload.language.req.ReqLanguage;
import uz.pdp.app_codingbat.payload.language.req.ReqUpdateLanguage;
import uz.pdp.app_codingbat.payload.language.res.ResLanguage;
import uz.pdp.app_codingbat.payload.language.res.ResLanguageAndCategory;

import java.util.ArrayList;
import java.util.List;

import static uz.pdp.app_codingbat.utils.CoreUtils.getIfExists;

public interface LanguageMapper {

    static Language fromEntityToDto(ReqLanguage req) {
        return Language.builder()
                .name(req.getLanguageName())
                .build();
    }
    static ResLanguage fromEntityToDto(Language language) {
        return ResLanguage.builder()
                .languageId(language.getId())
                .languageName(language.getName())
                .build();
    }

    static void updateDtoToEntity(Language language, ReqUpdateLanguage req) {
        language.setName(getIfExists(req.getLanguageName(),language.getName()));
    }

    static List<ResLanguage> fromAllDtoToEntity(List<Language> languages) {
        List<ResLanguage> resLanguages = new ArrayList<>();
        languages.forEach(language -> resLanguages.add(fromEntityToDto(language)));
        return resLanguages;
    }

    static List<Language> fromAllEntityToDto(List<ReqLanguage> reqLanguages ) {
        List<Language> languages = new ArrayList<>();
        reqLanguages.forEach(reqLanguage -> languages.add(fromEntityToDto(reqLanguage)));
        return languages;
    }

    static List<ResLanguageAndCategory> fromAllDtoToLanguages(List<Language> reqLanguages) {
        List<ResLanguageAndCategory> response = new ArrayList<>();
        reqLanguages.forEach(reqLanguage -> {response.add(fromDtoToLanguage(reqLanguage));});
        return response;
    }
    static ResLanguageAndCategory fromDtoToLanguage(Language language) {
        return ResLanguageAndCategory.builder()
                .id(language.getId())
                .languageName(language.getName())
                .categories(CategoryMapper.fromAllEntityToDto(language.getCategories()))
                .build();
    }
}
