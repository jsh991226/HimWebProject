package egovframework.user.service;

/**
 * @Class Name : UserVO.java
 * @Description : User VO class
 * @Modification Information
 *
 * @author jsh
 * @since 2023
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class UserVO extends UserDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** index */
    private int index;
    
    /** userid */
    private java.lang.String userid;
    
    /** userpw */
    private java.lang.String userpw;
    
    /** nickname */
    private java.lang.String nickname;
    
    /** email */
    private java.lang.String email;
    
    /** regdate */
    private java.lang.String regdate;
    
    /** type */
    private java.lang.String usertype;
    
    /** userclass */
    private java.lang.String userclass;
    
    /** money */
    private int money;
    
    public int getKilluser() {
		return killuser;
	}

	public void setKilluser(int killuser) {
		this.killuser = killuser;
	}

	public int getKillhuman() {
		return killhuman;
	}

	public void setKillhuman(int killhuman) {
		this.killhuman = killhuman;
	}

	public int getKillboss() {
		return killboss;
	}

	public void setKillboss(int killboss) {
		this.killboss = killboss;
	}

	public int getDeath() {
		return death;
	}

	public void setDeath(int death) {
		this.death = death;
	}

	public int getComexit() {
		return comexit;
	}

	public void setComexit(int comexit) {
		this.comexit = comexit;
	}

	/** money */
    private int killuser;
    
    /** money */
    private int killhuman;
    
    /** money */
    private int killboss;
    
    /** money */
    private int death;
    
    /** money */
    private int comexit;
    
    public int getIndex() {
        return this.index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
    public java.lang.String getUserpw() {
        return this.userpw;
    }
    
    public void setUserpw(java.lang.String userpw) {
        this.userpw = userpw;
    }
    
    public java.lang.String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(java.lang.String nickname) {
        this.nickname = nickname;
    }
    
    public java.lang.String getEmail() {
        return this.email;
    }
    
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    
    public java.lang.String getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(java.lang.String regdate) {
        this.regdate = regdate;
    }
    
    public java.lang.String getUsertype() {
        return this.usertype;
    }
    
    public void setType(java.lang.String usertype) {
        this.usertype = usertype;
    }
    
    public java.lang.String getUserclass() {
        return this.userclass;
    }
    
    public void setUserclass(java.lang.String userclass) {
        this.userclass = userclass;
    }
    
    public int getMoney() {
        return this.money;
    }
    
    public void setMoney(int money) {
        this.money = money;
    }
    
}
