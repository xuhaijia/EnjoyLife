package com.lanou.xuhaijia.enjoylife.picture.picture;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.MyApp;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.picture.details.DetailsActivity;
import com.wirelesspienetwork.overview.misc.Utilities;
import com.wirelesspienetwork.overview.model.OverviewAdapter;
import com.wirelesspienetwork.overview.model.ViewHolder;
import com.wirelesspienetwork.overview.views.Overview;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public class PictureFragment extends BaseFragment {

    Overview overview;
    boolean mVisible;
    private OverviewAdapter stack;
    private View v;
    private int urlAdd;

    @Override
    protected int setLayout() {
        return R.layout.fragment_picture;
    }

    @Override
    protected void initView() {
        overview = bindView(R.id.fragment_picture_over_views);
    }

    @Override
    protected void initData() {
        overview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(SearchManager.INTENT_GLOBAL_SEARCH_ACTIVITY_CHANGED);

        try {
            Utilities.setShadowProperty("ambientRatio", String.valueOf(1.5f));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mVisible = true;
        ArrayList<Integer> models = new ArrayList<>();
        for (int i = 0; i < 20; ++i) {
            Random random = new Random();
            random.setSeed(i);
            models.add(0x00ffffff);
        }

        stack = new OverviewAdapter<ViewHolder<View, Integer>, Integer>(models) {

            private RelativeLayout layout;
            private ImageView avatar;
            private ImageView image;
            private TextView sign;
            private TextView titleSub;
            private TextView title;

            @Override
            public ViewHolder onCreateViewHolder(Context context, ViewGroup parent) {
                v = View.inflate(context, R.layout.fragment_picture_item, null);
                return new ViewHolder<View, Integer>(v);
            }

            @Override
            public void onBindViewHolder(final ViewHolder<View, Integer> viewHolder) {
                viewHolder.itemView.setBackgroundColor(viewHolder.model);
                mNetTool.getData(UrlValues.PICTURE_ALL_URL, PictureBean.class, new NetTool.NetInterface<PictureBean>() {
                    @Override
                    public void onSuccess(PictureBean pictureBean) {
                        int i = viewHolder.getPosition();

                        urlAdd = pictureBean.getData().getArticles().get(i).getId();
                        layout = (RelativeLayout) viewHolder.itemView.findViewById(R.id.fragment_picture_item_layout);
                        layout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getActivity(),DetailsActivity.class);
                                intent.putExtra("ID",urlAdd);
                                startActivity(intent);
                            }
                        });
                        title = (TextView) viewHolder.itemView.findViewById(R.id.fragment_picture_item_title);
                        titleSub = (TextView) viewHolder.itemView.findViewById(R.id.fragment_picture_item_title_sub);
                        sign = (TextView) viewHolder.itemView.findViewById(R.id.fragment_picture_item_sign);
                        image = (ImageView) viewHolder.itemView.findViewById(R.id.fragment_picture_item_image);
                        avatar = (ImageView) viewHolder.itemView.findViewById(R.id.fragment_picture_item_avatar);
                        title.setText(pictureBean.getData().getArticles().get(19 - i).getTitle());
                        titleSub.setText(pictureBean.getData().getArticles().get(19 - i).getSub_title());
                        sign.setText(pictureBean.getData().getArticles().get(19 - i).getAuthor().getSign());
                        Glide.with(MyApp.getContext()).load(pictureBean.getData().getArticles().get(19 - i).getImage_url()).into(image);
                        Glide.with(MyApp.getContext()).load(pictureBean.getData().getArticles().get(19 - i).getAuthor().getAvatar_url()).into(avatar);
                    }

                    @Override
                    public void onError(String errorMsg) {

                    }
                });
            }
        };

        overview.setTaskStack(stack);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
/**
 * ArrayList 采用的是数组形式来保存对象的，这种方式将对象放在连续的位置中，所以最大的缺点就是插入删除时非常麻烦
 * LinkedList 采用的将对象存放在独立的空间中，而且在每个空间中还保存下一个链接的索引  但是缺点就是查找非常麻烦 要丛第一个索引开始
 */

}
