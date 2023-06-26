package egovframework.shop.service;

/**
 * @Class Name : ShopVO.java
 * @Description : Shop VO class
 * @Modification Information
 *
 * @author coc
 * @since 2023
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class ShopVO extends ShopDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    
    /** itemdataname */
    private java.lang.String itemdataname;
    
    /** itemname */
    private java.lang.String itemname;
    
    /** itemdesc */
    private java.lang.String itemdesc;
    
    /** cost */
    private int cost;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public java.lang.String getItemdataname() {
        return this.itemdataname;
    }
    
    public void setItemdataname(java.lang.String itemdataname) {
        this.itemdataname = itemdataname;
    }
    
    public java.lang.String getItemname() {
        return this.itemname;
    }
    
    public void setItemname(java.lang.String itemname) {
        this.itemname = itemname;
    }
    
    public java.lang.String getItemdesc() {
        return this.itemdesc;
    }
    
    public void setItemdesc(java.lang.String itemdesc) {
        this.itemdesc = itemdesc;
    }
    
    public int getCost() {
        return this.cost;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }
    
}
