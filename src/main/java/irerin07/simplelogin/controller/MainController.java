package irerin07.simplelogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String mainPage(){
        return "index";
    }

    @GetMapping("/userlogin")
    public String loginPage(){
        return "userlogin";
    }

}