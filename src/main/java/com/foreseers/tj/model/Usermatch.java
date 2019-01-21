package com.foreseers.tj.model;

import java.io.Serializable;

/**
 * @author 
 */
public class Usermatch implements Serializable {
    private Integer id;

    private Integer zhuid;

    private Integer congid;

    private Integer userscore;

    private String userdesc;

    private String commentgood;

    private String commentbad;

    private String characteristicgood;

    private String characteristicbad;

    private Integer mindscore;

    private String minddesc;

    private Integer bodyscore;

    private String bodydesc;

    private Integer characterscore;

    private String characterdesc;

    private Integer distance;

    private String spare;

    private String spare1;

    private String spare2;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getZhuid() {
        return zhuid;
    }

    public void setZhuid(Integer zhuid) {
        this.zhuid = zhuid;
    }

    public Integer getCongid() {
        return congid;
    }

    public void setCongid(Integer congid) {
        this.congid = congid;
    }

    public Integer getUserscore() {
        return userscore;
    }

    public void setUserscore(Integer userscore) {
        this.userscore = userscore;
    }

    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc;
    }

    public String getCommentgood() {
        return commentgood;
    }

    public void setCommentgood(String commentgood) {
        this.commentgood = commentgood;
    }

    public String getCommentbad() {
        return commentbad;
    }

    public void setCommentbad(String commentbad) {
        this.commentbad = commentbad;
    }

    public String getCharacteristicgood() {
        return characteristicgood;
    }

    public void setCharacteristicgood(String characteristicgood) {
        this.characteristicgood = characteristicgood;
    }

    public String getCharacteristicbad() {
        return characteristicbad;
    }

    public void setCharacteristicbad(String characteristicbad) {
        this.characteristicbad = characteristicbad;
    }

    public Integer getMindscore() {
        return mindscore;
    }

    public void setMindscore(Integer mindscore) {
        this.mindscore = mindscore;
    }

    public String getMinddesc() {
        return minddesc;
    }

    public void setMinddesc(String minddesc) {
        this.minddesc = minddesc;
    }

    public Integer getBodyscore() {
        return bodyscore;
    }

    public void setBodyscore(Integer bodyscore) {
        this.bodyscore = bodyscore;
    }

    public String getBodydesc() {
        return bodydesc;
    }

    public void setBodydesc(String bodydesc) {
        this.bodydesc = bodydesc;
    }

    public Integer getCharacterscore() {
        return characterscore;
    }

    public void setCharacterscore(Integer characterscore) {
        this.characterscore = characterscore;
    }

    public String getCharacterdesc() {
        return characterdesc;
    }

    public void setCharacterdesc(String characterdesc) {
        this.characterdesc = characterdesc;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
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

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2;
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
        Usermatch other = (Usermatch) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getZhuid() == null ? other.getZhuid() == null : this.getZhuid().equals(other.getZhuid()))
            && (this.getCongid() == null ? other.getCongid() == null : this.getCongid().equals(other.getCongid()))
            && (this.getUserscore() == null ? other.getUserscore() == null : this.getUserscore().equals(other.getUserscore()))
            && (this.getUserdesc() == null ? other.getUserdesc() == null : this.getUserdesc().equals(other.getUserdesc()))
            && (this.getCommentgood() == null ? other.getCommentgood() == null : this.getCommentgood().equals(other.getCommentgood()))
            && (this.getCommentbad() == null ? other.getCommentbad() == null : this.getCommentbad().equals(other.getCommentbad()))
            && (this.getCharacteristicgood() == null ? other.getCharacteristicgood() == null : this.getCharacteristicgood().equals(other.getCharacteristicgood()))
            && (this.getCharacteristicbad() == null ? other.getCharacteristicbad() == null : this.getCharacteristicbad().equals(other.getCharacteristicbad()))
            && (this.getMindscore() == null ? other.getMindscore() == null : this.getMindscore().equals(other.getMindscore()))
            && (this.getMinddesc() == null ? other.getMinddesc() == null : this.getMinddesc().equals(other.getMinddesc()))
            && (this.getBodyscore() == null ? other.getBodyscore() == null : this.getBodyscore().equals(other.getBodyscore()))
            && (this.getBodydesc() == null ? other.getBodydesc() == null : this.getBodydesc().equals(other.getBodydesc()))
            && (this.getCharacterscore() == null ? other.getCharacterscore() == null : this.getCharacterscore().equals(other.getCharacterscore()))
            && (this.getCharacterdesc() == null ? other.getCharacterdesc() == null : this.getCharacterdesc().equals(other.getCharacterdesc()))
            && (this.getDistance() == null ? other.getDistance() == null : this.getDistance().equals(other.getDistance()))
            && (this.getSpare() == null ? other.getSpare() == null : this.getSpare().equals(other.getSpare()))
            && (this.getSpare1() == null ? other.getSpare1() == null : this.getSpare1().equals(other.getSpare1()))
            && (this.getSpare2() == null ? other.getSpare2() == null : this.getSpare2().equals(other.getSpare2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getZhuid() == null) ? 0 : getZhuid().hashCode());
        result = prime * result + ((getCongid() == null) ? 0 : getCongid().hashCode());
        result = prime * result + ((getUserscore() == null) ? 0 : getUserscore().hashCode());
        result = prime * result + ((getUserdesc() == null) ? 0 : getUserdesc().hashCode());
        result = prime * result + ((getCommentgood() == null) ? 0 : getCommentgood().hashCode());
        result = prime * result + ((getCommentbad() == null) ? 0 : getCommentbad().hashCode());
        result = prime * result + ((getCharacteristicgood() == null) ? 0 : getCharacteristicgood().hashCode());
        result = prime * result + ((getCharacteristicbad() == null) ? 0 : getCharacteristicbad().hashCode());
        result = prime * result + ((getMindscore() == null) ? 0 : getMindscore().hashCode());
        result = prime * result + ((getMinddesc() == null) ? 0 : getMinddesc().hashCode());
        result = prime * result + ((getBodyscore() == null) ? 0 : getBodyscore().hashCode());
        result = prime * result + ((getBodydesc() == null) ? 0 : getBodydesc().hashCode());
        result = prime * result + ((getCharacterscore() == null) ? 0 : getCharacterscore().hashCode());
        result = prime * result + ((getCharacterdesc() == null) ? 0 : getCharacterdesc().hashCode());
        result = prime * result + ((getDistance() == null) ? 0 : getDistance().hashCode());
        result = prime * result + ((getSpare() == null) ? 0 : getSpare().hashCode());
        result = prime * result + ((getSpare1() == null) ? 0 : getSpare1().hashCode());
        result = prime * result + ((getSpare2() == null) ? 0 : getSpare2().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", zhuid=").append(zhuid);
        sb.append(", congid=").append(congid);
        sb.append(", userscore=").append(userscore);
        sb.append(", userdesc=").append(userdesc);
        sb.append(", commentgood=").append(commentgood);
        sb.append(", commentbad=").append(commentbad);
        sb.append(", characteristicgood=").append(characteristicgood);
        sb.append(", characteristicbad=").append(characteristicbad);
        sb.append(", mindscore=").append(mindscore);
        sb.append(", minddesc=").append(minddesc);
        sb.append(", bodyscore=").append(bodyscore);
        sb.append(", bodydesc=").append(bodydesc);
        sb.append(", characterscore=").append(characterscore);
        sb.append(", characterdesc=").append(characterdesc);
        sb.append(", distance=").append(distance);
        sb.append(", spare=").append(spare);
        sb.append(", spare1=").append(spare1);
        sb.append(", spare2=").append(spare2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}