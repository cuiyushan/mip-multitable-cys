package cn.unicom.mip.cys.mapper;

import cn.unicom.mip.cys.model.RelDO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: RelMapper
 * Function: 用户组织关系相关操作
 * date:2019年6月27日
 *
 * @author cys
 * @version 1.0
 */
@Mapper
public interface RelMapper {
    int deleteByPrimaryKey(Integer relId) throws Exception;

    int insert(RelDO record) throws Exception;

    int insertSelective(RelDO record) throws Exception;

    int updateByPrimaryKeySelective(RelDO record) throws Exception;

    int updateByPrimaryKey(RelDO record) throws Exception;
}