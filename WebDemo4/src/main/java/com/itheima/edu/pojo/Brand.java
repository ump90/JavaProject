package com.itheima.edu.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Brand {
    // id 主键
    @JSONField(name="id")
    private Integer id;
    // 品牌名称
    @JSONField(name="brandName")
    private String brandName;
    // 企业名称
    @JSONField(name="companyName")
    private String companyName;
    // 排序字段
    @JSONField(name="ordered")
    private Integer ordered;
    // 描述信息
    @JSONField(name="description")
    private String description;
    // 状态：0：禁用  1：启用
    @JSONField(name="status")
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }
    //逻辑视图
    public String getStatusStr(){
        if (status == null){
            return "未知";
        }
        return status == 0 ? "禁用":"启用";
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
