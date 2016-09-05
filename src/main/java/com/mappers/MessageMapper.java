package com.mappers;

import com.dto.MessageDto;
import com.entity.Message;

public class MessageMapper {

	public static Message convertMessageDtoToEnitry(MessageDto msgDto){
		Message msg = new Message();
		msg.setMsgId(msgDto.getMsgId());
		msg.setHasRead(msgDto.getHasRead());
		msg.setMessageText(msgDto.getMessageText());
		msg.setUserIdReceiver(msgDto.getUserIdReceiver());
		msg.setUserIdSender(msgDto.getUserIdSender());
        return msg;
	}
	
	
	public static MessageDto convertMessageEntityToDto(Message msg){
		MessageDto msgDto = new MessageDto();
		msgDto.setMsgId(msg.getMsgId());
		msgDto.setHasRead(msg.getHasRead());
		msgDto.setMessageText(msg.getMessageText());
		msgDto.setUserIdReceiver(msg.getUserIdReceiver());
		msgDto.setUserIdSender(msg.getUserIdSender());
        return msgDto;
	}
	
	
	
}
