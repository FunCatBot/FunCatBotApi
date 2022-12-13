package fun.catbot.api.data.session;

import fun.catbot.api.FunJsonSerialize.IJsonSerialize;
import orgJson.JSONObject;

public abstract class Session implements IJsonSerialize {
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Session(){
        type = getSessionType();
    }

    abstract int getSessionType();

    @Override
    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", type);
        return jsonObject.toString();
    }

    @Override
    public void fromJson(String json) {
        JSONObject parserJson = new JSONObject(json);
        type = parserJson.getInt("type");
    }
}
