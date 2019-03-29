package com.foreseers.tj.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Lifebook implements Serializable {
    private Integer id;
    
    private Integer userid;

    private String name;

    private String gender;

    private String date;

    private String time;

    private String isleap;

    private String lunaryear;

    private String lunarmonth;

    private String lunarday;

    private String numerology;

    private String numerologymatch;

    private String fiveelements;

    private String horoscope;

    private String horoscopeid;

    private String horoscopename;

    private String horoscopeguardplanets;

    private String horoscopeguardplanetsdesc;

    private String horoscopeguardgod;

    private String horoscopemyth;

    private String horoscopeguardangel;

    private String horoscopeguardcrystal;

    private String horoscopematch;

    private String zodiac;

    private String zodiacid;

    private String zodiacname;

    private String zodiacguardbuddha;

    private String zodiacdesc;

    private String zodiacmatch;

    private String bazi;

    private String bazimatch;

    private String star;

    private String starmatch;

    private String ziwei;

    private String ziweimatch;

    private String created;

    private Date updated;

    private String spare;

    private Integer spareint;

    private static final long serialVersionUID = 1L;

    
    
    /**
	 * @return the userid
	 */
	public Integer getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getIsleap() {
        return isleap;
    }

    public void setIsleap(String isleap) {
        this.isleap = isleap;
    }

    public String getLunaryear() {
        return lunaryear;
    }

    public void setLunaryear(String lunaryear) {
        this.lunaryear = lunaryear;
    }

    public String getLunarmonth() {
        return lunarmonth;
    }

    public void setLunarmonth(String lunarmonth) {
        this.lunarmonth = lunarmonth;
    }

    public String getLunarday() {
        return lunarday;
    }

    public void setLunarday(String lunarday) {
        this.lunarday = lunarday;
    }

    public String getNumerology() {
        return numerology;
    }

    public void setNumerology(String numerology) {
        this.numerology = numerology;
    }

    public String getNumerologymatch() {
        return numerologymatch;
    }

    public void setNumerologymatch(String numerologymatch) {
        this.numerologymatch = numerologymatch;
    }

    public String getFiveelements() {
        return fiveelements;
    }

    public void setFiveelements(String fiveelements) {
        this.fiveelements = fiveelements;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public String getHoroscopeid() {
        return horoscopeid;
    }

    public void setHoroscopeid(String horoscopeid) {
        this.horoscopeid = horoscopeid;
    }

    public String getHoroscopename() {
        return horoscopename;
    }

    public void setHoroscopename(String horoscopename) {
        this.horoscopename = horoscopename;
    }

    public String getHoroscopeguardplanets() {
        return horoscopeguardplanets;
    }

    public void setHoroscopeguardplanets(String horoscopeguardplanets) {
        this.horoscopeguardplanets = horoscopeguardplanets;
    }

    public String getHoroscopeguardplanetsdesc() {
        return horoscopeguardplanetsdesc;
    }

    public void setHoroscopeguardplanetsdesc(String horoscopeguardplanetsdesc) {
        this.horoscopeguardplanetsdesc = horoscopeguardplanetsdesc;
    }

    public String getHoroscopeguardgod() {
        return horoscopeguardgod;
    }

    public void setHoroscopeguardgod(String horoscopeguardgod) {
        this.horoscopeguardgod = horoscopeguardgod;
    }

    public String getHoroscopemyth() {
        return horoscopemyth;
    }

    public void setHoroscopemyth(String horoscopemyth) {
        this.horoscopemyth = horoscopemyth;
    }

    public String getHoroscopeguardangel() {
        return horoscopeguardangel;
    }

    public void setHoroscopeguardangel(String horoscopeguardangel) {
        this.horoscopeguardangel = horoscopeguardangel;
    }

    public String getHoroscopeguardcrystal() {
        return horoscopeguardcrystal;
    }

    public void setHoroscopeguardcrystal(String horoscopeguardcrystal) {
        this.horoscopeguardcrystal = horoscopeguardcrystal;
    }

    public String getHoroscopematch() {
        return horoscopematch;
    }

    public void setHoroscopematch(String horoscopematch) {
        this.horoscopematch = horoscopematch;
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public String getZodiacid() {
        return zodiacid;
    }

    public void setZodiacid(String zodiacid) {
        this.zodiacid = zodiacid;
    }

    public String getZodiacname() {
        return zodiacname;
    }

    public void setZodiacname(String zodiacname) {
        this.zodiacname = zodiacname;
    }

    public String getZodiacguardbuddha() {
        return zodiacguardbuddha;
    }

    public void setZodiacguardbuddha(String zodiacguardbuddha) {
        this.zodiacguardbuddha = zodiacguardbuddha;
    }

    public String getZodiacdesc() {
        return zodiacdesc;
    }

    public void setZodiacdesc(String zodiacdesc) {
        this.zodiacdesc = zodiacdesc;
    }

    public String getZodiacmatch() {
        return zodiacmatch;
    }

    public void setZodiacmatch(String zodiacmatch) {
        this.zodiacmatch = zodiacmatch;
    }

    public String getBazi() {
        return bazi;
    }

    public void setBazi(String bazi) {
        this.bazi = bazi;
    }

    public String getBazimatch() {
        return bazimatch;
    }

    public void setBazimatch(String bazimatch) {
        this.bazimatch = bazimatch;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getStarmatch() {
        return starmatch;
    }

    public void setStarmatch(String starmatch) {
        this.starmatch = starmatch;
    }

    public String getZiwei() {
        return ziwei;
    }

    public void setZiwei(String ziwei) {
        this.ziwei = ziwei;
    }

    public String getZiweimatch() {
        return ziweimatch;
    }

    public void setZiweimatch(String ziweimatch) {
        this.ziweimatch = ziweimatch;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
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
        Lifebook other = (Lifebook) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getIsleap() == null ? other.getIsleap() == null : this.getIsleap().equals(other.getIsleap()))
            && (this.getLunaryear() == null ? other.getLunaryear() == null : this.getLunaryear().equals(other.getLunaryear()))
            && (this.getLunarmonth() == null ? other.getLunarmonth() == null : this.getLunarmonth().equals(other.getLunarmonth()))
            && (this.getLunarday() == null ? other.getLunarday() == null : this.getLunarday().equals(other.getLunarday()))
            && (this.getNumerology() == null ? other.getNumerology() == null : this.getNumerology().equals(other.getNumerology()))
            && (this.getNumerologymatch() == null ? other.getNumerologymatch() == null : this.getNumerologymatch().equals(other.getNumerologymatch()))
            && (this.getFiveelements() == null ? other.getFiveelements() == null : this.getFiveelements().equals(other.getFiveelements()))
            && (this.getHoroscope() == null ? other.getHoroscope() == null : this.getHoroscope().equals(other.getHoroscope()))
            && (this.getHoroscopeid() == null ? other.getHoroscopeid() == null : this.getHoroscopeid().equals(other.getHoroscopeid()))
            && (this.getHoroscopename() == null ? other.getHoroscopename() == null : this.getHoroscopename().equals(other.getHoroscopename()))
            && (this.getHoroscopeguardplanets() == null ? other.getHoroscopeguardplanets() == null : this.getHoroscopeguardplanets().equals(other.getHoroscopeguardplanets()))
            && (this.getHoroscopeguardplanetsdesc() == null ? other.getHoroscopeguardplanetsdesc() == null : this.getHoroscopeguardplanetsdesc().equals(other.getHoroscopeguardplanetsdesc()))
            && (this.getHoroscopeguardgod() == null ? other.getHoroscopeguardgod() == null : this.getHoroscopeguardgod().equals(other.getHoroscopeguardgod()))
            && (this.getHoroscopemyth() == null ? other.getHoroscopemyth() == null : this.getHoroscopemyth().equals(other.getHoroscopemyth()))
            && (this.getHoroscopeguardangel() == null ? other.getHoroscopeguardangel() == null : this.getHoroscopeguardangel().equals(other.getHoroscopeguardangel()))
            && (this.getHoroscopeguardcrystal() == null ? other.getHoroscopeguardcrystal() == null : this.getHoroscopeguardcrystal().equals(other.getHoroscopeguardcrystal()))
            && (this.getHoroscopematch() == null ? other.getHoroscopematch() == null : this.getHoroscopematch().equals(other.getHoroscopematch()))
            && (this.getZodiac() == null ? other.getZodiac() == null : this.getZodiac().equals(other.getZodiac()))
            && (this.getZodiacid() == null ? other.getZodiacid() == null : this.getZodiacid().equals(other.getZodiacid()))
            && (this.getZodiacname() == null ? other.getZodiacname() == null : this.getZodiacname().equals(other.getZodiacname()))
            && (this.getZodiacguardbuddha() == null ? other.getZodiacguardbuddha() == null : this.getZodiacguardbuddha().equals(other.getZodiacguardbuddha()))
            && (this.getZodiacdesc() == null ? other.getZodiacdesc() == null : this.getZodiacdesc().equals(other.getZodiacdesc()))
            && (this.getZodiacmatch() == null ? other.getZodiacmatch() == null : this.getZodiacmatch().equals(other.getZodiacmatch()))
            && (this.getBazi() == null ? other.getBazi() == null : this.getBazi().equals(other.getBazi()))
            && (this.getBazimatch() == null ? other.getBazimatch() == null : this.getBazimatch().equals(other.getBazimatch()))
            && (this.getStar() == null ? other.getStar() == null : this.getStar().equals(other.getStar()))
            && (this.getStarmatch() == null ? other.getStarmatch() == null : this.getStarmatch().equals(other.getStarmatch()))
            && (this.getZiwei() == null ? other.getZiwei() == null : this.getZiwei().equals(other.getZiwei()))
            && (this.getZiweimatch() == null ? other.getZiweimatch() == null : this.getZiweimatch().equals(other.getZiweimatch()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getUpdated() == null ? other.getUpdated() == null : this.getUpdated().equals(other.getUpdated()))
            && (this.getSpare() == null ? other.getSpare() == null : this.getSpare().equals(other.getSpare()))
            && (this.getSpareint() == null ? other.getSpareint() == null : this.getSpareint().equals(other.getSpareint()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getIsleap() == null) ? 0 : getIsleap().hashCode());
        result = prime * result + ((getLunaryear() == null) ? 0 : getLunaryear().hashCode());
        result = prime * result + ((getLunarmonth() == null) ? 0 : getLunarmonth().hashCode());
        result = prime * result + ((getLunarday() == null) ? 0 : getLunarday().hashCode());
        result = prime * result + ((getNumerology() == null) ? 0 : getNumerology().hashCode());
        result = prime * result + ((getNumerologymatch() == null) ? 0 : getNumerologymatch().hashCode());
        result = prime * result + ((getFiveelements() == null) ? 0 : getFiveelements().hashCode());
        result = prime * result + ((getHoroscope() == null) ? 0 : getHoroscope().hashCode());
        result = prime * result + ((getHoroscopeid() == null) ? 0 : getHoroscopeid().hashCode());
        result = prime * result + ((getHoroscopename() == null) ? 0 : getHoroscopename().hashCode());
        result = prime * result + ((getHoroscopeguardplanets() == null) ? 0 : getHoroscopeguardplanets().hashCode());
        result = prime * result + ((getHoroscopeguardplanetsdesc() == null) ? 0 : getHoroscopeguardplanetsdesc().hashCode());
        result = prime * result + ((getHoroscopeguardgod() == null) ? 0 : getHoroscopeguardgod().hashCode());
        result = prime * result + ((getHoroscopemyth() == null) ? 0 : getHoroscopemyth().hashCode());
        result = prime * result + ((getHoroscopeguardangel() == null) ? 0 : getHoroscopeguardangel().hashCode());
        result = prime * result + ((getHoroscopeguardcrystal() == null) ? 0 : getHoroscopeguardcrystal().hashCode());
        result = prime * result + ((getHoroscopematch() == null) ? 0 : getHoroscopematch().hashCode());
        result = prime * result + ((getZodiac() == null) ? 0 : getZodiac().hashCode());
        result = prime * result + ((getZodiacid() == null) ? 0 : getZodiacid().hashCode());
        result = prime * result + ((getZodiacname() == null) ? 0 : getZodiacname().hashCode());
        result = prime * result + ((getZodiacguardbuddha() == null) ? 0 : getZodiacguardbuddha().hashCode());
        result = prime * result + ((getZodiacdesc() == null) ? 0 : getZodiacdesc().hashCode());
        result = prime * result + ((getZodiacmatch() == null) ? 0 : getZodiacmatch().hashCode());
        result = prime * result + ((getBazi() == null) ? 0 : getBazi().hashCode());
        result = prime * result + ((getBazimatch() == null) ? 0 : getBazimatch().hashCode());
        result = prime * result + ((getStar() == null) ? 0 : getStar().hashCode());
        result = prime * result + ((getStarmatch() == null) ? 0 : getStarmatch().hashCode());
        result = prime * result + ((getZiwei() == null) ? 0 : getZiwei().hashCode());
        result = prime * result + ((getZiweimatch() == null) ? 0 : getZiweimatch().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", date=").append(date);
        sb.append(", time=").append(time);
        sb.append(", isleap=").append(isleap);
        sb.append(", lunaryear=").append(lunaryear);
        sb.append(", lunarmonth=").append(lunarmonth);
        sb.append(", lunarday=").append(lunarday);
        sb.append(", numerology=").append(numerology);
        sb.append(", numerologymatch=").append(numerologymatch);
        sb.append(", fiveelements=").append(fiveelements);
        sb.append(", horoscope=").append(horoscope);
        sb.append(", horoscopeid=").append(horoscopeid);
        sb.append(", horoscopename=").append(horoscopename);
        sb.append(", horoscopeguardplanets=").append(horoscopeguardplanets);
        sb.append(", horoscopeguardplanetsdesc=").append(horoscopeguardplanetsdesc);
        sb.append(", horoscopeguardgod=").append(horoscopeguardgod);
        sb.append(", horoscopemyth=").append(horoscopemyth);
        sb.append(", horoscopeguardangel=").append(horoscopeguardangel);
        sb.append(", horoscopeguardcrystal=").append(horoscopeguardcrystal);
        sb.append(", horoscopematch=").append(horoscopematch);
        sb.append(", zodiac=").append(zodiac);
        sb.append(", zodiacid=").append(zodiacid);
        sb.append(", zodiacname=").append(zodiacname);
        sb.append(", zodiacguardbuddha=").append(zodiacguardbuddha);
        sb.append(", zodiacdesc=").append(zodiacdesc);
        sb.append(", zodiacmatch=").append(zodiacmatch);
        sb.append(", bazi=").append(bazi);
        sb.append(", bazimatch=").append(bazimatch);
        sb.append(", star=").append(star);
        sb.append(", starmatch=").append(starmatch);
        sb.append(", ziwei=").append(ziwei);
        sb.append(", ziweimatch=").append(ziweimatch);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", spare=").append(spare);
        sb.append(", spareint=").append(spareint);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}