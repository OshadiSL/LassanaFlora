package observer;

import java.rmi.Remote;

public interface Observer extends Remote {
    public void update(String mesage )throws Exception;

}
