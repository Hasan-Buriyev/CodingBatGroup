package uz.pdp.app_codingbat.payload.language.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqLanguage {
    @NotBlank
    String languageName;
}
