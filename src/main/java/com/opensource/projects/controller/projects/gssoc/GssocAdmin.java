package com.opensource.projects.controller.projects.gssoc;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAnyRole('ADMIN','SUB_ADMIN')")
public class GssocAdmin {
}
