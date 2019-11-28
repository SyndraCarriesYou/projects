package entity;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Create Item Object using builder pattern 
 * 
 * @author Wenwen Zheng
 *
 */
public class Item {
	private String itemId;
	private String name;
	private double rating;
	private String address;
	private Set<String> categories;
	private String imageUrl;
	private String url;
	private double distance;
	
	private Item(ItemBuilder builder) {
		this.itemId = builder.itemId;
		this.name = builder.name;
		this.rating = builder.rating;
		this.address = builder.address;
		this.categories = builder.categories;
		this.imageUrl = builder.imageUrl;
		this.url = builder.url;
		this.distance = builder.distance;
	}

	/**
	 * Get item ID 
	 * @return item ID 
	 */
	public String getItemId() {
		return itemId;
	}
	
	/**
	 * Get item name 
	 * @return item name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the rating of item
	 * @return the rating of item
	 */
	public double getRating() {
		return rating;
	}
	
	/**
	 * Get the address of item 
	 * @return the address of item
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Get the categories of item
	 * @return the categories of item
	 */
	public Set<String> getCategories() {
		return categories;
	}
	
	/**
	 * Get the image URL of item
	 * @return the image URL of item
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	
	/**
	 * Get the URL of item
	 * @return the URL of item
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Get the distance of item 
	 * @return the distance of item 
	 */
	public double getDistance() {
		return distance;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		return result;
	}

	@Override
	/**
	 * If two items have the same item ID, then return true 
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		return true;
	}

	
	/**
	 * To convert an Item object a JSONObject instance.
	 * Because in our application, frontend code cannot understand Java class, 
	 * it can only understand JSON.
	 * 
	 * @return the corresponding JSON object 
	 */
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("item_id", itemId);
			obj.put("name", name);
			obj.put("rating", rating);
			obj.put("address", address);
			obj.put("categories", new JSONArray(categories));
			obj.put("image_url", imageUrl);
			obj.put("url", url);
			obj.put("distance", distance);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	/**
	 * The Builder for Item object 
	 */
	public static class ItemBuilder {
		private String itemId;
		private String name;
		private double rating;
		private String address;
		private Set<String> categories;
		private String imageUrl;
		private String url;
		private double distance;
		
		/**
		 * Set item ID 
		 * @param itemId
		 */
		public void setItemId(String itemId) {
			this.itemId = itemId;
		}
		
		/**
		 * Set item name 
		 * @param name
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * Set the rating of item 
		 * @param rating
		 */
		public void setRating(double rating) {
			this.rating = rating;
		}

		/**
		 * Set the address of item
		 * @param address
		 */
		public void setAddress(String address) {
			this.address = address;
		}

		/**
		 * Set the categories of item 
		 * @param categories
		 */
		public void setCategories(Set<String> categories) {
			this.categories = categories;
		}

		/**
		 * Set the image URL of item 
		 * @param imageUrl
		 */
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		/**
		 * Set the URL of item 
		 * @param url
		 */
		public void setUrl(String url) {
			this.url = url;
		}

		/**
		 * Set the distance of item 
		 * @param distance
		 */
		public void setDistance(double distance) {
			this.distance = distance;
		}
		
		/**
		 * Create the corresponding item 
		 * @return the corresponding item 
		 */
		public Item build() {
			return new Item(this);
		}

	}


}
