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
import cn.unicom.mip.cys.model.RelDO;
import cn.unicom.mip.cys.service.RelService;

/**
 * ClassName: RelControllergr
 * Function: 用户组织关系相关操作
 * date: 2019年6月27日
 *
 * @author cys
 * @version 1.0
 */
@RestController
public class RelController extends BaseController {

    @Autowired
    private RelService relService;

    //插入
    @RequestMapping(value = "/rels", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ReturnInfo insertRel(@RequestBody RelDO relDO) {logger.info("开始插入用户组织关系信息");

        try {
            int ret = relService.addRel(relDO);
            return new ReturnInfo("1", "插入用户组织关系成功", ret, 1);
        } catch (Exception e) {
            logger.error("[插入用户组织关系信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //更新
    @RequestMapping(value = "/rels/{relId}", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.PUT)
    public ReturnInfo updateRel(@RequestBody RelDO relDO) {logger.info("开始修改用户组织关系信息");

        try {
            int ret = relService.updateRel(relDO);
            return new ReturnInfo("1", "修改用户组织关系成功", relDO, 1);

        } catch (Exception e) {
            logger.error("[修改用户组织关系信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }

    //删除
    @RequestMapping(value = "/rels/{relId}", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.DELETE)
    public ReturnInfo deleteRel(@PathVariable("relId") int relId) {logger.info("开始删除用户组织关系信息");

        try {
            int ret = relService.deleteRelById(relId);
            return new ReturnInfo("1", "删除用户组织关系成功", ret, 1);

        } catch (Exception e) {
            logger.error("[删除用户组织关系信息异常]:" + e.getMessage());
            return new ReturnInfo("0", e.getMessage(), null, 0);
        }
    }
}

