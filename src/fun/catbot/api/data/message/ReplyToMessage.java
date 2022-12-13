package fun.catbot.api.data.message;

import orgJson.JSONObject;

public class ReplyToMessage extends BaseMessage{
    private String replyToMessageId;
    @Override
    int getMessageType() {
        return 4;
    }

    public String getReplyToMessageId() {
        return replyToMessageId;
    }
    public void setReplyToMessageId(String replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
    }

    @Override
    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("replyToMessageId", replyToMessageId);
        String parentJson = super.toJson();
        jsonObject.put("parent", parentJson);
        return jsonObject.toString();
    }

    @Override
    public void fromJson(String json) {
        JSONObject parserJson = new JSONObject(json);
        replyToMessageId = parserJson.getString("replyToMessageId");
        String parentJson = parserJson.getString("parent");
        super.fromJson(parentJson);
    }
}
