package reservation.dto;

public class Promotion {
	private int id;
	private int product_id;
	private String productImageUrl;
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", product_id=" + product_id + ", productImageUrl=" + productImageUrl + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
}