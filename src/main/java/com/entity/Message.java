package com.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the messages database table.
 * 
 */
@Entity
@Table(name="messages")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int msgId;

	private Boolean hasRead;

	private String messageText;

	private int userIdSender;

	private int userIdReceiver;

	public Message() {
	}

	public int getMsgId() {
		return this.msgId;
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



}