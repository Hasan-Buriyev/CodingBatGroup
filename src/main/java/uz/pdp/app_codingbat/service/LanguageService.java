package uz.pdp.app_codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.app_codingbat.entity.Language;
import uz.pdp.app_codingbat.enums.ErrorTypeEnum;
import uz.pdp.app_codingbat.exceptions.RestException;
import uz.pdp.app_codingbat.mapper.LanguageMapper;
import uz.pdp.app_codingbat.payload.language.req.ReqLanguage;
import uz.pdp.app_codingbat.payload.language.req.ReqUpdateLanguage;
import uz.pdp.app_codingbat.payload.language.res.ResLanguage;
import uz.pdp.app_codingbat.repository.LanguageRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LanguageService {
    private final LanguageRepository languageRepository;

    public ResLanguage create(ReqLanguage req) {
        Language language = LanguageMapper.fromEntityToDto(req);
        if (checkUnique(req.getLanguageName())) {
            return LanguageMapper.fromDtoToEntity(languageRepository.save(language));
        }
        return LanguageMapper.fromDtoToEntity(language);
    }


    public ResLanguage update(ReqUpdateLanguage req) {
        Language oldLanguage = getLanguageById(req.getLanguageId());
        if (checkLanguageName(oldLanguage,req.getLanguageName())){
            LanguageMapper.updateDtoToEntity(oldLanguage, req);
        }
        return LanguageMapper.fromDtoToEntity(languageRepository.save(oldLanguage));
    }

    public List<ResLanguage> getLanguages() {
        List<Language> languages = languageRepository.findAll();
        return LanguageMapper.fromAllDtoToEntity(languages);
    }

    private boolean checkLanguageName(Language language, String languageNewName) {
        if (language != null && languageRepository.existsByNameAndNotId(languageNewName, language.getId())) {
            return true;
        }
        throw RestException.restThrow(ErrorTypeEnum.LANGUAGE_ALL_READY_EXIST);
    }

    private boolean checkUnique(String name) {
        Optional<Language> language = languageRepository.findByName(name);
        if (language.isPresent()) {
            throw RestException.restThrow(ErrorTypeEnum.LANGUAGE_ALL_READY_EXIST);
        }
        return true;
    }

    private Language getLanguageById(UUID id) {
        return languageRepository.findById(id).orElseThrow(
          RestException.thew(ErrorTypeEnum.LANGUAGE_NOT_FOUND)
        );
    }

    private Language getLanguageByName(String name) {
        return languageRepository.findByName(name).orElseThrow(
                RestException.thew(ErrorTypeEnum.LANGUAGE_NOT_FOUND)
        );
    }
}
