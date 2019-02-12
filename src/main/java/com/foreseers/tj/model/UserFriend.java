package com.foreseers.tj.model;

import java.io.Serializable;

/**
 * @author 
 */
public class UserFriend implements Serializable {
    private Integer id;

    private String userId;

    private String friendId;

    /**
     * 0:好友 1：拉黑 2：删除
     */
    private Integer userReation;

    private String firendtime;

    private Integer lookhead;

    private Integer sendpix;

    private Integer lookimages;

    private Integer spareint;

    private String spare;

    private String spare1;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public Integer getUserReation() {
        return userReation;
    }

    public void setUserReation(Integer userReation) {
        this.userReation = userReation;
    }

    public String getFirendtime() {
        return firendtime;
    }

    public void setFirendtime(String firendtime) {
        this.firendtime = firendtime;
    }

    public Integer getLookhead() {
        return lookhead;
    }

    public void setLookhead(Integer lookhead) {
        this.lookhead = lookhead;
    }

    public Integer getSendpix() {
        return sendpix;
    }

    public void setSendpix(Integer sendpix) {
        this.sendpix = sendpix;
    }

    public Integer getLookimages() {
        return lookimages;
    }

    public void setLookimages(Integer lookimages) {
        this.lookimages = lookimages;
    }

    public Integer getSpareint() {
        return spareint;
    }

    public void setSpareint(Integer spareint) {
        this.spareint = spareint;
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
        UserFriend other = (UserFriend) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getFriendId() == null ? other.getFriendId() == null : this.getFriendId().equals(other.getFriendId()))
            && (this.getUserReation() == null ? other.getUserReation() == null : this.getUserReation().equals(other.getUserReation()))
            && (this.getFirendtime() == null ? other.getFirendtime() == null : this.getFirendtime().equals(other.getFirendtime()))
            && (this.getLookhead() == null ? other.getLookhead() == null : this.getLookhead().equals(other.getLookhead()))
            && (this.getSendpix() == null ? other.getSendpix() == null : this.getSendpix().equals(other.getSendpix()))
            && (this.getLookimages() == null ? other.getLookimages() == null : this.getLookimages().equals(other.getLookimages()))
            && (this.getSpareint() == null ? other.getSpareint() == null : this.getSpareint().equals(other.getSpareint()))
            && (this.getSpare() == null ? other.getSpare() == null : this.getSpare().equals(other.getSpare()))
            && (this.getSpare1() == null ? other.getSpare1() == null : this.getSpare1().equals(other.getSpare1()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getFriendId() == null) ? 0 : getFriendId().hashCode());
        result = prime * result + ((getUserReation() == null) ? 0 : getUserReation().hashCode());
        result = prime * result + ((getFirendtime() == null) ? 0 : getFirendtime().hashCode());
        result = prime * result + ((getLookhead() == null) ? 0 : getLookhead().hashCode());
        result = prime * result + ((getSendpix() == null) ? 0 : getSendpix().hashCode());
        result = prime * result + ((getLookimages() == null) ? 0 : getLookimages().hashCode());
        result = prime * result + ((getSpareint() == null) ? 0 : getSpareint().hashCode());
        result = prime * result + ((getSpare() == null) ? 0 : getSpare().hashCode());
        result = prime * result + ((getSpare1() == null) ? 0 : getSpare1().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", friendId=").append(friendId);
        sb.append(", userReation=").append(userReation);
        sb.append(", firendtime=").append(firendtime);
        sb.append(", lookhead=").append(lookhead);
        sb.append(", sendpix=").append(sendpix);
        sb.append(", lookimages=").append(lookimages);
        sb.append(", spareint=").append(spareint);
        sb.append(", spare=").append(spare);
        sb.append(", spare1=").append(spare1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}