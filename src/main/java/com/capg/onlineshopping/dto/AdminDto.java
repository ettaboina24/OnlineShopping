package com.capg.onlineshopping.dto;



public class AdminDto {
	private int userId;
	//private String role;
	private String addProductsUrl;
	private String updateProductsUrl;
	private String deleteProductsUrl;
	private String getAllUsersUrl;
	private String getAllOrdersUrl;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
		//this.role="";
		this.addProductsUrl="localhost:9095/api/v1/admin/addProduct";
		this.updateProductsUrl="localhost:9095/api/v1/admin/updateproduct/{id}";
		this.deleteProductsUrl="localhost:9095/api/v1/admin/deleteproduct/{id}/{cid}";
		this.getAllUsersUrl="localhost:9095/api/v1/admin/get-all-user";
		this.getAllOrdersUrl="localhost:9095/api/v1/admin/get-all-orders";
	}
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
	public String getAddProductsUrl() {
		return addProductsUrl;
	}
	public void setAddProductsUrl(String addProductsUrl) {
		this.addProductsUrl = addProductsUrl;
	}
	public String getUpdateProductsUrl() {
		return updateProductsUrl;
	}
	public void setUpdateProductsUrl(String updateProductsUrl) {
		this.updateProductsUrl = updateProductsUrl;
	}
	public String getDeleteProductsUrl() {
		return deleteProductsUrl;
	}
	public void setDeleteProductsUrl(String deleteProductsUrl) {
		this.deleteProductsUrl = deleteProductsUrl;
	}
	
	public String getGetAllUsersUrl() {
		return getAllUsersUrl;
	}
	public void setGetAllUsersUrl(String getAllUsersUrl) {
		this.getAllUsersUrl = getAllUsersUrl;
	}
	public String getGetAllOrdersUrl() {
		return getAllOrdersUrl;
	}
	public void setGetAllOrdersUrl(String getAllOrdersUrl) {
		this.getAllOrdersUrl = getAllOrdersUrl;
	}
	public AdminDto(int userId, String addProductsUrl, String updateProductsUrl, String deleteProductsUrl,
			String getAllUsersUrl, String getAllOrdersUrl) {
		this.userId = userId;
		this.addProductsUrl = addProductsUrl;
		this.updateProductsUrl = updateProductsUrl;
		this.deleteProductsUrl = deleteProductsUrl;
		this.getAllUsersUrl = getAllUsersUrl;
		this.getAllOrdersUrl = getAllOrdersUrl;
	}
	public AdminDto() {
	}
	
	
	
	

}
