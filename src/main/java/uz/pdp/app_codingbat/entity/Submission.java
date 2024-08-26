package uz.pdp.app_codingbat.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
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

    private Long problem;

    @Column(nullable = false)
    private String status;

    private String solution;

    private String massage;

    private String methodName;

    private Boolean answer = false;
}
