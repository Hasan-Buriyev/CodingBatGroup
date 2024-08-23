package uz.pdp.app_codingbat.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.app_codingbat.entity.enums.UserStatus;
import uz.pdp.app_codingbat.entity.template.AbsUUIDEntity;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auth_user")
@Entity
@ToString
public class User extends AbsUUIDEntity {

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne(optional = false)
    private Role role;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserStatus status = UserStatus.INACTIVE;

    @Column(name = "attachment_id")
    private UUID attachmentId;

    public boolean isActive() {
        return this.status == UserStatus.ACTIVE;
    }
}
