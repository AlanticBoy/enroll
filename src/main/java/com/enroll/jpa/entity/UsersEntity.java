package com.enroll.jpa.entity;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  9:17 2018/11/20
 * @ModefiedBy:
 */
@Entity
@Table(name = "USERS", schema = "ZHANGSAN", catalog = "")
public class UsersEntity {
    private long id;
    private String uname;
    private String gender;
    private Timestamp registertime;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UNAME")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Basic
    @Column(name = "GENDER")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "REGISTERTIME")
    public Timestamp getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Timestamp registertime) {
        this.registertime = registertime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (uname != null ? !uname.equals(that.uname) : that.uname != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (registertime != null ? !registertime.equals(that.registertime) : that.registertime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (uname != null ? uname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (registertime != null ? registertime.hashCode() : 0);
        return result;
    }
}
