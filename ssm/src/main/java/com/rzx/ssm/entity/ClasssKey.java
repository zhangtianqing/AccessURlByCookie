package com.rzx.ssm.entity;

public class ClasssKey {
    private String cUuid;

    private String cName;

    public String getcUuid() {
        return cUuid;
    }

    public void setcUuid(String cUuid) {
        this.cUuid = cUuid == null ? null : cUuid.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

	public ClasssKey(String cUuid, String cName) {
		this.cUuid = cUuid;
		this.cName = cName;
	}

	public ClasssKey() {
	}


	public ClasssKey(String cName) {
		this.cName = cName;
	}
    

	@Override
	public String toString() {
		return "ClasssKey [cUuid=" + cUuid + ", cName=" + cName + "]";
	}
}