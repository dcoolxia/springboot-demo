package name.nvshen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import name.nvshen.bean.User;

public interface UserDao extends JpaRepository<User, Integer> {

    public List<User> findByAge(int age);
}
