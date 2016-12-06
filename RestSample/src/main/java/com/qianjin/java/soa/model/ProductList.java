package com.qianjin.java.soa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_list")
public class ProductList {

	@Id
	private String access_code;
	@Override
	public String toString() {
		return "ProductList [access_code=" + access_code + ", name=" + name + ", visible=" + visible + ", show_order="
				+ show_order + ", service_type=" + service_type + ", group_id=" + group_id + "]";
	}
	private String name;
	public String getAccess_code() {
		return access_code;
	}
	public void setAccess_code(String access_code) {
		this.access_code = access_code;
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
	public int getShow_order() {
		return show_order;
	}
	public void setShow_order(int show_order) {
		this.show_order = show_order;
	}
	
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	private int visible;
	private int show_order;
	private int service_type;
	public int getService_type() {
		return service_type;
	}
	public void setService_type(int service_type) {
		this.service_type = service_type;
	}
	private String group_id;
	
	
}
