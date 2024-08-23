package uz.pdp.app_codingbat.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.app_codingbat.entity.template.AbsLongWithAuditEntity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table(name = "category")
public class Category extends AbsLongWithAuditEntity {

    private String name;

    private String description;

    private String max_stars;

    @ManyToOne
    private Language language;
}
