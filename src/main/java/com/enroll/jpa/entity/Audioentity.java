package com.enroll.jpa.entity;

import oracle.sql.TIMESTAMP;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;


/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  13:22 2018/11/19
 * @ModefiedBy:
 */
@Entity
@Table(name = "AUDIO", schema = "ZHANGSAN", catalog = "")
public class Audioentity {
    private long id;
    private String name;
    private String description;
    private Timestamp collectiontime;
    private double price;
    private byte[] resources;

    @Id
    @GenericGenerator(name = "audioIncr", strategy = "increment")
    @GeneratedValue(generator = "audioIncr")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "COLLECTIONTIME")
    public Timestamp getCollectiontime() {
        return collectiontime;
    }

    public void setCollectiontime(Timestamp collectiontime) {
        this.collectiontime = collectiontime;
    }

    @Basic
    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "RESOURCES")
    public byte[] getResources() {
        return resources;
    }

    public void setResources(byte[] resources) {
        this.resources = resources;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Audioentity that = (Audioentity) o;

        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (collectiontime != null ? !collectiontime.equals(that.collectiontime) : that.collectiontime != null)
            return false;
        return Arrays.equals(resources, that.resources);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (collectiontime != null ? collectiontime.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Arrays.hashCode(resources);
        return result;
    }
}
