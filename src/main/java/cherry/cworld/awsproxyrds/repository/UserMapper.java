package cherry.cworld.awsproxyrds.repository;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import cherry.cworld.awsproxyrds.model.User;

@Mapper
public interface UserMapper {
    /*
     * 사용자 목록
     */    
     List<User> selectUsers(HashMap<Object,Object> vo);
     /**
      * 사용자 업데이트
      */
      int updateUserByID(HashMap<Object,Object> vo);
      int updateUserByID2(HashMap<Object,Object> vo);
}
