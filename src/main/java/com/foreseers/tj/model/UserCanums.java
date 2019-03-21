package com.foreseers.tj.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class UserCanums implements Serializable {
    private Integer id;

    private Integer userid;

    /**
     * 每天是否领取过擦子（0，未领取。1，已领取）
     */
    private Integer everyday;

    /**
     * vip是否每天领取（0，未领取。1，已领取）
     */
    private Integer vipeveryday;

    /**
     * 用户的擦子数量
     */
    private Integer nums;

    private Date updated;

    /**
     * 购买的擦字数
     */
    private Integer buynums;

    /**
     * 总共的擦子数
     */
    private Integer countnums;

    private String spare;

    private String spare1;

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

    public Integer getEveryday() {
        return everyday;
    }

    public void setEveryday(Integer everyday) {
        this.everyday = everyday;
    }

    public Integer getVipeveryday() {
        return vipeveryday;
    }

    public void setVipeveryday(Integer vipeveryday) {
        this.vipeveryday = vipeveryday;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getBuynums() {
        return buynums;
    }

    public void setBuynums(Integer buynums) {
        this.buynums = buynums;
    }

    public Integer getCountnums() {
        return countnums;
    }

    public void setCountnums(Integer countnums) {
        this.countnums = countnums;
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare;
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
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
        UserCanums other = (UserCanums) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getEveryday() == null ? other.getEveryday() == null : this.getEveryday().equals(other.getEveryday()))
            && (this.getVipeveryday() == null ? other.getVipeveryday() == null : this.getVipeveryday().equals(other.getVipeveryday()))
            && (this.getNums() == null ? other.getNums() == null : this.getNums().equals(other.getNums()))
            && (this.getUpdated() == null ? other.getUpdated() == null : this.getUpdated().equals(other.getUpdated()))
            && (this.getBuynums() == null ? other.getBuynums() == null : this.getBuynums().equals(other.getBuynums()))
            && (this.getCountnums() == null ? other.getCountnums() == null : this.getCountnums().equals(other.getCountnums()))
            && (this.getSpare() == null ? other.getSpare() == null : this.getSpare().equals(other.getSpare()))
            && (this.getSpare1() == null ? other.getSpare1() == null : this.getSpare1().equals(other.getSpare1()))
            && (this.getSpareint() == null ? other.getSpareint() == null : this.getSpareint().equals(other.getSpareint()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getEveryday() == null) ? 0 : getEveryday().hashCode());
        result = prime * result + ((getVipeveryday() == null) ? 0 : getVipeveryday().hashCode());
        result = prime * result + ((getNums() == null) ? 0 : getNums().hashCode());
        result = prime * result + ((getUpdated() == null) ? 0 : getUpdated().hashCode());
        result = prime * result + ((getBuynums() == null) ? 0 : getBuynums().hashCode());
        result = prime * result + ((getCountnums() == null) ? 0 : getCountnums().hashCode());
        result = prime * result + ((getSpare() == null) ? 0 : getSpare().hashCode());
        result = prime * result + ((getSpare1() == null) ? 0 : getSpare1().hashCode());
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
        sb.append(", everyday=").append(everyday);
        sb.append(", vipeveryday=").append(vipeveryday);
        sb.append(", nums=").append(nums);
        sb.append(", updated=").append(updated);
        sb.append(", buynums=").append(buynums);
        sb.append(", countnums=").append(countnums);
        sb.append(", spare=").append(spare);
        sb.append(", spare1=").append(spare1);
        sb.append(", spareint=").append(spareint);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}