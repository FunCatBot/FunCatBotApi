package fun.catbot.api.data.message;

public class FileMessage extends BaseMessage{

    private String fileID;

    public String getFileName(){
        return null;
    }
    public long getFileSize(){
        return 0;
    }
    public
    @Override
    int getMessageType() {
        return 6;
    }
}
