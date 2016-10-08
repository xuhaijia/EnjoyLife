package com.lanou.xuhaijia.enjoylife.myself.travelcollection;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.platform.comapi.map.C;
import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.myself.pullrefreshxiaoqing.SwipeRefreshLayout;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.tools.DBTool;
import com.lanou.xuhaijia.enjoylife.travel.attractions.AttractionsAty;
import com.lanou.xuhaijia.enjoylife.travel.attractions.listattraction.AttractionListAty;
import com.lanou.xuhaijia.enjoylife.travel.collection.CollectionAttractBean;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

/**
 * Created by 国冰冰 on 16/9/28.
 */
public class TravelCollectionFragment extends BaseFragment {


    private ListView listViewItem;
    private LinearLayout linearLayout;
    private SwipeRefreshLayout srl;


    @Override
    protected int setLayout() {
        return R.layout.fragment_collect_class;
    }

    @Override
    protected void initView() {

        linearLayout = bindView(R.id.travel_collect_fragmentt_linelayout);
        listViewItem = bindView(R.id.travel_collect_fragmentt_listview);

        srl = bindView(R.id.travel_collect_fragment_swipe);


        srl.setMode(SwipeRefreshLayout.Mode.BOTH);

        srl.setOnRefreshListener(new SwipeRefreshLayout.SwipeOnRefreshListener() {
            @Override
            public void onRefresh(int mode, boolean isDrag) {

                if (mode == 1) {


                    Toast.makeText(mContext, "下拉刷新", Toast.LENGTH_SHORT).show();


                }
                if (mode == 2) {

                    Toast.makeText(mContext, "上拉加载", Toast.LENGTH_SHORT).show();

                }

                srl.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        srl.refreshComplete();
                    }
                }, 2000);

            }
        });


    }

    @Override
    protected void initData() {


        BmobUser bmobUser = BmobUser.getCurrentUser();

        if (bmobUser != null) {

            String username = bmobUser.getUsername();

            Log.d("TravelCollectionFragmen", username);
            DBTool.getInstance().queryData(CollectionAttractBean.class, "where NAME_USER = ?", username, new DBTool.QueryComplete<List<CollectionAttractBean>>() {
                @Override
                public void onCompleted(final List<CollectionAttractBean> collection) {

                    if (collection.size() != 0) {


                        listViewItem.setAdapter(new CommonAdapter<CollectionAttractBean>(collection, mContext, R.layout.item_travel_collect_fragment) {
                            @Override
                            public void setData(CollectionAttractBean collectionAttractBean, CommonViewHolder viewHolder, int position) {


                                viewHolder.setText(R.id.item_travel_collect_fragment_textview_ch, collectionAttractBean.getNameCN());

                                viewHolder.setImage(R.id.item_travel_collect_fragment_imager, collectionAttractBean.getUrlPic(), mContext);


                            }
                        });


                        listViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                                Intent intent = new Intent(getActivity(), AttractionListAty.class);

                                intent.putExtra("urlAtt", collection.get(i).getUrlAtt());

                                startActivity(intent);


                            }
                        });


                    }else {

                        Toast.makeText(mContext, "请您收藏一个呗", Toast.LENGTH_SHORT).show();


                    }
                }


            });


        }
    }
}