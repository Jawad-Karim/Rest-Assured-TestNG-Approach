package deserialization_POST;

import java.util.List;

public class Home_Pojo {

	/*{
		  "id": 0,
		  "category": {
		    "id": 0,
		    "name": "string"
		  },
		  "name": "doggie",
		  "photoUrls": [
		    "string"
		  ],
		  "tags": [
		    {
		      "id": 0,
		      "name": "string"
		    }
		  ],
		  "status": "available"
		}*/

	private int id;
	private CategoryPOJO category;
	private String name;
	private List<PhotoUrlPOJO> photoUrls;
	private List <TagsPOJO> tags;
	private String status;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CategoryPOJO getCategory() {
		return category;
	}
	public void setCategory(CategoryPOJO category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PhotoUrlPOJO> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<PhotoUrlPOJO> photoList) {
		this.photoUrls = photoList;
	}
	public List<TagsPOJO> getTags() {
		return tags;
	}
	public void setTags(List<TagsPOJO> tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Home [id=" + this.id + ", category=" + this.category + ", name=" + this.name + ", photoUrls=" + this.photoUrls + ", tags="
				+ this.tags + ", status=" + this.status + "]";
	}
}
