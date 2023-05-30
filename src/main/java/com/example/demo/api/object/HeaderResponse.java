package com.example.demo.api.object;

public class HeaderResponse {
    
    private String responseCode;
	private String responseMessage;
	
	public HeaderResponse() {}
	
	public HeaderResponse(String responseCode,String responseMessage) {
		this.responseCode=responseCode;
		this.responseMessage=responseMessage;
	}
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	@Override
	public String toString() {
		return "MessageResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage + "]";
	}
    
}
