package name.nvshen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import name.nvshen.bean.BaseResult;
import name.nvshen.bean.User;
import name.nvshen.dao.UserDao;
import name.nvshen.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    
    //查询全部
    @GetMapping("/findAll")
    public List<User> findAll() {
        
        return userDao.findAll();
    }
    
    //查询一个
    @RequestMapping(value = "/findOne/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    public User findOne(@PathVariable("id") int id) {
        return userDao.findOne(id);
    }
    
    //通过年龄查询
    @GetMapping("/findByAge/{age}")
    public List<User> findByAge(@PathVariable("age") int age) {
        
        return userDao.findByAge(age);
    }

    //新增(传单个参数)
    @RequestMapping(value = "/add1", method = { RequestMethod.GET, RequestMethod.POST })
    public User add1(@RequestParam("name") String name,
            @RequestParam("age") int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return userDao.save(user);
    }
    
    //新增(传对象)
    @RequestMapping(value = "/add2", method = { RequestMethod.GET, RequestMethod.POST })
    public BaseResult<User> add2(@Valid User user, BindingResult bindingResult) {
        BaseResult<User> result = new BaseResult<>();
        if (bindingResult.hasErrors()) {
            result.setCode(0);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

        result.setCode(1);
        result.setMsg("成功");
        result.setData(userDao.save(user));
        return result;
    }
    
    //更新
    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
    public User update(@RequestParam("name") String name,
            @RequestParam("age") int age,
            @RequestParam("id") int id) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setId(id);
        return userDao.save(user);
    }
    
    //删除
    @RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    public void delete(@PathVariable("id") int id) {
        userDao.delete(id);
    }
    
    //测试异常
    @RequestMapping(value = "/getUser/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    public User getUser(@PathVariable("id") int id) throws Exception {
        return userService.getUser(id);
    }
}
