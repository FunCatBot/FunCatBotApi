package fun.catbot.api.function;

import fun.catbot.api.data.info.ChannelMemberInfo;

import java.util.List;

public interface ApiBridge {
    String getImageUrl(String meteData);
    String getAvatarUrl(String userID);
    ChannelMemberInfo getMemberInfo(String channelID, String userID);
    List<String> getChannelMembers(String channelID);
}
