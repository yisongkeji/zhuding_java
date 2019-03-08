package com.foreseers.tj.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class UserDefriend implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer blackid;

    private String defriendtime;

    private Date updated;

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

    public Integer getBlackid() {
        return blackid;
    }

    public void setBlackid(Integer blackid) {
        this.blackid = blackid;
    }

    public String getDefriendtime() {
        return defriendtime;
    }

    public void setDefriendtime(String defriendtime) {
        this.defriendtime = defriendtime;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
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
        UserDefriend other = (UserDefriend) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getBlackid() == null ? other.getBlackid() == null : this.getBlackid().equals(other.getBlackid()))
            && (this.getDefriendtime() == null ? other.getDefriendtime() == null : this.getDefriendtime().equals(other.getDefriendtime()))
            && (this.getUpdated() == null ? other.getUpdated() == null : this.getUpdated().equals(other.getUpdated()))
            && (this.getSpare() == null ? other.getSpare() == null : this.getSpare().equals(other.getSpare()))
            && (this.getSpareint() == null ? other.getSpareint() == null : this.getSpareint().equals(other.getSpareint()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getBlackid() == null) ? 0 : getBlackid().hashCode());
        result = prime * result + ((getDefriendtime() == null) ? 0 : getDefriendtime().hashCode());
        result = prime * result + ((getUpdated() == null) ? 0 : getUpdated().hashCode());
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
        sb.append(", blackid=").append(blackid);
        sb.append(", defriendtime=").append(defriendtime);
        sb.append(", updated=").append(updated);
        sb.append(", spare=").append(spare);
        sb.append(", spareint=").append(spareint);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}