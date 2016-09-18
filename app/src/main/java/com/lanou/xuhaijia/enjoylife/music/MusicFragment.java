package com.lanou.xuhaijia.enjoylife.music;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.music.hotmusician.HotMusicianFragment;
import com.lanou.xuhaijia.enjoylife.music.hotsingle.HotSingleFragment;
import com.lanou.xuhaijia.enjoylife.music.typesearch.TypeSearchFragment;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public class MusicFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {

    private ImageView trigonSingle;
    private ImageView trigonMusician;
    private ImageView trigonSearch;
    private RadioGroup musicRadioGroup;

    @Override
    protected int setLayout() {
        return R.layout.fragment_music;
    }

    @Override
    protected void initView() {
        trigonSingle = bindView(R.id.fragment_music_trigon_single);
        trigonMusician = bindView(R.id.fragment_music_trigon_musician);
        trigonSearch = bindView(R.id.fragment_music_trigon_search);
        musicRadioGroup = bindView(R.id.fragment_music_small_title);
        musicRadioGroup.setOnCheckedChangeListener(this);
        musicRadioGroup.check(R.id.fragment_music_hot_single);

    }

    @Override
    protected void initData() {

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (i) {
            case R.id.fragment_music_hot_single:
                trigonSingle.setVisibility(View.VISIBLE);
                trigonMusician.setVisibility(View.INVISIBLE);
                trigonSearch.setVisibility(View.INVISIBLE);
                fragmentTransaction.replace(R.id.fragment_music_fl , new HotSingleFragment());
                break;
            case R.id.fragment_music_hot_musician:
                trigonSingle.setVisibility(View.INVISIBLE);
                trigonMusician.setVisibility(View.VISIBLE);
                trigonSearch.setVisibility(View.INVISIBLE);
                fragmentTransaction.replace(R.id.fragment_music_fl , new HotMusicianFragment());
                break;
            case R.id.fragment_music_type_search:
                trigonSingle.setVisibility(View.INVISIBLE);
                trigonMusician.setVisibility(View.INVISIBLE);
                trigonSearch.setVisibility(View.VISIBLE);
                fragmentTransaction.replace(R.id.fragment_music_fl , new TypeSearchFragment());
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }
}
