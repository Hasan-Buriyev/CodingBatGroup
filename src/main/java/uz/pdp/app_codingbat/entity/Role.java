package uz.pdp.app_codingbat.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import uz.pdp.app_codingbat.entity.enums.Permission;
import uz.pdp.app_codingbat.entity.template.AbsIntegerEntity;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "auth_role")
public class Role extends AbsIntegerEntity {

    @Column(nullable = false)
    private String name;

    @JdbcTypeCode(SqlTypes.JSON)
    private Set<Permission> permissions;

}
