package com.shakal.rpg.api.validators;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessages {
	private List<String> messages;
	
	public ErrorMessages() {
		this.messages = new ArrayList<String>();
	}
	public boolean hasError() {
		return !this.messages.isEmpty();
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public void addError(String erro) {
		this.messages.add(erro);
	}

}
