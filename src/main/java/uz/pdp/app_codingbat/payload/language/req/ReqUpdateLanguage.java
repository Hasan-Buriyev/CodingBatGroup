package uz.pdp.app_codingbat.payload.language.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ReqUpdateLanguage {
    private UUID languageId;
    private String languageName;
}
