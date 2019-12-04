package cn.unicom.mip.cys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.unicom.mip.cys.base.ReturnInfo;
import cn.unicom.mip.cys.model.OrgDO;
import cn.unicom.mip.cys.service.OrgService;

/**
 * ClassName: OrgControllergr
 * Function: 组织相关操作
 * date: 2019年6月27日
 *
 * @author cys
 * @version 1.0
 */
@RestController
public class OrgController extends BaseController {

    @Autowired
    private OrgService orgService;

    //总数查询
    @RequestMapping(value = "/orgs", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ReturnInfo findAllOrgs() {
        logger.info("开始查询组织列表信息");

        try {
            List<OrgDO> list = orgService.findAllOrgs();
            return new ReturnInfo("1", "查询成功", list, list.size());
        } catch (Exception e) {
            logger.error("[查询组织列表信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //条件查询
    @RequestMapping(value = "/orgs/{orgId}", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ReturnInfo findOrgByorgId(@PathVariable("orgId") int orgId) {logger.info("开始查询单个组织信息-路径");

        try {
            OrgDO org = orgService.findOrgByOrgId(orgId);
            return new ReturnInfo("1", "查询成功", org, 1);
        } catch (Exception e) {
            logger.error("[查询单个组织信息-路径异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //分页查询
    @RequestMapping(value = "/orgs1", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ReturnInfo findAllOrg(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        logger.info("开始查询组织列表信息");

        try {
            List<OrgDO> list = orgService.findAllOrg(pageNum, pageSize);
            return new ReturnInfo("1", "查询成功", list, list.size());
        } catch (Exception e) {
            logger.error("[查询组织列表信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //排序返回
    @RequestMapping(value = "/orgs2", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ReturnInfo findOrgBySortbyOrgName(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam("orderBy") String orderBy) {
        logger.info("开始查询组织列表信息并排序返回");

        try {
            //PageHelper方法 （排序字段 空格 排序方式）
            //PageHelper.startPage(pageNum, pageSize, orderBy);
            List<OrgDO> list = orgService.findAllOrgBySortBy(pageNum, pageSize, orderBy);
            return new ReturnInfo("1", "查询成功", list, list.size());
        } catch (Exception e) {
            logger.error("[查询用户列表信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //插入
    @RequestMapping(value = "/orgs", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ReturnInfo insertOrg(@RequestBody OrgDO orgDO) {logger.info("开始插入组织信息");

        try {
            int ret = orgService.addOrg(orgDO);
            return new ReturnInfo("1", "插入组织成功", ret, 1);
        } catch (Exception e) {
            logger.error("[插入组织信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //更新
    @RequestMapping(value = "/orgs/{orgId}", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.PUT)
    public ReturnInfo updateOrg(@RequestBody OrgDO orgDO) {logger.info("开始修改组织信息");

        try {
            int ret = orgService.updateOrg(orgDO);
            return new ReturnInfo("1", "修改组织成功", orgDO, 1);

        } catch (Exception e) {
            logger.error("[修改组织信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //删除
    @RequestMapping(value = "/orgs/{orgId}", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.DELETE)
    public ReturnInfo deleteOrg(@PathVariable("orgId") int orgId) {logger.info("开始删除组织信息");

        try {
            int ret = orgService.deleteOrgById(orgId);
            return new ReturnInfo("1", "删除组织成功", ret, 1);

        } catch (Exception e) {
            logger.error("[删除组织信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //查询某个用户所属的所有组织，标识出主岗和兼职
    @RequestMapping(value = "/users/{userId}/orgs", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ReturnInfo selectAllOrgssByUserId(@PathVariable("userId") int userId) {logger.info("开始查询某个用户所属的所有组织");

        try {
            List<OrgDO> org = orgService.selectAllOrgssByUserId(userId);
            return new ReturnInfo("1", "查询成功", org, org.size());
        } catch (Exception e) {
            logger.error("[查询某个用户所属的所有组织异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }
}
