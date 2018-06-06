package com.shopview.server.common.model;

import com.jfinal.plugin.activerecord.Model;

import java.math.BigDecimal;

/**
 * @author duhongg
 * @since 2018-06-06
 */
public class Goods extends Model<Goods> {

    public static final Goods dao = new Goods().dao();

    // 商品唯一标识id
    private String id;
    private String name;
    private String createDate;
    private String createTime;
    private BigDecimal price;
    private Integer discount;
    private String pic;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
