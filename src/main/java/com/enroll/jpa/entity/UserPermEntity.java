package com.enroll.jpa.entity;

import javax.persistence.*;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  9:17 2018/11/20
 * @ModefiedBy:
 */
@Entity
@Table(name = "USER_PERM", schema = "ZHANGSAN", catalog = "")
public class UserPermEntity {
    private long id;
    private Long userid;
    private Long permid;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USERID")
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "PERMID")
    public Long getPermid() {
        return permid;
    }

    public void setPermid(Long permid) {
        this.permid = permid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPermEntity that = (UserPermEntity) o;

        if (id != that.id) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (permid != null ? !permid.equals(that.permid) : that.permid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (permid != null ? permid.hashCode() : 0);
        return result;
    }
}
