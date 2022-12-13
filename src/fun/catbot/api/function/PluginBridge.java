package fun.catbot.api.function;

import fun.catbot.api.data.message.BaseMessage;
import fun.catbot.api.data.session.Session;
import fun.catbot.api.data.stream.RemoteFileStream;

import java.io.InputStream;

public interface PluginBridge {
    String sendFileStream(String path);
    String sendFileStream(InputStream ins);

    //单消息发送方法
    String sendTextMessage(Session session, String text);
    String sendPicMessage(Session session, RemoteFileStream stream);
    String sendFileMessage(Session session,RemoteFileStream stream);
    String sendVoiceMessage(Session session,RemoteFileStream stream);
    String sendReplyMessage(Session session, BaseMessage replyTo);

    //完整消息发送
    String sendMessage(Session session, BaseMessage message);
}
