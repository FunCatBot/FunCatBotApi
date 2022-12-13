package fun.catbot.api.data.session;

import orgJson.JSONObject;

public class UserSession extends Session{
    private String UserID;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    @Override
    int getSessionType() {
        return 2;
    }

    @Override
    public String toJson() {
        String parentData =  super.toJson();
        JSONObject newJson = new JSONObject();
        newJson.put("UserID", UserID);
        newJson.put("parent", parentData);
        return newJson.toString();
    }

    @Override
    public void fromJson(String json) {
        JSONObject parserJson = new JSONObject(json);
        UserID = parserJson.getString("UserID");
        String parentData = parserJson.getString("parent");
        super.fromJson(parentData);
    }
}
