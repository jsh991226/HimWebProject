package egovframework.itemdata.service;

/**
 * @Class Name : PostitemVO.java
 * @Description : Postitem VO class
 * @Modification Information
 *
 * @author coc
 * @since 2023
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PostitemVO extends PostitemDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    
    /** OwnerID */
    private java.lang.String ownerid;
    
    /** ItemDataName */
    private java.lang.String itemdataname;
    
    /** vaild */
    private java.lang.String vaild;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public java.lang.String getOwnerid() {
        return this.ownerid;
    }
    
    public void setOwnerid(java.lang.String ownerid) {
        this.ownerid = ownerid;
    }
    
    public java.lang.String getItemdataname() {
        return this.itemdataname;
    }
    
    public void setItemdataname(java.lang.String itemdataname) {
        this.itemdataname = itemdataname;
    }
    
    public java.lang.String getVaild() {
        return this.vaild;
    }
    
    public void setVaild(java.lang.String vaild) {
        this.vaild = vaild;
    }
    
}
