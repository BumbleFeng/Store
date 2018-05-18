package servlet;

import java.util.LinkedHashMap;

public class List {
	private LinkedHashMap<String, Item> map;

	public List() {
		map = new LinkedHashMap<String, Item>();
		Item b1 = new Item("1", "book", "Java Servlet Programming", 29.95);
		map.put(b1.getId(), b1);
		Item b2 = new Item("2", "book", "Oracle Database Programming", 48.95);
		map.put(b2.getId(), b2);
		Item b3 = new Item("3", "book", "System Analysis and Design With UML", 14.95);
		map.put(b3.getId(), b3);
		Item b4 = new Item("4", "book", "Object Oriented Software Engineering", 35.99);
		map.put(b4.getId(), b4);
		Item b5 = new Item("5", "book", "Java Web Services", 27.99);
		map.put(b5.getId(), b5);
		Item c1 = new Item("6", "cd", "I'm Going to Tell You a Secret by Madonna", 26.99);
		map.put(c1.getId(), c1);
		Item c2 = new Item("7", "cd", "Baby One More Time by Britney Spears", 10.95);
		map.put(c2.getId(), c2);
		Item c3 = new Item("8", "cd", "Justified by Justin Timberlake", 9.97);
		map.put(c3.getId(), c3);
		Item c4 = new Item("9", "cd", "Loose by Nelly Furtado", 13.98);
		map.put(c4.getId(), c4);
		Item c5 = new Item("10", "cd", "Gold Digger by Kanye West", 27.99);
		map.put(c5.getId(), c5);
		Item l1 = new Item("11", "laptop", "Apple MacBook Pro with 13.3\" Display", 1299.99);
		map.put(l1.getId(), l1);
		Item l2 = new Item("12", "laptop", "Asus Laptop with Centrino 2 Black", 949.95);
		map.put(l2.getId(), l2);
		Item l3 = new Item("13", "laptop", "HP Pavilion Laptop with Centrino 2 DV7", 1199.95);
		map.put(l3.getId(), l3);
		Item l4 = new Item("14", "laptop", "Toshiba Satellite Laptop with Centrino 2 - Copper", 899.99);
		map.put(l4.getId(), l4);
		Item l5 = new Item("15", "laptop", "Solv VAIO Laptop with Core 2 Duo Cosmopolitan Pink ", 779.99);
		map.put(l5.getId(), l5);
	}

	public LinkedHashMap<String, Item> getMap() {
		return map;
	}

}
