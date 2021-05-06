package com.alc.module_home.ui.fragment.android;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.alc.module_home.R;
import com.alc.module_home.data.DataServer;
import com.alc.module_home.entity.Status;
import com.alc.module_home.utils.Tips;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/30
 */
public class AndroidAdapter  extends BaseQuickAdapter<Status, BaseViewHolder>   implements LoadMoreModule {
    public AndroidAdapter() {
        super(R.layout.android_item, DataServer.getSampleData(100));
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Status item) {
        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            default:
                break;
        }
        helper.setText(R.id.tweetName, "Hoteis in Rio de Janeiro");

    }

    private ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(@NonNull View widget) {
          //  Tips.show("事件触发了 landscapes and nedes");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(getContext().getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };
}
