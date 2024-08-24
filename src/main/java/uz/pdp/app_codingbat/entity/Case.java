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

    @Column(nullable = false)
    private String args;

    @Column(nullable = false)
    private String expected;

    private Boolean visible;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Problem problem;

    public Boolean getVisible() {
        return visible != null && visible;
    }
}
