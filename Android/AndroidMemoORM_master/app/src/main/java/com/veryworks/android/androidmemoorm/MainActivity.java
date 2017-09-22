package com.veryworks.android.androidmemoorm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.veryworks.android.androidmemoorm.dao.PicNoteDAO;
import com.veryworks.android.androidmemoorm.model.PicNote;

import java.util.List;

/**
 * RecyclerView 를 사용한 목록 만들기
 *
 * 0. 화면만들기
 *
 * 1. 데이터를 정의
 *
 * 2. 아답터를 재정의
 *
 * 3. 재정의한 아답터를 생성하면서 데이터를 담는다
 *
 * 4. 아답터와 RecyclerView 컨테이너를 연결
 *
 * 5. RecyclerView 에 레이아웃매니저를 성정
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * 레이아웃에서 함수를 직접 호출한다
     * @param view
     */
    public void openDraw(View view){
        Intent intent = new Intent(this, DrawActivity.class);
        startActivity(intent);
    }

    private void init(){
        PicNoteDAO dao = new PicNoteDAO(this);
        //* 1. 데이터를 정의
        // DB에 테스트 데이터 넣기
//        for(int i=0; i<1000 ; i++){
//            PicNote picNote = new PicNote();
//            picNote.setTitle("안녕하세요 "+i);
//            picNote.setDatetime(System.currentTimeMillis());
//            // db 에다가 넣은후
//            dao.create(picNote);
//        }
        // db에서 읽어온다.
        List<PicNote> data = dao.readAll();

        //* 3. 재정의한 아답터를 생성하면서 데이터를 담는다
        CustomAdapter adapter = new CustomAdapter();
        adapter.setData(data);
        //* 4. 아답터와 RecyclerView 컨테이너를 연결
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recylerView);
        recyclerView.setAdapter(adapter);
        //* 5. RecyclerView 에 레이아웃매니저를 설정
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 레이아웃 매니저 종류
        /*
        1. LinearLayoutManager
           - 리사이클러 뷰에서 가장 많이 쓰이는 레이아웃으로 수평, 수직 스크롤을 제공하는 리스트를 만들 수 있다.
        2. StaggeredGridLayoutManager
           - 이 레이아웃을 통해 뷰마다 크기가 다른 레이아웃을 만들 수 있다. 마치 Pinterest 같은 레이아웃 구성가능.
        3. GridLayoutManager
           - 갤러리(GridView) 같은 격자형 리스트를 만들 수 있습니다.

        - 사용예시// StaggeredGrid 레이아웃을 사용한다
            RecyclerView.LayoutManager lm
                = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            lm = new LinearLayoutManager(this);
            lm = new GridLayoutManager(this,3);
        */
    }
}
