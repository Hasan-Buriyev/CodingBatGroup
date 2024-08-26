package uz.pdp.app_codingbat.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.app_codingbat.config.prop.AuthProp;
import uz.pdp.app_codingbat.entity.Language;
import uz.pdp.app_codingbat.entity.Role;
import uz.pdp.app_codingbat.entity.User;
import uz.pdp.app_codingbat.entity.enums.Permission;
import uz.pdp.app_codingbat.entity.enums.UserStatus;
import uz.pdp.app_codingbat.repository.LanguageRepository;
import uz.pdp.app_codingbat.repository.RoleRepository;
import uz.pdp.app_codingbat.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final AuthProp authProp;
    private final PasswordEncoder passwordEncoder;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Override
    public void run(String... args) throws Exception {

        if (Objects.equals(ddl, "create")) {
            initRoles();
        }

        initLanguage();
        initAdmins();

        System.out.println("Application started.............");
    }

    private void initAdmins() {

        for (AuthProp.AuthUser user : authProp.getUsers()) {

            if (!userRepository.existsByEmail(user.getEmail())) {

                Role role = roleRepository.findByName(user.getRole()).get();
                userRepository.save(
                        User.builder()
                                .email(user.getEmail())
                                .password(passwordEncoder.encode(user.getPassword()))
                                .role(role)
                                .status(UserStatus.ACTIVE)
                                .build());
            }

        }

    }

    private void initLanguage() {
        Language language = Language.builder()
                .name("Java")
                .build();

        if (!languageRepository.existsByName(language.getName())) {
            languageRepository.save(language);
        }
    }

    private void initRoles() {
        Role admin = Role.builder()
                .name("ADMIN")
                .permissions(Set.of(Permission.values()))
                .build();

        Role user = Role.builder()
                .name("USER")
                .permissions(Set.of(Permission.SOLVE_PROBLEM))
                .build();

        roleRepository.saveAll(List.of(admin, user));
    }
}
