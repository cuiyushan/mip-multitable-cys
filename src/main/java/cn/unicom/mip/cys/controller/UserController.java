package cn.unicom.mip.cys.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.unicom.mip.cys.base.ReturnInfo;
import cn.unicom.mip.cys.model.UserDO;
import cn.unicom.mip.cys.service.UserService;

/**
 * ClassName: UserController
 * Function: 用户相关操作
 * date: 2019年6月27日
 *
 * @author cys
 * @version 1.0
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    //总数查询
    @RequestMapping(value = "/users", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ReturnInfo findAllUsers() {
        logger.info("开始查询用户列表信息");

        try {
            List<UserDO> list = userService.findAllUsers();
            return new ReturnInfo("1", "查询成功", list, list.size());
        } catch (Exception e) {
            logger.error("[查询用户列表信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //条件查询
    @RequestMapping(value = "/users/{userId}", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ReturnInfo findUserByUserId(@PathVariable("userId") int userId) {logger.info("开始查询单个用户信息-路径");

        try {
            UserDO user = userService.findUserByUserId(userId);
            return new ReturnInfo("1", "查询成功", user, 1);
        } catch (Exception e) {
            logger.error("[查询单个用户信息-路径异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //分页查询
    @RequestMapping(value = "/users1", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ReturnInfo findAllUser(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        logger.info("开始查询用户列表信息");

        try {
            List<UserDO> list = userService.findAllUser(pageNum, pageSize);
            return new ReturnInfo("1", "查询成功", list, list.size());
        } catch (Exception e) {
            logger.error("[查询用户列表信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //排序返回
    @RequestMapping(value = "/users2", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ReturnInfo findUserBySortbyUserName(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam("orderBy") String orderBy) {
        logger.info("开始查询用户列表信息并排序返回");

        try {
            //PageHelper方法 （排序字段 空格 排序方式）
            //PageHelper.startPage(pageNum, pageSize, orderBy);
            List<UserDO> list = userService.findAllUserBySortBy(pageNum, pageSize, orderBy);
            return new ReturnInfo("1", "查询成功", list, list.size());
        } catch (Exception e) {
            logger.error("[查询用户列表信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //插入
    @RequestMapping(value = "/users", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ReturnInfo insertUser(@RequestBody UserDO userDO) {logger.info("开始插入用户信息");

        try {
            int ret = userService.addUser(userDO);
            return new ReturnInfo("1", "插入用户成功", ret, 1);
        } catch (Exception e) {
            logger.error("[插入用户信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //更新
    @RequestMapping(value = "/users/{userId}", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.PUT)
    public ReturnInfo updateUser(@RequestBody UserDO userDO) {logger.info("开始修改用户信息");

        try {
            int ret = userService.updateUser(userDO);
            return new ReturnInfo("1", "修改用户成功", userDO, 1);

        } catch (Exception e) {
            logger.error("[修改用户信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //删除
    @RequestMapping(value = "/users/{userId}", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.DELETE)
    public ReturnInfo deleteUser(@PathVariable("userId") int userId) {logger.info("开始删除用户信息");

        try {
            int ret = userService.deleteUserById(userId);
            return new ReturnInfo("1", "删除用户成功", ret, 1);

        } catch (Exception e) {
            logger.error("[删除用户信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //查询某个组织下的所有用户
    @RequestMapping(value = "/orgs/{orgId}/users", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ReturnInfo selectAllUsersByOrgId(@PathVariable("orgId") int orgId) {
        logger.info("开始查询某组织下的所有用户");

        try {
            List<UserDO> list = userService.selectAllUsersByOrgId(orgId);
            return new ReturnInfo("1", "查询成功", list, list.size());
        } catch (Exception e) {
            logger.error("[查询某组织下的所有用户信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }
}