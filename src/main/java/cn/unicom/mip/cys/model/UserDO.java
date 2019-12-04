package cn.unicom.mip.cys.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * ClassName: UserDO
 * Function: UserBean
 * date: 2019年6月27日
 *
 * @author cys
 * @version 1.0
 */

public class UserDO implements Serializable {
    private static final long serialVersionUID = 7554492691059554909L;
    private Integer userId;
    private String userName;
    private List<RelDO> relation;

    public UserDO() {

    }
    public UserDO(String userName) {
        this.userName = userName;
    }

    public UserDO(Integer userId, String userName) {
        super();
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    @Override
    public String toString() {
        return "UserDO{" + "userId=" + userId + ", userName='" + userName + '\'' + '}';
    }
}