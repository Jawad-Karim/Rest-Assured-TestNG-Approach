package deserialization_POST;

public class CategoryPOJO {

	private int id;
	private String name;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CategoryPOJO [id=" + this.id + ", name=" + this.name + "]";
	}
}
