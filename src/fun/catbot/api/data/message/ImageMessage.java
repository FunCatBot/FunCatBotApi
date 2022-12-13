package fun.catbot.api.data.message;

import fun.catbot.api.function.ApiEnv;
import orgJson.JSONObject;

public class ImageMessage extends BaseMessage{
    private String hash;
    private String imageMeteData;

    public ImageMessage() {

    }

    public String getDownloadUrl(){
        return ApiEnv.bridge.getImageUrl(imageMeteData);
    }
    @Override
    int getMessageType() {
        return 2;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getImageMeteData() {
        return imageMeteData;
    }

    public void setImageMeteData(String imageMeteData) {
        this.imageMeteData = imageMeteData;
    }

    @Override
    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hash", hash);
        jsonObject.put("imageMeteData", imageMeteData);
        String parentJson = super.toJson();
        jsonObject.put("parent", parentJson);
        return jsonObject.toString();
    }

    @Override
    public void fromJson(String json) {
        JSONObject parserJson = new JSONObject(json);
        hash = parserJson.getString("hash");
        imageMeteData = parserJson.getString("imageMeteData");
        String parentJson = parserJson.getString("parent");
        super.fromJson(parentJson);
    }
}
