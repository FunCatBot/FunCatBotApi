package fun.catbot.api.data.message;

import orgJson.JSONObject;

public class TextMessage extends BaseMessage{
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    int getMessageType() {
        return 1;
    }

    @Override
    public String toJson() {
        String parentData =  super.toJson();
        JSONObject newJson = new JSONObject();
        newJson.put("text", text);
        newJson.put("parent", parentData);
        return newJson.toString();
    }

    @Override
    public void fromJson(String json) {
        JSONObject parserJson = new JSONObject(json);
        text = parserJson.getString("text");
        String parentData = parserJson.getString("parent");
        super.fromJson(parentData);
    }
}
