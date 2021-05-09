package example.hellosecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin")
public class LoginController {

    @RequestMapping("demo")
    public String demo(){
        return "hello security";
    }


}
