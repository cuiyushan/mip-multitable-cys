package cn.unicom.mip.cys.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.unicom.mip.cys.exception.DBException;
import cn.unicom.mip.cys.mapper.UserMapper;
import cn.unicom.mip.cys.model.UserDO;

/**
 * ClassName: UserService
 * Function: 用戶操作
 * date: 2019年6月27日
 *
 * @author cys
 * @version 1.0
 */
@Service(value = "userService")
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;

    public int addUser(UserDO userDO) throws Exception {

        try {
            return userMapper.insertSelective(userDO);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("新增用户数据库异常");
        }
    }

    public int updateUser(UserDO userDO) throws Exception {

        try {
            return userMapper.updateByPrimaryKeySelective(userDO);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("修改用户数据库异常");
        }
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数 pageSize 每页显示的数据条数
     */
    public List<UserDO> findAllUser(int pageNum, int pageSize) throws Exception {

        try {
            // 将参数传给这个方法就可以实现物理分页了，非常简单。
            PageHelper.startPage(pageNum, pageSize);
            return userMapper.selectAllUser();
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("查询所有用户数据库异常");
        }
    }

    public List<UserDO> findAllUserBySortBy(int pageNum, int pageSize, String orderBy) throws Exception {

        try {
            // 将参数传给这个方法就可以实现物理分页了，非常简单。
            PageHelper.startPage(pageNum, pageSize, orderBy);
            return userMapper.selectAllUser();
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("查询所有用户数据库异常");
        }
    }

    public List<UserDO> findAllUsers() throws Exception {

        try {
            return userMapper.selectAllUser();
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("查询所有用户数据库异常");
        }
    }

    public int deleteUserById(int userId) throws Exception {

        try {
            return userMapper.deleteByPrimaryKey(userId);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("删除数据库异常");
        }
    }

    public UserDO findUserByUserId(int userId) throws Exception {

        try {
            System.out.println("from db");
            return userMapper.selectByPrimaryKey(userId);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("查询数据库异常");
        }
    }

    public List<UserDO> selectAllUsersByOrgId(int orgId) throws Exception {
        try {
            return userMapper.selectAllUsersByOrgId(orgId);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DBException("查询数据库异常");
        }
    }
}
