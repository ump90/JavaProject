package com.itheima.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Brand {
    @JSONField(name = "id")
    private int id;
    @JSONField(name = "brandName")
    private String brandName;
    @JSONField(name = "companyName")
    private String companyName;
    @JSONField(name = "order")
    private int order;
    @JSONField(name = "brandDescription")
    private String brandDescription;
    @JSONField(name = "status")
    private boolean status;

    public Brand(int id, String brandName, String companyName, int order, String brandDescription, boolean status) {
        this.id = id;
        this.brandName = brandName;
        this.companyName = companyName;
        this.order = order;
        this.brandDescription = brandDescription;
        this.status = status;
    }

    public Brand() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", order=" + order +
                ", brandDescription='" + brandDescription + '\'' +
                ", status=" + status +
                '}';
    }
}
