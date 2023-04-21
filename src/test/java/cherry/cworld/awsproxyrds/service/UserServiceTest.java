package cherry.cworld.awsproxyrds.service;

import java.util.List;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cherry.cworld.awsproxyrds.model.User;
import cherry.cworld.awsproxyrds.common.Utils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    
    @Test
    public void getUsers() {
        HashMap<Object,Object> params = new HashMap<>();
        params.put("limit", 100);

        List<User> users = userService.selectUsers(params);
        log.info(Utils.jsonToString(users));
    }
}
