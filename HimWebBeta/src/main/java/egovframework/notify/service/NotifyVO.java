package egovframework.notify.service;

/**
 * @Class Name : NotifyVO.java
 * @Description : Notify VO class
 * @Modification Information
 *
 * @author coc
 * @since 20230614
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class NotifyVO extends NotifyDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    
    /** title */
    private java.lang.String title;
    
    /** content */
    private java.lang.String content;
    
    /** owner */
    private java.lang.String owner;
    
    /** regdate */
    private java.lang.String regdate;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public java.lang.String getTitle() {
        return this.title;
    }
    
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
    public java.lang.String getOwner() {
        return this.owner;
    }
    
    public void setOwner(java.lang.String owner) {
        this.owner = owner;
    }
    
    public java.lang.String getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(java.lang.String regdate) {
        this.regdate = regdate;
    }
    
}
