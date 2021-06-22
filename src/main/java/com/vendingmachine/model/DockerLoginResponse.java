package com.vendingmachine.model;

public class DockerLoginResponse {
	private String Status;

	private String IdentityToken;

	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public String getIdentityToken() {
		return IdentityToken;
	}

	public void setIdentityToken(String IdentityToken) {
		this.IdentityToken = IdentityToken;
	}

	@Override
	public String toString() {
		return "ClassPojo [Status = " + Status + ", IdentityToken = " + IdentityToken + "]";
	}
}