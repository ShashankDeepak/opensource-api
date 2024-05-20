package com.opensource.projects.modal.auth_modal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestModal {
    String email;
    String password;
}
