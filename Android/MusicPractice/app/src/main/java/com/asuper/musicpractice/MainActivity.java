package com.asuper.musicpractice;

import android.content.Intent;
import android.media.AudioManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.asuper.musicpractice.model.Music;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public void init(){
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        setContentView(R.layout.activity_main);
        load();
        initView();
        initViewPager();
        initTabs();
        initListener();
    }

    private void load(){
        music = Music.getInstance();
        music.load(this);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
    }
    private void initViewPager(){
        List<Fragment> list = new ArrayList<>();
        MusicFragment fragTitle = MusicFragment.newInstance(1);
        MusicFragment fragArtist = MusicFragment.newInstance(1);
        MusicFragment fragAlbum = MusicFragment.newInstance(1);
        MusicFragment fragGenre = MusicFragment.newInstance(1);
        list.add(fragTitle);
        list.add(fragArtist);
        list.add(fragAlbum);
        list.add(fragGenre);
        ListPagerAdapter adapter
                = new ListPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
    }
    private void initTabs(){
        tablayout.addTab(tablayout.newTab().setText(getString(R.string.tab_title)));
        tablayout.addTab(tablayout.newTab().setText(getString(R.string.tab_artist)));
        tablayout.addTab(tablayout.newTab().setText(getString(R.string.tab_album)));
        tablayout.addTab(tablayout.newTab().setText(getString(R.string.tab_genre)));
    }
    private void initListener(){
        tablayout.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager)
        );
        viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tablayout)
        );
    }

    @Override
    public List<Music.Item> getList() {
        return music.data;
    }

    @Override
    public void openPlayer(int position) {
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra(Const.KEY_POSITION, position);
        startActivity(intent);
    }
}