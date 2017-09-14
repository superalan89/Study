## 안드로이드 애니메이션 속성


#### 1. Translate (이동)
```Java
<translate
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromXDelta="0"
    android:fromYDelta="0"
    android:toXDelta="100"
    android:toYDelta="300"
    android:fillAfter="true"
    android:duration="3000"> <!-- 시간값 = 1/1000 초 -->
    <!--
    fillAfter = true일 경우 애니메이션의 종료위치에 고정
                , false 일 경우 원래 위치로 복귀 (default = false)
    duration = 1/1000초
    -->
</translate>
```

#### 2. Rotate (회전)
```Java
<rotate
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromDegrees="0"
    android:toDegrees="270"
    android:pivotX="100%"
    android:pivotY="50%"
    android:fillAfter="true"
    android:duration="3000">
    <!--
    fillAfter = true일 경우 애니메이션의 종료위치에 고정
                , false 일 경우 원래 위치로 복귀 (default = false)
    duration = 1/1000초
    -->
</rotate>
```

#### 3. Scale (비율)
```Java
<scale
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromXScale="1.0"
    android:fromYScale="1.0"
    android:toXScale="0.5"
    android:toYScale="5"
    android:fillAfter="true"
    android:duration="3000"> <!-- 시간값 = 1/1000 초 -->
    <!--
    fillAfter = true일 경우 애니메이션의 종료위치에 고정
                , false 일 경우 원래 위치로 복귀 (default = false)
    duration = 1/1000초
    -->
</scale>
```

#### 4. Alpha (투명)
```Java
<alpha
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromAlpha="0.0"
    android:toAlpha="1.0"
    android:fillAfter="true"
    android:duration="3000"> <!-- 시간값 = 1/1000 초 -->
    <!--
    fillAfter = true일 경우 애니메이션의 종료위치에 고정
                , false 일 경우 원래 위치로 복귀 (default = false)
    duration = 1/1000초
    -->
</alpha>
```
