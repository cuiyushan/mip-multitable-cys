package cn.unicom.mip.cys.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.unicom.mip.cys.exception.DBException;
import cn.unicom.mip.cys.mapper.OrgMapper;
import cn.unicom.mip.cys.model.OrgDO;

/**
 * ClassName: OrgService
 * Function: 组织操作
 * date: 2019年6月27日
 *
 * @author cys
 * @version 1.0
 */
@Service(value = "orgService")
public class OrgService {

    private static final Logger logger = LoggerFactory.getLogger(OrgService.class);
    @Autowired
    private OrgMapper orgMapper;

    public int addOrg(OrgDO orgDO) throws Exception {

        try {
            return orgMapper.insertSelective(orgDO);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("新增组织数据库异常");
        }
    }

    public int updateOrg(OrgDO orgDO) throws Exception {

        try {
            return orgMapper.updateByPrimaryKeySelective(orgDO);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("修改组织数据库异常");
        }
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数 pageSize 每页显示的数据条数
     */
    public List<OrgDO> findAllOrg(int pageNum, int pageSize) throws Exception {

        try {
            // 将参数传给这个方法就可以实现物理分页了，非常简单。
            PageHelper.startPage(pageNum, pageSize);
            return orgMapper.selectAllOrg();
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("查询所有组织数据库异常");
        }
    }

    public List<OrgDO> findAllOrgBySortBy(int pageNum, int pageSize, String orderBy) throws Exception {

        try {
            // 将参数传给这个方法就可以实现物理分页了，非常简单。
            PageHelper.startPage(pageNum, pageSize, orderBy);
            return orgMapper.selectAllOrg();
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("查询所有组织数据库异常");
        }
    }

    public List<OrgDO> findAllOrgs() throws Exception {

        try {
            return orgMapper.selectAllOrg();
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("查询所有组织数据库异常");
        }
    }

    public int deleteOrgById(int orgId) throws Exception {

        try {
            return orgMapper.deleteByPrimaryKey(orgId);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("删除数据库异常");
        }
    }

    public OrgDO selectOrgById(int id) throws Exception {

        try {
            return orgMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("查询组织数据库异常");
        }
    }

    public OrgDO findOrgByOrgId(int orgId) throws Exception {

        try {
            System.out.println("from db");
            return orgMapper.selectByPrimaryKey(orgId);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("查询组织数据库异常");
        }
    }

    public List<OrgDO> selectAllOrgssByUserId(int userId) throws Exception {
        try {
            return orgMapper.selectAllOrgssByUserId(userId);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("查询数据库异常");
        }
    }
}
