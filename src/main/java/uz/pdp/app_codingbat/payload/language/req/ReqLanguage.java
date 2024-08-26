package uz.pdp.app_codingbat.payload.language.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqLanguage {
    @JsonProperty("language_name")
    @NotBlank
    String languageName;
}
