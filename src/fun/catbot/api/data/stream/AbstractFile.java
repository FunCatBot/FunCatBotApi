package fun.catbot.api.data.stream;

import fun.catbot.api.data.info.BaseUser;
import fun.catbot.api.data.session.Session;

public abstract class AbstractFile {
    abstract String getFileName();
    abstract long getFileSize();
    abstract RemoteFileStream getFileStream();
    abstract String getRemotePath();
    abstract BaseUser getUploader();
    abstract Session getTarget();
}
