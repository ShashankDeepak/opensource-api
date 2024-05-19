package com.opensource.projects.modal.auth_modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiLogEntryModal {
    HttpMethod httpMethod;
    Date date;
    String endpoint;
}
