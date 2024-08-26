package uz.pdp.app_codingbat.payload.language.res;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class ResLanguage {
    private UUID languageId;
    private String languageName;
}
