package fun.catbot.api.storeApi;

import java.io.InputStream;
import java.io.OutputStream;

public interface CacheDataHelper {
    InputStream getFileReadStream(String path, String name);
    OutputStream getFileWriteStream(String path, String name);
}
