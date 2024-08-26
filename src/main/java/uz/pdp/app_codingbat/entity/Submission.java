package uz.pdp.app_codingbat.entity;


import jakarta.persistence.*;
import lombok.*;
import uz.pdp.app_codingbat.entity.enums.ProblemStatus;
import uz.pdp.app_codingbat.entity.template.AbsLongEntity;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "submission")
public class Submission extends AbsLongEntity {

    @Column(nullable = false,name = "user_id")
    private UUID user;

    @Column(nullable = false,name = "problem_id")
    private Long problem;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProblemStatus status;

    private String solution;

    private String massage;

    private String methodName;

    private Boolean answer = false;
}
