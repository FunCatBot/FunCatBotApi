package fun.catbot.api.data.message;

import orgJson.JSONArray;
import orgJson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ComplexMessage extends BaseMessage{
    private List<BaseMessage> messageChain;
    @Override
    int getMessageType() {
        return 10;
    }

    public List<BaseMessage> getMessageChain() {
        return messageChain;
    }

    public void setMessageChain(List<BaseMessage> messageChain) {
        this.messageChain = messageChain;
    }
    public void appendMessage(BaseMessage baseMessage){
        if (messageChain == null){
            messageChain = new ArrayList<>();
        }
        messageChain.add(baseMessage);
    }

    @Override
    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        JSONArray chainMessage = new JSONArray();
        for (BaseMessage baseMessage : messageChain) {
            chainMessage.put(baseMessage.toJson());
        }
        jsonObject.put("messageChain", chainMessage);
        String parentJson = super.toJson();
        jsonObject.put("parent", parentJson);
        return jsonObject.toString();
    }

    @Override
    public void fromJson(String json) {
        JSONObject parserJson = new JSONObject(json);
        JSONArray chainMessage = parserJson.getJSONArray("messageChain");
        for (int i = 0; i < chainMessage.length(); i++) {
            String messageJson = chainMessage.getString(i);
            BaseMessage baseMessage = BaseMessage.newMessageFromJson(messageJson);
            messageChain.add(baseMessage);
        }
        String parentJson = parserJson.getString("parent");
        super.fromJson(parentJson);
    }
}
