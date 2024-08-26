package uz.pdp.app_codingbat.payload.cases.req;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.app_codingbat.entity.Problem;

@Getter
@Setter
public class ReqCreateCase {

    @NotBlank
    private String args;

    private String expected;

    private Boolean visible;

    @NotNull
    private Long problem;
}
