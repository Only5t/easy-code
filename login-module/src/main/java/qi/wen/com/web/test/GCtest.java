package qi.wen.com.web.test;

import java.util.ArrayList;
import java.util.List;

public class GCtest {
    public static void main(String[] args) {
        for(int i = 0; i < 10000; i++) {
            List<String> list = new ArrayList<>();
            list.add("aaaaaaaaaaaaa");
        }
        System.gc();
    }
}
