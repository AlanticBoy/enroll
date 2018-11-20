package com.enroll.POJO;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  12:00 2018/8/18
 * @ModefiedBy:
 */
public class Enrollment {
    private String name;
    private String segment;
    private String entainment;
    private String phone;

    @Override
    public String toString() {
        return "Enrollment{" +
                "name='" + name + '\'' +
                ", segment='" + segment + '\'' +
                ", entainment='" + entainment + '\'' +
                ", phone='" + phone + '\'' +
                ", score=" + score +
                '}';
    }

    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getEntainment() {
        return entainment;
    }

    public void setEntainment(String entainment) {
        this.entainment = entainment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
