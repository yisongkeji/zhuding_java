package com.foreseers.tj.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class UserImage implements Serializable {
    private Integer id;

    private Integer userid;

    private String image;

    private Date updated;

    private String facebookid;

    private String imagename;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getFacebookid() {
        return facebookid;
    }

    public void setFacebookid(String facebookid) {
        this.facebookid = facebookid;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
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
        UserImage other = (UserImage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getUpdated() == null ? other.getUpdated() == null : this.getUpdated().equals(other.getUpdated()))
            && (this.getFacebookid() == null ? other.getFacebookid() == null : this.getFacebookid().equals(other.getFacebookid()))
            && (this.getImagename() == null ? other.getImagename() == null : this.getImagename().equals(other.getImagename()))
            && (this.getSpare() == null ? other.getSpare() == null : this.getSpare().equals(other.getSpare()))
            && (this.getSpareint() == null ? other.getSpareint() == null : this.getSpareint().equals(other.getSpareint()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getUpdated() == null) ? 0 : getUpdated().hashCode());
        result = prime * result + ((getFacebookid() == null) ? 0 : getFacebookid().hashCode());
        result = prime * result + ((getImagename() == null) ? 0 : getImagename().hashCode());
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
        sb.append(", image=").append(image);
        sb.append(", updated=").append(updated);
        sb.append(", facebookid=").append(facebookid);
        sb.append(", imagename=").append(imagename);
        sb.append(", spare=").append(spare);
        sb.append(", spareint=").append(spareint);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}