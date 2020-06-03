package com.webapp.springbootrestapiwebclient.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentResponse {

	@JsonProperty("documentId")
	private int documentId;

	@JsonProperty("documentName")
	private String documentName;

	@JsonProperty("documentExpiryDate")
	private Date documentExpiryDate;

	@JsonProperty("documentAddress")
	private String documentAddress;

	public DocumentResponse() {
		super();
	}

	public DocumentResponse(int documentId, String documentName, Date documentExpiryDate, String documentAddress) {
		super();
		this.documentId = documentId;
		this.documentName = documentName;
		this.documentExpiryDate = documentExpiryDate;
		this.documentAddress = documentAddress;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public Date getDocumentExpiryDate() {
		return documentExpiryDate;
	}

	public void setDocumentExpiryDate(Date documentExpiryDate) {
		this.documentExpiryDate = documentExpiryDate;
	}

	public String getDocumentAddress() {
		return documentAddress;
	}

	public void setDocumentAddress(String documentAddress) {
		this.documentAddress = documentAddress;
	}

	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", documentName=" + documentName + ", documentExpiryDate="
				+ documentExpiryDate + ", documentAddress=" + documentAddress + "]";
	}

}
