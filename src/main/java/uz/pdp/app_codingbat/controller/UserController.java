package uz.pdp.app_codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.app_codingbat.config.core.BaseURI;
import uz.pdp.app_codingbat.repository.UserRepository;
import uz.pdp.app_codingbat.service.AuthService;

@RestController
@RequestMapping(BaseURI.API1+BaseURI.USER)
@RequiredArgsConstructor
public class UserController {
    private final AuthService authService;

}
