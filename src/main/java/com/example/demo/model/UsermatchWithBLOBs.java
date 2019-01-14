package com.example.demo.model;

import java.io.Serializable;

/**
 * @author 
 */
public class UsermatchWithBLOBs extends Usermatch implements Serializable {
    private String commentdesc;

    private String characteristicdesc;

    private static final long serialVersionUID = 1L;

    public String getCommentdesc() {
        return commentdesc;
    }

    public void setCommentdesc(String commentdesc) {
        this.commentdesc = commentdesc;
    }

    public String getCharacteristicdesc() {
        return characteristicdesc;
    }

    public void setCharacteristicdesc(String characteristicdesc) {
        this.characteristicdesc = characteristicdesc;
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
        UsermatchWithBLOBs other = (UsermatchWithBLOBs) that;
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
            && (this.getSpare2() == null ? other.getSpare2() == null : this.getSpare2().equals(other.getSpare2()))
            && (this.getCommentdesc() == null ? other.getCommentdesc() == null : this.getCommentdesc().equals(other.getCommentdesc()))
            && (this.getCharacteristicdesc() == null ? other.getCharacteristicdesc() == null : this.getCharacteristicdesc().equals(other.getCharacteristicdesc()));
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
        result = prime * result + ((getCommentdesc() == null) ? 0 : getCommentdesc().hashCode());
        result = prime * result + ((getCharacteristicdesc() == null) ? 0 : getCharacteristicdesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commentdesc=").append(commentdesc);
        sb.append(", characteristicdesc=").append(characteristicdesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}