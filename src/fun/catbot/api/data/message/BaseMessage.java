package fun.catbot.api.data.message;

import fun.catbot.api.FunJsonSerialize.IJsonSerialize;
import orgJson.JSONObject;

public abstract class BaseMessage implements IJsonSerialize {
    private int type;

    private String messageID;
    private String meteData;

    public BaseMessage(){
        type = getMessageType();
    }

    abstract int getMessageType();

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getMeteData() {
        return meteData;
    }

    public void setMeteData(String meteData) {
        this.meteData = meteData;
    }

    @Override
    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", type);
        jsonObject.put("messageID", messageID);
        jsonObject.put("meteData", meteData);
        return jsonObject.toString();
    }

    @Override
    public void fromJson(String json) {
        JSONObject parserJson = new JSONObject(json);
        type = parserJson.optInt("type");
        messageID = parserJson.optString("messageID");
        meteData = parserJson.optString("meteData");
    }

    public static BaseMessage newMessageFromJson(String json){
        JSONObject parseJson = new JSONObject(json);
        int type = parseJson.optInt("type");
        BaseMessage message = null;
        switch (type) {
            case 1:
                message = new TextMessage();
                break;
            case 2:
                message = new ImageMessage();
                break;
            case 3:
                message = new VoiceMessage();
                break;
            default:
                break;
        }
        if (message != null){
            message.fromJson(json);
            return message;
        }
        throw new RuntimeException("Unknown message type");
    }
}
