package com.opensource.projects.modal.auth_modal;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.NotFound;

@Data
@Builder
public class LoginRequestModal {
    @NotNull(message = "Email not found")
    String email;
    @NotNull(message = "Password not found")
    String password;
}
