package com.asuper.bicylce;

import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.asuper.bicylce.model.Json;
import com.asuper.bicylce.model.Row;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.util.List;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        load();

    }
    // 데이터 로드
    private void load(){
        new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... voids) {
                return Remote.getData("http://openapi.seoul.go.kr:8088/4c425976676b6f643437665377554c/json/GeoInfoBikeConvenientFacilitiesWGS/1/100");
            }
            @Override
            protected void onPostExecute(String s) {
                Gson gson = new Gson();
                Json json = gson.fromJson(s, Json.class);
                rows = json.getGeoInfoBikeConvenientFacilitiesWGS().getRow();
                Log.d("MapsActivity","==="+rows);
                mapFragment.getMapAsync(MapsActivity.this);
            }
        }.execute();
    }

    // 좌표 데이터를 저장하기 위한 저장소
    Row rows[] = null;
    // 데이터를 사용해서 마크를 각 좌표에 출력
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng point = null;
        for(Row row :rows) {
            point = new LatLng(Double.parseDouble(row.getLAT())
                    , Double.parseDouble(row.getLNG()));
            mMap.addMarker(new MarkerOptions().position(point).title(row.getCLASS()));
        }
        point = new LatLng(37.5399344, 126.9737224);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 10));
    }
}
