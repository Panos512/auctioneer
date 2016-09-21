package com.dto;

public class MessageDto {
	private int msgId;
    private Boolean hasRead;
    private String messageText;
    private int userIdSender;
    private int userIdReceiver;
	
    public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public Boolean getHasRead() {
		return hasRead;
	}
	public void setHasRead(Boolean hasRead) {
		this.hasRead = hasRead;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public int getUserIdSender() {
		return userIdSender;
	}
	public void setUserIdSender(int userIdSender) {
		this.userIdSender = userIdSender;
	}
	public int getUserIdReceiver() {
		return userIdReceiver;
	}
	public void setUserIdReceiver(int userIdReceiver) {
		this.userIdReceiver = userIdReceiver;
	}

	@Override
	public String toString() {
		return "MessageDto{" +
				"msgId=" + msgId +
				", hasRead=" + hasRead +
				", messageText='" + messageText + '\'' +
				", userIdSender=" + userIdSender +
				", userIdReceiver=" + userIdReceiver +
				'}';
	}
}
