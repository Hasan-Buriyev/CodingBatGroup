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
@Table(name = "cases")
public class Case extends AbsLongEntity {

    private String args;

    private String expected;

    private Boolean visible;

    @ManyToOne
    private Problem problem;
}
