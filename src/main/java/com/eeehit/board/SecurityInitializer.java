package com.eeehit.board;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by trinity on 17. 6. 12.
 */

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer() {
        super(SecurityConfig.class, BoardApplication.class);
    }
}

