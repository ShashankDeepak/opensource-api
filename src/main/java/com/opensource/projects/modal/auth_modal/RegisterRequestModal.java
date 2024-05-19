package com.opensource.projects.modal.auth_modal;

import com.opensource.projects.modal.roles.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestModal {
    String email;
    String password;
    Role role;
}
