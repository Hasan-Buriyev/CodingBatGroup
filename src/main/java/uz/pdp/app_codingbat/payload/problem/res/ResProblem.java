package uz.pdp.app_codingbat.payload.problem.res;

import lombok.*;
import uz.pdp.app_codingbat.entity.Category;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResProblem {
    private Long id;
    private String title;
    private String description;
    private Category category;
    private String question;
    private String methodName;
    private String solution;
}
