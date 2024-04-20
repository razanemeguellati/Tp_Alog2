package dataaccess;

import java.util.HashMap;
import java.util.Map;

public interface IStock {
    String getCodeItem();
    void setCodeItem(String codeItem);

    boolean isStat();
    void setStat(boolean stat);

}
