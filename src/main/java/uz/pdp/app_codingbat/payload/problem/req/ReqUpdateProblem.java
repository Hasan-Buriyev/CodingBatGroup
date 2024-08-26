package uz.pdp.app_codingbat.payload.problem.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.app_codingbat.entity.Category;

@Getter
@Setter
public class ReqUpdateProblem {
    @JsonProperty("problem_category")
    private String problemCategory;
    private Long id;
    private String title;
    private String description;
    private Category category;
    private String question;
    private String methodName;
    private String solution;
}
