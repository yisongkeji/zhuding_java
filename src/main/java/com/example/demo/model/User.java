package com.example.demo.model;

import java.io.Serializable;

/**
 * @author 
 */
public class User implements Serializable {
    private Integer id;

    private String username;

    private String sex;

    private String date;

    private String time;

    private Integer zone;

    private String facebook;

    private Integer num;

    private String head;

    private String picture;

    private Integer vip;

    private String viptime;

    private String city;

    private String bazi;

    private String zodiac;

    private String xingzuo;

    private String ziwei;

    private String area;

    private String country;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getZone() {
        return zone;
    }

    public void setZone(Integer zone) {
        this.zone = zone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public String getViptime() {
        return viptime;
    }

    public void setViptime(String viptime) {
        this.viptime = viptime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBazi() {
        return bazi;
    }

    public void setBazi(String bazi) {
        this.bazi = bazi;
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public String getXingzuo() {
        return xingzuo;
    }

    public void setXingzuo(String xingzuo) {
        this.xingzuo = xingzuo;
    }

    public String getZiwei() {
        return ziwei;
    }

    public void setZiwei(String ziwei) {
        this.ziwei = ziwei;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getZone() == null ? other.getZone() == null : this.getZone().equals(other.getZone()))
            && (this.getFacebook() == null ? other.getFacebook() == null : this.getFacebook().equals(other.getFacebook()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getHead() == null ? other.getHead() == null : this.getHead().equals(other.getHead()))
            && (this.getPicture() == null ? other.getPicture() == null : this.getPicture().equals(other.getPicture()))
            && (this.getVip() == null ? other.getVip() == null : this.getVip().equals(other.getVip()))
            && (this.getViptime() == null ? other.getViptime() == null : this.getViptime().equals(other.getViptime()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getBazi() == null ? other.getBazi() == null : this.getBazi().equals(other.getBazi()))
            && (this.getZodiac() == null ? other.getZodiac() == null : this.getZodiac().equals(other.getZodiac()))
            && (this.getXingzuo() == null ? other.getXingzuo() == null : this.getXingzuo().equals(other.getXingzuo()))
            && (this.getZiwei() == null ? other.getZiwei() == null : this.getZiwei().equals(other.getZiwei()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getZone() == null) ? 0 : getZone().hashCode());
        result = prime * result + ((getFacebook() == null) ? 0 : getFacebook().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getHead() == null) ? 0 : getHead().hashCode());
        result = prime * result + ((getPicture() == null) ? 0 : getPicture().hashCode());
        result = prime * result + ((getVip() == null) ? 0 : getVip().hashCode());
        result = prime * result + ((getViptime() == null) ? 0 : getViptime().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getBazi() == null) ? 0 : getBazi().hashCode());
        result = prime * result + ((getZodiac() == null) ? 0 : getZodiac().hashCode());
        result = prime * result + ((getXingzuo() == null) ? 0 : getXingzuo().hashCode());
        result = prime * result + ((getZiwei() == null) ? 0 : getZiwei().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", sex=").append(sex);
        sb.append(", date=").append(date);
        sb.append(", time=").append(time);
        sb.append(", zone=").append(zone);
        sb.append(", facebook=").append(facebook);
        sb.append(", num=").append(num);
        sb.append(", head=").append(head);
        sb.append(", picture=").append(picture);
        sb.append(", vip=").append(vip);
        sb.append(", viptime=").append(viptime);
        sb.append(", city=").append(city);
        sb.append(", bazi=").append(bazi);
        sb.append(", zodiac=").append(zodiac);
        sb.append(", xingzuo=").append(xingzuo);
        sb.append(", ziwei=").append(ziwei);
        sb.append(", area=").append(area);
        sb.append(", country=").append(country);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}