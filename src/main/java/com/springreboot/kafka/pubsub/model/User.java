package com.springreboot.kafka.pubsub.model;

//Generally you would use Lombok here
public class User {

	private String id;
	private String name;
	private String info;

	public User() {
		this.id = "-1";
		this.name = "";
		this.info = "";
	}
	
	public User(String id, String name, String info) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", info=" + info + "]";
	}

}
