package cherry.cworld.awsproxyrds.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import cherry.cworld.awsproxyrds.service.UserService;
import lombok.extern.slf4j.Slf4j;
import cherry.cworld.awsproxyrds.common.Utils;
import cherry.cworld.awsproxyrds.model.User;;

@Slf4j
@Controller
public class UserController {    
    @Autowired 
    private UserService userService;

    @GetMapping("/")
    public String selectUsers(Model map) {
        HashMap<Object,Object> params = new HashMap<>();
        params.put("limit",10);
        List<User> users = userService.selectUsers(params);
        String result =  Utils.jsonToString(users);
        log.info(result);
        map.addAttribute("result",result);
        return "index";
    }

    @GetMapping("/update1")
    public String updateUserByID(Model map) {
        HashMap<Object,Object> params = new HashMap<>();
        params.put("limit",10);        
        userService.updateUserByID(params);
        List<User> users = userService.selectUsers(params);
        String result =  Utils.jsonToString(users);
        log.info(result);
        map.addAttribute("result",result);
        return "index";        
    }


    @GetMapping("/update2")
    public String updateUserByID2(Model map) {
        HashMap<Object,Object> params = new HashMap<>();
        params.put("limit",10);        
        userService.updateUserByID2(params);
        List<User> users = userService.selectUsers(params);
        String result =  Utils.jsonToString(users);
        log.info(result);
        map.addAttribute("result",result);
        return "index";        
    }    
}
