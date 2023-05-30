package com.example.demo.constant;

public enum StatusCode {
    
    SUCCESS("00","Success"),
    FAILED("01","Failed"),
	GENERIC_ERROR("99","Sistem mengalami kesalahan. Silahkan hubungi administrator anda");

    private String code;
	private String statusDesc;
	
	private StatusCode(String code, String statusDesc) {
		this.code = code;
		this.statusDesc = statusDesc;
	}
	
	public String getCode() {
		return code;
	}
	void setCode(String code) {
		this.code = code;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}	

}
