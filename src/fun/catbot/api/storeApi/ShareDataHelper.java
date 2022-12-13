package fun.catbot.api.storeApi;

import java.io.InputStream;
import java.io.OutputStream;

public interface ShareDataHelper {
    //简易接口
    String getString(String path,String key);
    void putString(String path,String key,String value);

    int getInt(String path,String key);
    void putInt(String path,String key,int value);

    long getLong(String path,String key);
    void putLong(String path,String key,long value);

    double getFloat(String path,String key);
    void putFloat(String path,String key,double value);

    boolean getBoolean(String path,String key);
    void putBoolean(String path,String key,boolean value);

    //数据流接口
    InputStream getFileReadStream(String path,String name);
    OutputStream getFileWriteStream(String path,String name);

    //通信接口
    CommunicateBridge registerMessageNotify(String appName,CommunicateBridge.messageNotify notify);
}
