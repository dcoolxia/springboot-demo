package name.nvshen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TempleController {
    
    /**
     * 返回模版
     * @return
     */
    @RequestMapping(value={"/index", "/"}, method={RequestMethod.GET,RequestMethod.POST})
    public String index() {
        return "index";
    }
}
