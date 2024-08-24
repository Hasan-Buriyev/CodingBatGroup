package uz.pdp.app_codingbat.mapper;

import uz.pdp.app_codingbat.entity.Language;
import uz.pdp.app_codingbat.payload.language.req.ReqLanguage;
import uz.pdp.app_codingbat.payload.language.req.ReqUpdateLanguage;
import uz.pdp.app_codingbat.payload.language.res.ResLanguage;

import java.util.ArrayList;
import java.util.List;

import static uz.pdp.app_codingbat.utils.CoreUtils.getIfExists;

public interface LanguageMapper {

    static Language fromEntityToDto(ReqLanguage req) {
        return Language.builder()
                .name(req.getLanguageName())
                .build();
    }
    static ResLanguage fromDtoToEntity(Language language) {
        return ResLanguage.builder()
                .languageId(language.getId())
                .languageName(language.getName())
                .build();
    }

    static void updateDtoToEntity(Language language, ReqUpdateLanguage req) {
        language.setName(getIfExists(language.getName(),req.getLanguageName()));
    }

    static List<ResLanguage> fromAllDtoToEntity(List<Language> languages) {
        List<ResLanguage> resLanguages = new ArrayList<>();
        languages.forEach(language -> resLanguages.add(fromDtoToEntity(language)));
        return resLanguages;
    }
}
