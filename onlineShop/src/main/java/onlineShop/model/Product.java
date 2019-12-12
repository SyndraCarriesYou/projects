package onlineShop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 5186013952828648626L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "category")
	private String productCategory;

	@Column(name = "description")
	private String productDescription;

	@Column(name = "manufacturer")
	private String productManufacturer;

	@NotEmpty(message = "Product Name is mandatory")
	@Column(name = "name")
	private String productName;

	@NotNull(message = "Please provide some price")
	@Column(name = "price")
	private double productPrice;

	@Column(name = "unit")
	private String unitStock;
	
	@Transient
	private MultipartFile productImage;

	/**
	 * Get the id 
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the id 
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the category of the product 
	 * 
	 * @return
	 */
	public String getProductCategory() {
		return productCategory;
	}

	/**
	 * Set the category of the product 
	 * 
	 * @param productCategory
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * Get the description of the product
	 * 
	 * @return
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * Set the description of the product
	 * 
	 * @param productDescription
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * Get the manufacturer of the product 
	 * 
	 * @return
	 */
	public String getProductManufacturer() {
		return productManufacturer;
	}

	/**
	 * Set the manufacturer of the product 
	 * 
	 * @param productManufacturer
	 */
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}

	/**
	 * Get the name of the product 
	 * 
	 * @return
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Set the name of the product 
	 * 
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Get the price of the product 
	 * 
	 * @return
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * Set the price of the product 
	 * 
	 * @param productPrice
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * Get the unit stock 
	 * 
	 * @return
	 */
	public String getUnitStock() {
		return unitStock;
	}

	/**
	 * Set the unit stock 
	 * 
	 * @param unitStock
	 */
	public void setUnitStock(String unitStock) {
		this.unitStock = unitStock;
	}

	/**
	 * Get the image of the product 
	 * 
	 * @return
	 */
	public MultipartFile getProductImage() {
		return productImage;
	}

	/**
	 * Set the image of the product 
	 * 
	 * @param productImage
	 */
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
}
