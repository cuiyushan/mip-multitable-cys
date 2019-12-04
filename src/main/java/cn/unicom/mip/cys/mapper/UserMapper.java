package cn.unicom.mip.cys.mapper;


import cn.unicom.mip.cys.model.UserDO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: UserMapper
 * Function: 用户相关操作
 * date:2019年6月27日
 *
 * @author cys
 * @version 1.0
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId) throws Exception;

    int insert(UserDO record) throws Exception;

    int insertSelective(UserDO record) throws Exception;

    UserDO selectByPrimaryKey(Integer userId) throws Exception;

    int updateByPrimaryKeySelective(UserDO record) throws Exception;

    int updateByPrimaryKey(UserDO record) throws Exception;

    List<UserDO> selectAllUser() throws Exception;

    List<UserDO> selectAllUsersByOrgId(Integer orgId) throws Exception;
}
