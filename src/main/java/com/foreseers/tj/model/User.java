package com.foreseers.tj.model;

import java.io.Serializable;
import java.util.Date;

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

    private Double lat;

    private Double lng;

    private String spare;

    private String spare1;

    private Date updatetime;

    /**
     * 个性签名
     */
    private String obligate;

    private Integer numerology;

    private Integer userstar;

    private Integer reservedint;

    private String reservedvar;

    private String reservedvar1;

    /**
     * 五行
     */
    private String cat1;

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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getObligate() {
        return obligate;
    }

    public void setObligate(String obligate) {
        this.obligate = obligate;
    }

    public Integer getNumerology() {
        return numerology;
    }

    public void setNumerology(Integer numerology) {
        this.numerology = numerology;
    }

    public Integer getUserstar() {
        return userstar;
    }

    public void setUserstar(Integer userstar) {
        this.userstar = userstar;
    }

    public Integer getReservedint() {
        return reservedint;
    }

    public void setReservedint(Integer reservedint) {
        this.reservedint = reservedint;
    }

    public String getReservedvar() {
        return reservedvar;
    }

    public void setReservedvar(String reservedvar) {
        this.reservedvar = reservedvar;
    }

    public String getReservedvar1() {
        return reservedvar1;
    }

    public void setReservedvar1(String reservedvar1) {
        this.reservedvar1 = reservedvar1;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
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
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
            && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()))
            && (this.getSpare() == null ? other.getSpare() == null : this.getSpare().equals(other.getSpare()))
            && (this.getSpare1() == null ? other.getSpare1() == null : this.getSpare1().equals(other.getSpare1()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getObligate() == null ? other.getObligate() == null : this.getObligate().equals(other.getObligate()))
            && (this.getNumerology() == null ? other.getNumerology() == null : this.getNumerology().equals(other.getNumerology()))
            && (this.getUserstar() == null ? other.getUserstar() == null : this.getUserstar().equals(other.getUserstar()))
            && (this.getReservedint() == null ? other.getReservedint() == null : this.getReservedint().equals(other.getReservedint()))
            && (this.getReservedvar() == null ? other.getReservedvar() == null : this.getReservedvar().equals(other.getReservedvar()))
            && (this.getReservedvar1() == null ? other.getReservedvar1() == null : this.getReservedvar1().equals(other.getReservedvar1()))
            && (this.getCat1() == null ? other.getCat1() == null : this.getCat1().equals(other.getCat1()));
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
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        result = prime * result + ((getSpare() == null) ? 0 : getSpare().hashCode());
        result = prime * result + ((getSpare1() == null) ? 0 : getSpare1().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getObligate() == null) ? 0 : getObligate().hashCode());
        result = prime * result + ((getNumerology() == null) ? 0 : getNumerology().hashCode());
        result = prime * result + ((getUserstar() == null) ? 0 : getUserstar().hashCode());
        result = prime * result + ((getReservedint() == null) ? 0 : getReservedint().hashCode());
        result = prime * result + ((getReservedvar() == null) ? 0 : getReservedvar().hashCode());
        result = prime * result + ((getReservedvar1() == null) ? 0 : getReservedvar1().hashCode());
        result = prime * result + ((getCat1() == null) ? 0 : getCat1().hashCode());
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
        sb.append(", lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append(", spare=").append(spare);
        sb.append(", spare1=").append(spare1);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", obligate=").append(obligate);
        sb.append(", numerology=").append(numerology);
        sb.append(", userstar=").append(userstar);
        sb.append(", reservedint=").append(reservedint);
        sb.append(", reservedvar=").append(reservedvar);
        sb.append(", reservedvar1=").append(reservedvar1);
        sb.append(", cat1=").append(cat1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}