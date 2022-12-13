package fun.catbot.api.data.info;

import fun.catbot.api.FunJsonSerialize.IJsonSerialize;
import orgJson.JSONObject;

public class BaseUser implements IJsonSerialize {
    private int userType;
    private String userID;

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
