package cherry.cworld.awsproxyrds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cherry.cworld.awsproxyrds.model.User;
import cherry.cworld.awsproxyrds.repository.UserMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@Service
public class UserService  {
    @Autowired
    private UserMapper mapper;
    
    public List<User> selectUsers(HashMap<Object,Object> vo) {
        return mapper.selectUsers(vo);                
    }

    @Transactional
    public void updateUserByID(HashMap<Object,Object> vo) {
        int updateCount = mapper.updateUserByID(vo);
        log.info("UPDATED COUNT : {}", updateCount);
    }

    @Transactional
    public void updateUserByID2(HashMap<Object,Object> vo) {
        int updateCount = mapper.updateUserByID2(vo);
        log.info("UPDATED COUNT : {}", updateCount);
    }    
}
