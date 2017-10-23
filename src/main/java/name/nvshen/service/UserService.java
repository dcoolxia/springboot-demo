package name.nvshen.service;

import name.nvshen.bean.User;

public interface UserService {

    public User getUser(int id) throws Exception;
    
    public User findOne(int id);
}
