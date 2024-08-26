package uz.pdp.app_codingbat.payload.problem.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.app_codingbat.entity.Category;

@Getter
@Setter
public class ReqProblem {
    @JsonProperty("problem_category")
    @NotBlank
    Long problemCategory;

    private String title;

    @JsonProperty("category_id")
    private Long categoryId;
    private String description;
    private String methodName;
    private String question;
    private String solution;
}
