package com.dongwoo.SQM.system.controller;

import com.dongwoo.SQM.system.dto.LoginDTO;
import com.dongwoo.SQM.system.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm() {
        return "/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, HttpSession session, Model model) {
        boolean isSuccess = false;

        LoginDTO loginResult = loginService.login(loginDTO);
        if (loginResult != null) {
            // login 성공
            session.setAttribute("loginId", loginResult.getUSER_ID());
            session.setAttribute("loginName", loginResult.getUSER_NAME());

            isSuccess = true;
            
            // 권한 가져오기
            model.addAttribute("role", "admin");
            model.addAttribute("isSuccess", isSuccess);

            return "main";
        } else {
            // login 실패
            return "/login";
        }
    }

    @GetMapping("/logout")
    public String logout(@ModelAttribute LoginDTO loginDTO, HttpSession session) {

        // login 세션 삭제
        String sessionId = (String) session.getAttribute("loginId");
        session.removeAttribute(sessionId);

        return "/login";
    }

    @GetMapping("/main")
    public String goMain() {
        return "main";
    }


}