package com.geek.cms.modules.sys.entity;

import java.util.Date;
import java.util.List;

public class SysMenu {
    private Integer id;

    private String name;

    private Integer parentId;

    private String url;

    private Integer sortNum;

    private Date createTime;

    private Date updateTime;

    private String roleId;

    private String indexSelect;

    private String createBy;

    private String isEnable;
    private List<SysMenu> childMenu;
    private String  SysMenu_id;

    public String getSysMenu_id() {
		return SysMenu_id;
	}

	public void setSysMenu_id(String sysMenu_id) {
		SysMenu_id = sysMenu_id;
	}

	public List<SysMenu> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<SysMenu> childMenu) {
		this.childMenu = childMenu;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getIndexSelect() {
        return indexSelect;
    }

    public void setIndexSelect(String indexSelect) {
        this.indexSelect = indexSelect == null ? null : indexSelect.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }
}