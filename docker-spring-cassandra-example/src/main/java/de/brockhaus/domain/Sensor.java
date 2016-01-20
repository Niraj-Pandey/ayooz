package de.brockhaus.domain;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("sensors")
public class Sensor {
	
	@PrimaryKey 
	private String id; 
	 
	private String name;

	public Sensor(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return "Sensor [id=" + id + ", name=" + name + "]";
	}

}
