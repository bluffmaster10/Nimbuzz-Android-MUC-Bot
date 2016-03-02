package example.com.db.nimbuzz_banbot_android_by_db;

import org.jivesoftware.smack.AbstractXMPPConnection;

/**
 * Created by DB on 04-02-2016.
 */
public class XMPPLogic {
    public static AbstractXMPPConnection connection = null;

    private static XMPPLogic ourInstance = null;


    public synchronized static XMPPLogic getInstance() {
        if(ourInstance == null){
            ourInstance = new XMPPLogic();
        }
        return ourInstance;
    }


    public AbstractXMPPConnection getConnection()
    {
        return this.connection;
    }


    public XMPPLogic() {
    }


    public void setConnection(AbstractXMPPConnection connection) {
        this.connection = connection;
    }


}
