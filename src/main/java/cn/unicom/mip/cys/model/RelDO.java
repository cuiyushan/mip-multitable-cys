package cn.unicom.mip.cys.model;

import java.io.Serializable;

/**
 * ClassName: RelDO
 * Function: RelBean
 * date: 2019年6月27日
 *
 * @author cys
 * @version 1.0
 */

public class RelDO implements Serializable {
    private static final long serialVersionUID = 7554492691059554909L;
    private Integer relId;
    private Integer userId;
    private Integer orgId;
    private String orgType;

    public RelDO() {

    }

    public RelDO(Integer userId, Integer orgId, String orgType) {
        this.userId = userId;
        this.orgId = orgId;
        this.orgType = orgType;
    }

    public RelDO(Integer relId, Integer userId, Integer orgId, String orgType) {
        super();
        this.relId = relId;
        this.userId = userId;
        this.orgId = orgId;
        this.orgType = orgType;
    }

    public Integer getRelId() {
        return relId;
    }

    public void setRelId() {
        this.relId = relId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    @Override
    public String toString() {
        return "RelDO{" + "userId=" + userId +"orgId=" + orgId + ", orgType='" + orgType + '\'' + '}';
    }
}