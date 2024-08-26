package uz.pdp.app_codingbat.entity;

import jakarta.persistence.Entity;
import lombok.*;
import uz.pdp.app_codingbat.entity.template.AbsLongEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserToken extends AbsLongEntity {
    private String token;
    private String username;
}
