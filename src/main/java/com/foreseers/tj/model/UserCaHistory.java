package com.foreseers.tj.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class UserCaHistory implements Serializable {
    private Integer id;

    /**
     * 主用户id
     */
    private Integer userid;

    /**
     * 被擦用户的id
     */
    private Integer caid;

    /**
     * 查看头像的时间
     */
    private String usertime;

    /**
     * 更新时间
     */
    private Date userupdated;

    private String spare;

    private Integer spareint;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public String getUsertime() {
        return usertime;
    }

    public void setUsertime(String usertime) {
        this.usertime = usertime;
    }

    public Date getUserupdated() {
        return userupdated;
    }

    public void setUserupdated(Date userupdated) {
        this.userupdated = userupdated;
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare;
    }

    public Integer getSpareint() {
        return spareint;
    }

    public void setSpareint(Integer spareint) {
        this.spareint = spareint;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserCaHistory other = (UserCaHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getCaid() == null ? other.getCaid() == null : this.getCaid().equals(other.getCaid()))
            && (this.getUsertime() == null ? other.getUsertime() == null : this.getUsertime().equals(other.getUsertime()))
            && (this.getUserupdated() == null ? other.getUserupdated() == null : this.getUserupdated().equals(other.getUserupdated()))
            && (this.getSpare() == null ? other.getSpare() == null : this.getSpare().equals(other.getSpare()))
            && (this.getSpareint() == null ? other.getSpareint() == null : this.getSpareint().equals(other.getSpareint()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getCaid() == null) ? 0 : getCaid().hashCode());
        result = prime * result + ((getUsertime() == null) ? 0 : getUsertime().hashCode());
        result = prime * result + ((getUserupdated() == null) ? 0 : getUserupdated().hashCode());
        result = prime * result + ((getSpare() == null) ? 0 : getSpare().hashCode());
        result = prime * result + ((getSpareint() == null) ? 0 : getSpareint().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", caid=").append(caid);
        sb.append(", usertime=").append(usertime);
        sb.append(", userupdated=").append(userupdated);
        sb.append(", spare=").append(spare);
        sb.append(", spareint=").append(spareint);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}