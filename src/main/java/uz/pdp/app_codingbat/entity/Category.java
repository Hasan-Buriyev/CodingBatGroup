package uz.pdp.app_codingbat.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.app_codingbat.entity.template.AbsLongWithAuditEntity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table(name = "category")
public class Category extends AbsLongWithAuditEntity {

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer maxStars;

    private String min_stars;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Language language;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Problem> problems;
}
