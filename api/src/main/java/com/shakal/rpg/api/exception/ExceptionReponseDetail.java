package com.shakal.rpg.api.exception;





public class ExceptionReponseDetail {

    private String title;
    private int status;
    private String detail;
    private String developerMessage;
    
    
	public ExceptionReponseDetail(String title, int status, String detail, String developerMessage) {
		super();
		this.title = title;
		this.status = status;
		this.detail = detail;
		this.developerMessage = developerMessage;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public String getDeveloperMessage() {
		return developerMessage;
	}


	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
    
    
    
}