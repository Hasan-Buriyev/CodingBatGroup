package uz.pdp.app_codingbat.payload.language.res;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.app_codingbat.payload.category.res.ResCategory;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ResLanguageAndCategory {
    private UUID id;
    private String languageName;
    private List<ResCategory> categories;
}
