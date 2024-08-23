package uz.pdp.app_codingbat.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.app_codingbat.entity.template.AbsLongEntity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table(name = "problem")
public class Problem extends AbsLongEntity {

    private String title;

    private String description;

    @ManyToOne
    private Category category;

    private String question;

    private String method;

    private String solution;
}
