package com.enroll.jpa.entity;

import javax.persistence.*;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  9:17 2018/11/20
 * @ModefiedBy:
 */
@Entity
@Table(name = "PERMS", schema = "ZHANGSAN", catalog = "")
public class PermsEntity {
    private long id;
    private String pname;
    private String pdesc;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PNAME")
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Basic
    @Column(name = "PDESC")
    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermsEntity that = (PermsEntity) o;

        if (id != that.id) return false;
        if (pname != null ? !pname.equals(that.pname) : that.pname != null) return false;
        if (pdesc != null ? !pdesc.equals(that.pdesc) : that.pdesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (pname != null ? pname.hashCode() : 0);
        result = 31 * result + (pdesc != null ? pdesc.hashCode() : 0);
        return result;
    }
}
