package com.foreseers.tj.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class UserLookHistory implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer lookid;

    private String looktime;

    private Date lookupdated;

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

    public Integer getLookid() {
        return lookid;
    }

    public void setLookid(Integer lookid) {
        this.lookid = lookid;
    }

    public String getLooktime() {
        return looktime;
    }

    public void setLooktime(String looktime) {
        this.looktime = looktime;
    }

    public Date getLookupdated() {
        return lookupdated;
    }

    public void setLookupdated(Date lookupdated) {
        this.lookupdated = lookupdated;
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
        UserLookHistory other = (UserLookHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getLookid() == null ? other.getLookid() == null : this.getLookid().equals(other.getLookid()))
            && (this.getLooktime() == null ? other.getLooktime() == null : this.getLooktime().equals(other.getLooktime()))
            && (this.getLookupdated() == null ? other.getLookupdated() == null : this.getLookupdated().equals(other.getLookupdated()))
            && (this.getSpare() == null ? other.getSpare() == null : this.getSpare().equals(other.getSpare()))
            && (this.getSpareint() == null ? other.getSpareint() == null : this.getSpareint().equals(other.getSpareint()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getLookid() == null) ? 0 : getLookid().hashCode());
        result = prime * result + ((getLooktime() == null) ? 0 : getLooktime().hashCode());
        result = prime * result + ((getLookupdated() == null) ? 0 : getLookupdated().hashCode());
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
        sb.append(", lookid=").append(lookid);
        sb.append(", looktime=").append(looktime);
        sb.append(", lookupdated=").append(lookupdated);
        sb.append(", spare=").append(spare);
        sb.append(", spareint=").append(spareint);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}