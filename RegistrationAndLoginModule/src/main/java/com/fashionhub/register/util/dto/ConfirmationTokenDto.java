package com.fashionhub.register.util.dto;

public class ConfirmationTokenDto {
	private String id;
	private String confirmationCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	@Override
	public String toString() {
		return "ConfirmationTokenDto [id=" + id + ", confirmationCode=" + confirmationCode + "]";
	}

}
