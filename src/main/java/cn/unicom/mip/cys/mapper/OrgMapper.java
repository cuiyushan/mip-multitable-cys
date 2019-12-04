package cn.unicom.mip.cys.mapper;

import cn.unicom.mip.cys.model.OrgDO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: OrgMapper
 * Function: 组织相关操作
 * date:2019年6月27日
 *
 * @author cys
 * @version 1.0
 */
@Mapper
public interface OrgMapper {
    int deleteByPrimaryKey(Integer orgId) throws Exception;

    int insert(OrgDO record) throws Exception;

    int insertSelective(OrgDO record) throws Exception;

    OrgDO selectByPrimaryKey(Integer orgId) throws Exception;

    int updateByPrimaryKeySelective(OrgDO record) throws Exception;

    int updateByPrimaryKey(OrgDO record) throws Exception;

    List<OrgDO> selectAllOrg() throws Exception;

    List<OrgDO> selectAllOrgssByUserId(Integer userId) throws Exception;
}
