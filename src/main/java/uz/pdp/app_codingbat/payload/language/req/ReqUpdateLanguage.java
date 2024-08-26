package uz.pdp.app_codingbat.payload.language.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ReqUpdateLanguage {
    @JsonProperty("language_id")
    private UUID languageId;
    @JsonProperty("language_name")
    private String languageName;
}
