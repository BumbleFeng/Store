package servlet;

public class Item {
	private String id;
	private String type;
	private String name;
	private double price;
	private boolean added;

	public Item(String id, String type, String name, double price) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.price = price;
		this.added = false;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public boolean isAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}
}
