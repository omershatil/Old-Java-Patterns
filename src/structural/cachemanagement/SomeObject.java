package structural.cachemanagement;

public class SomeObject {
	private String id;
	private Object []blob;

	public SomeObject(String id)
	{
		this.id = id;
		this.blob = new Object[1000000];
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public boolean equals(Object o) {
		return this.id.equalsIgnoreCase(((SomeObject)o).getId());
	}
	public String hashCode(Object o) {
		return this.getId();
	}
}
