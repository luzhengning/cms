package com.geek.cms.modules.sys.entity;

import java.util.Date;
import java.util.List;

public class Role {
    private Integer id;

    private String roleName;

    private String roleMark;

    private String permissionId;

    private String createTime;

    private String updateTime;

    private String lastUser;

    private String isEnable;
    
    private List<Permissions> permissions;

    public Role(Integer id) {
    	this.id=id;
    }
    public Role() {
    }
    public Integer getId() {
        return id;
    }

    public List<Permissions> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permissions> permissions) {
		this.permissions = permissions;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleMark() {
        return roleMark;
    }

    public void setRoleMark(String roleMark) {
        this.roleMark = roleMark == null ? null : roleMark.trim();
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser == null ? null : lastUser.trim();
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }
}