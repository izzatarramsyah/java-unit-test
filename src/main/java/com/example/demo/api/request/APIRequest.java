package com.example.demo.api.request;

import com.example.demo.api.object.HeaderRequest;

public class APIRequest<T> {
    
    private HeaderRequest header;
	private T payload;
	
	public HeaderRequest getHeader() {
		return header;
	}
	public void setHeader(HeaderRequest header) {
		this.header = header;
	}
	public T getPayload() {
		return payload;
	}
	public void setPayload(T payload) {
		this.payload = payload;
	}
	@Override
	public String toString() {
		return "APIRequest [header=" + header + ", payload=" + payload + "]";
	}
    
}
