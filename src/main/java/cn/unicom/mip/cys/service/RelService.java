package cn.unicom.mip.cys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.unicom.mip.cys.exception.DBException;
import cn.unicom.mip.cys.model.RelDO;
import cn.unicom.mip.cys.mapper.RelMapper;

/**
 * ClassName: RelService
 * Function: 用户组织关系操作
 * date: 2019年6月27日
 *
 * @author cys
 * @version 1.0
 */
@Service(value = "relService")
public class RelService {

    private static final Logger logger = LoggerFactory.getLogger(OrgService.class);
    @Autowired
    private RelMapper relMapper;

    public int addRel(RelDO relDO) throws Exception {

        try {
            return relMapper.insertSelective(relDO);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("新增用户组织关系数据库异常");
        }
    }

    public int updateRel(RelDO relDO) throws Exception {

        try {
            return relMapper.updateByPrimaryKeySelective(relDO);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("修改用户组织关系数据库异常");
        }
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数 pageSize 每页显示的数据条数
     */

    public int deleteRelById(int relId) throws Exception {

        try {
            return relMapper.deleteByPrimaryKey(relId);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("删除用户组织关系数据库异常");
        }
    }
}

