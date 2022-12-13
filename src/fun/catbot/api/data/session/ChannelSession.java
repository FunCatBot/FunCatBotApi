package fun.catbot.api.data.session;

import fun.catbot.api.FunJsonSerialize.IJsonSerialize;
import orgJson.JSONObject;

public class ChannelSession extends Session implements IJsonSerialize {
    private String channelID;
    private String targetChatID;

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public String getTargetChatID() {
        return targetChatID;
    }

    public void setTargetChatID(String targetChatID) {
        this.targetChatID = targetChatID;
    }

    @Override
    int getSessionType() {
        return 1;
    }

    @Override
    public String toJson() {
        String parentData =  super.toJson();
        JSONObject newJson = new JSONObject();
        newJson.put("channelID", channelID);
        newJson.put("targetChatID", targetChatID);
        newJson.put("parent", parentData);
        return newJson.toString();
    }

    @Override
    public void fromJson(String json) {
        JSONObject parserJson = new JSONObject(json);
        channelID = parserJson.getString("channelID");
        targetChatID = parserJson.getString("targetChatID");
        String parentData = parserJson.getString("parent");
        super.fromJson(parentData);
    }
}
