package cn.unicom.mip.cys.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * ClassName: OrgDO
 * Function: OrgBean
 * date: 2019年6月27日
 *
 * @author cys
 * @version 1.0
 */

public class OrgDO implements Serializable {
    private static final long serialVersionUID = 7554492691059554909L;
    private Integer orgId;
    private String orgName;
    private List<RelDO> relation;

    public OrgDO() {

    }
    public OrgDO(String orgName) {
        this.orgName = orgName;
    }

    public OrgDO(Integer orgId, String orgName) {
        super();
        this.orgId = orgId;
        this.orgName = orgName;
    }
    public OrgDO(Integer orgId, String orgName, List<RelDO> relation) {
        super();
        this.orgId = orgId;
        this.orgName = orgName;
        this.relation = relation;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public List<RelDO> getRelation() {return relation;}

    public void setRelation(List<RelDO> relation) {this.relation = relation;}
    @Override
    public String toString() {
        return "OrgDO{" + "orgId=" + orgId + ", orgName='" + orgName + '\'' + '}';
    }
}