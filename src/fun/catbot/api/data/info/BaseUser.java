package fun.catbot.api.data.info;

import fun.catbot.api.FunJsonSerialize.IJsonSerialize;
import fun.catbot.api.function.ApiEnv;
import orgJson.JSONObject;

public class BaseUser implements IJsonSerialize {
    private int userType;
    private String userID;
    private String nickname;
    private String avatarUrl;
    private String extraInfo;

    public String getAvatarUrl(){
        return ApiEnv.bridge.getAvatarUrl(userID);
    }
    public String getExtraInfo(String key){
        try {
            JSONObject newJson = new JSONObject(extraInfo);
            return newJson.optString(key);
        }catch (Exception e){
            return null;
        }

    }
    @Override
    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userType", userType);
        jsonObject.put("userID", userID);
        return jsonObject.toString();
    }

    @Override
    public void fromJson(String json) {
        JSONObject jsonObject = new JSONObject(json);
        userType = jsonObject.optInt("userType");
        userID = jsonObject.optString("userID");
    }
}
