package com.alc.module_home.ui.fragment.android;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/30
 */
public class PageInfo {
    int page = 0;

    void nextPage() {
        page++;
    }

    void reset() {
        page = 0;
    }

    boolean isFirstPage() {
        return page == 0;
    }
}
