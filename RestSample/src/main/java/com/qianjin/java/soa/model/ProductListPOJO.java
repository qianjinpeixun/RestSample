package com.qianjin.java.soa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_list")
public class ProductListPOJO {

	@Id
	@Column(name="access_code")
	private String accessCode;
	
	@Column(name="name")
	private String name;
	
	public String getAccessCode() {
		return accessCode;
	}
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVisible() {
		return visible;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}
	public int getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(int showOrder) {
		this.showOrder = showOrder;
	}
	public int getServiceType() {
		return serviceType;
	}
	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	@Override
	public String toString() {
		return "ProductListPOJO [accessCode=" + accessCode + ", name=" + name + ", visible=" + visible + ", showOrder="
				+ showOrder + ", serviceType=" + serviceType + ", groupId=" + groupId + "]";
	}
	@Column(name="visible")
	private int visible;
	@Column(name="show_order")
	private int showOrder;
	@Column(name="service_type")
	private int serviceType;
	@Column(name="group_id")
	private String groupId;
	
	
	
	
}
