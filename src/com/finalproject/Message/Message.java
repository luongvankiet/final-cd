package com.finalproject.Message;

public class Message<T> {
	private String message;
	private T data;
	
	public Message(String message, T data){
		this.setMessage(message);
		this.setData(data);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
