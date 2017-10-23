package name.nvshen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import name.nvshen.configure.UserProperties;


@RestController
public class HelloController {
    
    @Autowired
    private UserProperties userProperties;
    @Value("${name}")
    private String name;
    @Value("${content}")
    private String content;
    
    /**
     * 注解注入值
     * @return
     */
    @RequestMapping(value="/say1", method={RequestMethod.GET,RequestMethod.POST})
    public String say1() {
        return "Hello " + name;
    }
    
    /**
     * 配置中引用配置
     * @return
     */
    @RequestMapping(value="/say2", method={RequestMethod.GET,RequestMethod.POST})
    public String say2() {
        return content;
    }
    
    /**
     * 配置中引用对象
     * @return
     */
    @RequestMapping(value="/say3", method={RequestMethod.GET,RequestMethod.POST})
    public String say3() {
        return userProperties.getName()+","+userProperties.getAge();
    }
    
    /**
     * 组合注解指定get/post请求
     * @return
     */
    @GetMapping("/say4")
    @PostMapping("/say4")
    public String say4() {
        return "指定get/post请求";
    }
    
    /**
     * 获取url中的数据
     * @return
     */
    @RequestMapping(value="/say5/{name}", method={RequestMethod.GET,RequestMethod.POST})
    public String say5(@PathVariable("name") String name) {
        return "name:" + name;
    }
    
    /**
     * 获取url中的参数值
     * @return
     */
    @RequestMapping(value="/say6", method={RequestMethod.GET,RequestMethod.POST})
    public String say6(@RequestParam(value="name", required=true, defaultValue="默认") String name) {
        return "name:" + name;
    }
}
