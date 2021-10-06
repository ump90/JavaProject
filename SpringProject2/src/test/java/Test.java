import com.itheima.spring.config.SpringConfig;
import com.itheima.spring.pojo.User;
import com.itheima.spring.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class Test {
    @Autowired
    private UserService userService;
    @org.junit.Test
    public void test(){
        List<User> list=userService.listAllUser();
    }
}
