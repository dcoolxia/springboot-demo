package name.nvshen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.nvshen.bean.User;
import name.nvshen.dao.UserDao;
import name.nvshen.enums.ResultEnum;
import name.nvshen.exception.BaseException;
import name.nvshen.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Override
    public User getUser(int id) throws Exception {
        User user = userDao.findOne(id);
        int age = user.getAge();
        if (age < 10) {
            throw new BaseException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age <16) {
            throw new BaseException(ResultEnum.MIDDLE_SCHOOL);
        }
        return user;
    }

}
