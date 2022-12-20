package fun.catbot.api.data.info;

import fun.catbot.api.FunJsonSerialize.IJsonSerialize;
import fun.catbot.api.function.ApiBridge;
import fun.catbot.api.function.ApiEnv;
import orgJson.JSONArray;
import orgJson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChannelInfo implements IJsonSerialize {
    private String channelID;
    private String channelName;
    private String creatorID;
    private List<String> adminID;
    public List<String> getChannelUserID(){
        return ApiEnv.bridge.getChannelMembers(channelID);
    }
    public ChannelMemberInfo getMemberInfo(String userID){
        return ApiEnv.bridge.getMemberInfo(channelID, userID);
    }
    public String getChannelID() {
        return channelID;
    }
    public String getChannelName() {
        return channelName;
    }
    public String getCreatorID() {
        return creatorID;
    }
    public List<String> getAdminID() {
        return adminID;
    }
    public void setChannelID(String channelID){
        this.channelID = channelID;
    }
    public void setChannelName(String channelName){
        this.channelName = channelName;
    }
    public void setCreatorID(String creatorID){
        this.creatorID = creatorID;
    }
    public void setAdminID(List<String> adminID){
        this.adminID = adminID;
    }
    @Override
    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("channelID", channelID);
        jsonObject.put("channelName", channelName);
        jsonObject.put("creatorID", creatorID);
        JSONArray jsonArray = new JSONArray();
        for (String id : adminID){
            jsonArray.put(id);
        }
        jsonObject.put("adminID", jsonArray);
        return jsonObject.toString();
    }

    @Override
    public void fromJson(String json) {
        JSONObject jsonObject = new JSONObject(json);
        channelID = jsonObject.optString("channelID");
        channelName = jsonObject.optString("channelName");
        creatorID = jsonObject.optString("creatorID");
        JSONArray list = jsonObject.optJSONArray("adminID");
        if (list == null){
            adminID = new ArrayList<>();
        }else {
            for (int i = 0; i < list.length(); i++) {
                adminID.add(list.optString(i));
            }
        }
    }
}
