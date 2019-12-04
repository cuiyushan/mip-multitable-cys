package cn.unicom.mip.cys.base;

import java.io.Serializable;
/**
 *
 * ClassName: ReturnInfo
 * Function: 返回信息
 * date: 2019年6月25日
 *
 * @author cys
 * @version 1.0
 */
public class ReturnInfo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3209005825837160542L;

    // 表示服务返回代码：0表示存在错误，1表示返回正确。该值必须在服务返回json中
    private String retCode;

    // 表示服务返回信息：当RetCode为0时，返回是错误信息。当RetCode返回1时，返回为自定义信息。该值必须在服务返回json中
    private String retValue;

    // 当服务返回多行数据时，可将数据封装为json数组，数组的key为DataRows。如果存在一种多值数据，推荐采用json数组模式，key使用DataRows
    private Object dataRows;

    // 返回dataRows的元素个数，如果dataRows为null或者空数组，值为0
    private Integer rowCount;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetValue() {
        return retValue;
    }

    public void setRetValue(String retValue) {
        this.retValue = retValue;
    }

    public Object getDataRows() {
        return dataRows;
    }

    public void setDataRows(Object dataRows) {
        this.dataRows = dataRows;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public ReturnInfo(String retCode, String retValue, Object dataRows, Integer rowCount) {
        this.retCode = retCode;
        this.retValue = retValue;
        this.dataRows = dataRows;
        this.rowCount = rowCount;
    }

    @Override
    public String toString() {
        return "ReturnInfo [dataRows=" + dataRows + ", retCode=" + retCode + ", retValue=" + retValue + ", rowCount="
                + rowCount + "]";
    }

}
