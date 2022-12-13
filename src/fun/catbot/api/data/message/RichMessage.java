package fun.catbot.api.data.message;

import orgJson.JSONObject;

public class RichMessage extends BaseMessage{
    private int flag;
    private String body;
    private String meteData;

    @Override
    int getMessageType() {
        return 5;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String getMeteData() {
        return meteData;
    }

    @Override
    public void setMeteData(String meteData) {
        this.meteData = meteData;
    }

    @Override
    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", flag);
        jsonObject.put("body", body);
        jsonObject.put("meteData", meteData);
        String parentJson = super.toJson();
        jsonObject.put("parent", parentJson);
        return jsonObject.toString();
    }

    @Override
    public void fromJson(String json) {
        JSONObject parserJson = new JSONObject(json);
        flag = parserJson.getInt("flag");
        body = parserJson.getString("body");
        meteData = parserJson.getString("meteData");
        String parentJson = parserJson.getString("parent");
        super.fromJson(parentJson);
    }
}
