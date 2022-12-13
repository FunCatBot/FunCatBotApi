package fun.catbot.api.data.message;

import orgJson.JSONObject;

public class VoiceMessage extends BaseMessage{
    private String hash;
    private String voiceMeteData;
    @Override
    int getMessageType() {
        return 3;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getVoiceMeteData() {
        return voiceMeteData;
    }

    public void setVoiceMeteData(String voiceMeteData) {
        this.voiceMeteData = voiceMeteData;
    }

    @Override
    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hash", hash);
        jsonObject.put("voiceMeteData", voiceMeteData);
        String parentJson = super.toJson();
        jsonObject.put("parent", parentJson);
        return jsonObject.toString();
    }

    @Override
    public void fromJson(String json) {
        JSONObject parserJson = new JSONObject(json);
        hash = parserJson.getString("hash");
        voiceMeteData = parserJson.getString("voiceMeteData");
        String parentJson = parserJson.getString("parent");
        super.fromJson(parentJson);
    }
}
