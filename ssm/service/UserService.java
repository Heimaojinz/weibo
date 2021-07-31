package MVC_weibo.ssm.service;


import MVC_weibo.ssm.mapper.UserMapper;
import MVC_weibo.ssm.model.UserModel;
import MVC_weibo.ssm.model.UserRole;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {
    private UserMapper mapper;
    
    public UserService(UserMapper topicMapper) {
        this.mapper = topicMapper;
    }
    
    public UserModel add(String username, String password) {
        UserModel m = new UserModel();
        m.setUsername(username);
        m.setPassword(password);
        m.setRole(UserRole.normal);
        mapper.insert(m);
        return m;
    }
    
    public void update(Integer id, String username, String password) {
        UserModel m = new UserModel();
        m.setId(id);
        m.setUsername(username);
        m.setPassword(password);
        mapper.update(m);
    }
    
    public void delete(Integer id) {
        mapper.delete(id);
    }

    public  UserModel findById(Integer id) {
        return mapper.selectOne(id);
    }
    public  UserModel findByUsername(String username) {
        return mapper.selectOneByUsername(username);
    }
    
    public boolean validateLogin(String username, String  password) {
        UserModel userModel = mapper.selectOneByUsername(username);
        if (userModel != null && userModel.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    public UserModel guest() {
        UserModel user = new UserModel();
        user.setRole(UserRole.guest);
        user.setId(-1);
        user.setUsername("游客");
        user.setPassword("游客");
        return user;
    }
    
    public UserModel currentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("user_id");
        if (id == null) {
            return this.guest();
        } else {
            UserModel userModel = mapper.selectOne(id);
            if (userModel == null) {
                return this.guest();
            } else {
                return userModel;
            }
        }
    }
    
    public  List<UserModel> all() {
        return mapper.selectAll();
    }
}
