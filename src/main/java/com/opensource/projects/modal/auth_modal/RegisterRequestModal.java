package com.opensource.projects.modal.auth_modal;

import com.mongodb.lang.NonNull;
import com.opensource.projects.modal.roles.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestModal {
    @NotNull(message = "Email not found")
    String email;
    @NotNull(message = "Password not found")
    String password;
}
