package com.rzx.ssm.entity;

import java.util.Date;

public class User extends UserKey {
    private String password;

    private Integer isDelete=1;

    private Date createDate=new Date();

    private String cUuid;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }



	public User() {
		super();
	}

	public Date getCreateDate() {
        return createDate;
    }



    public String getcUuid() {
        return cUuid;
    }

    public void setcUuid(String cUuid) {
        this.cUuid = cUuid == null ? null : cUuid.trim();
    }
}