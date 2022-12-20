package fun.catbot.api.data.info;

public class ChannelMemberInfo extends BaseUser{
    private String channelID;
    private String remark;
    private long joinTime;
    private long lastActiveTime;
    private int level;
    private int Permission;
    private String extraInfo;
    public String getChannelID(){
        return channelID;
    }
    public String getRemark(){
        return remark;
    }
    public long getJoinTime(){
        return joinTime;
    }
     public long getLastActiveTime(){
        return lastActiveTime;
     }
}
