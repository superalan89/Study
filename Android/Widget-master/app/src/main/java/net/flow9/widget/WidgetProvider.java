package net.flow9.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;

/**
 * Created by pc on 24/11/2017.
 */

public class WidgetProvider extends AppWidgetProvider {

    boolean runFlag = true;
    boolean stopFlag = false;
    final static int INTERVAL = 1000;

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        String action = intent.getAction();
        if(AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(action)){
            Log.d("Widget","onReceive() count==================");
            Bundle extras = intent.getExtras();
            if(extras != null) {
                AppWidgetManager manager = AppWidgetManager.getInstance(context);
                int appWidgetIds[] = manager.getAppWidgetIds(new ComponentName(context, getClass()));
                if(appWidgetIds != null) {
                    for (int appWidgetId : appWidgetIds) {
                        updateWidget(context, manager, appWidgetId);
                    }

                    // 알람 매니저 사용하기
                    long next = System.currentTimeMillis() + INTERVAL;
                    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent target = new Intent(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
                    PendingIntent pIntent = PendingIntent.getBroadcast(context, 0, target, 0);
                    alarmManager.set(AlarmManager.RTC, next, pIntent);

                }
            }
        }
    }
    /*
        위젯 설정시 한번 호출된다
     */
    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    /*
        업데이트 주기가 30분 미만이라면 사용하지 않는다
     */
    @Override
    public void onUpdate(final Context context, final AppWidgetManager appWidgetManager, final int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
//        int count = appWidgetIds.length;
//        Log.d("Widget","onUpdate() count=================="+count);
//        for(int i=0; i<count; i++){
//            updateWidget(context, appWidgetManager, appWidgetIds[i]);
//        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(runFlag){
//                    if(!stopFlag) {
//                        for (int widgetId : appWidgetIds) {
//                            updateWidget(context, appWidgetManager, widgetId);
//                        }
//                    }
//                    try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
//                }
//            }
//        }).start();
    }

    private void updateWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId){
        // 위젯 레이아웃 가져오기
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
        long now = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        // 위젯에 값 설정
        remoteViews.setTextViewText(R.id.textView, sdf.format(now));
        // 수정된 위젯 레이아웃 등록
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }
}
