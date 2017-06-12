package com.eeehit.board.session;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

/**
 * Created by trinity on 17. 6. 12.
 */
@ControllerAdvice
public class SessionInitBinder {
    @InitBinder
    public void binder(WebDataBinder binder) {}

    @ModelAttribute("session")
    public String getSessionId(HttpSession httpSession) {
        return (String) httpSession.getAttribute("userId");
    }
}
