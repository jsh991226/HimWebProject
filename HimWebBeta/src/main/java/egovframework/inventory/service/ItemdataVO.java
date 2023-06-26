package egovframework.inventory.service;

/**
 * @Class Name : ItemdataVO.java
 * @Description : Itemdata VO class
 * @Modification Information
 *
 * @author coc
 * @since 20230614
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class ItemdataVO extends ItemdataDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    
    /** sprite */
    private java.lang.String sprite;
    
    /** positionx */
    private int positionx;
    
    /** positiony */
    private int positiony;
    
    /** width */
    private int width;
    
    /** height */
    private int height;
    
    /** ispartofshape */
    private java.lang.String ispartofshape;
    
    /** candrop */
    private java.lang.String candrop;
    
    /** durability */
    private java.lang.String durability;
    
    /** area */
    private java.lang.String area;
    
    /** code */
    private java.lang.String code;
    
    /** itemprefabname */
    private java.lang.String itemprefabname;
    
    /** ownerId */
    private java.lang.String ownerid;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public java.lang.String getSprite() {
        return this.sprite;
    }
    
    public void setSprite(java.lang.String sprite) {
        this.sprite = sprite;
    }
    
    public int getPositionx() {
        return this.positionx;
    }
    
    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }
    
    public int getPositiony() {
        return this.positiony;
    }
    
    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public java.lang.String getIspartofshape() {
        return this.ispartofshape;
    }
    
    public void setIspartofshape(java.lang.String ispartofshape) {
        this.ispartofshape = ispartofshape;
    }
    
    public java.lang.String getCandrop() {
        return this.candrop;
    }
    
    public void setCandrop(java.lang.String candrop) {
        this.candrop = candrop;
    }
    
    public java.lang.String getDurability() {
        return this.durability;
    }
    
    public void setDurability(java.lang.String durability) {
        this.durability = durability;
    }
    
    public java.lang.String getArea() {
        return this.area;
    }
    
    public void setArea(java.lang.String area) {
        this.area = area;
    }
    
    public java.lang.String getCode() {
        return this.code;
    }
    
    public void setCode(java.lang.String code) {
        this.code = code;
    }
    
    public java.lang.String getItemprefabname() {
        return this.itemprefabname;
    }
    
    public void setItemprefabname(java.lang.String itemprefabname) {
        this.itemprefabname = itemprefabname;
    }
    
    public java.lang.String getOwnerid() {
        return this.ownerid;
    }
    
    public void setOwnerid(java.lang.String ownerid) {
        this.ownerid = ownerid;
    }
    
}
