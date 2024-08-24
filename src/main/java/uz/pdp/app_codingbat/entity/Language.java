package uz.pdp.app_codingbat.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.app_codingbat.entity.template.AbsUUIDEntity;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table(name = "language")
public class Language extends AbsUUIDEntity {

    private String name;

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
    private List<Category> categories;
}
