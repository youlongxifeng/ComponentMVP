package com.alc.module_home.data;


import com.alc.module_home.entity.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class DataServer {

    public static final String HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK = "https://avatars1.githubusercontent.com/u/7698209?v=3&s=460";
    public static final String CYM_CHAD = "CymChad";
    public static final String CHAY_CHAN = "ChayChan";

    private DataServer() {
    }

    public static List<Status> getSampleData(int lenth) {
        List<Status> list = new ArrayList<>();
        for (int i = 0; i < lenth; i++) {
            Status status = new Status();
            status.setUserName("Chad" + i);
            status.setCreatedAt("04/05/" + i);
            status.setRetweet(i % 2 == 0);
            status.setUserAvatar("https://avatars1.githubusercontent.com/u/7698209?v=3&s=460");
            status.setText("BaseRecyclerViewAdpaterHelper https://www.recyclerview.org");
            list.add(status);
        }
        return list;
    }

    public static List<Status> addData(List list, int dataSize) {
        for (int i = 0; i < dataSize; i++) {
            Status status = new Status();
            status.setUserName("Chad" + i);
            status.setCreatedAt("04/05/" + i);
            status.setRetweet(i % 2 == 0);
            status.setUserAvatar("https://avatars1.githubusercontent.com/u/7698209?v=3&s=460");
            status.setText("Powerful and flexible RecyclerAdapter https://github.com/CymChad/BaseRecyclerViewAdapterHelper");
            list.add(status);
        }

        return list;
    }


////
//    public static List<DiffUtilDemoEntity> getDiffUtilDemoEntities() {
//        List<DiffUtilDemoEntity> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++){
//            list.add(new DiffUtilDemoEntity(
//                    i,
//                    "Item " + i,
//                    "This item " + i + " content",
//                    "06-12")
//            );
//        }
//        return list;
//    }
}
