package fun.catbot.api.storeApi;

public abstract class CommunicateBridge {
    abstract void send(String appName,String message);
    public interface messageNotify{
        void onMessage(String message);
    }
}
