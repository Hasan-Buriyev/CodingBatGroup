package uz.pdp.app_codingbat.payload.category.req;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ReqCreateCategory {

    @NotBlank
    private String name;

    private String description;

    @NotNull
    @Min(1)
    @Max(10)
    private Integer maxStars;

    @NotNull
    private UUID languageId;
}
