## 위젯 실습

### 1. TextView

```Java
<TextView
        android:id="@+id/textResult"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginLeft="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginTop="8dp"
        android:text="TextView"
        android:textAppearance="@style/TextAppearance.AppCompat.Large"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

### 2. ToggleButton
```Java
<ToggleButton
        android:id="@+id/toggleButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="ToggleButton"
        android:layout_marginTop="8dp"
        app:layout_constraintTop_toBottomOf="@+id/textResult"
        android:layout_marginLeft="8dp"
        app:layout_constraintLeft_toLeftOf="parent" />
```

### 3. CheckBox
```Java
<CheckBox
        android:id="@+id/checkDog"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:text="Dog"
        app:layout_constraintTop_toBottomOf="@+id/toggleButton"
        android:layout_marginLeft="8dp"
        app:layout_constraintLeft_toLeftOf="parent" />

    <CheckBox
        android:id="@+id/checkPig"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="0dp"
        android:text="Pig"
        app:layout_constraintLeft_toRightOf="@+id/checkDog"
        app:layout_constraintTop_toTopOf="@+id/checkDog" />

    <CheckBox
        android:id="@+id/checkCow"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="0dp"
        android:text="Cow"
        app:layout_constraintLeft_toRightOf="@+id/checkPig"
        app:layout_constraintTop_toTopOf="@+id/checkPig" />
```

### 4. RadioButton
```Java
<RadioGroup
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginLeft="8dp"
        app:layout_constraintLeft_toLeftOf="parent"
        android:layout_marginTop="8dp"
        app:layout_constraintTop_toBottomOf="@+id/checkDog"
        android:id="@+id/radioGroup">

        <RadioButton
            android:id="@+id/radioRed"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Red" />

        <RadioButton
            android:id="@+id/radioGreen"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Green" />

        <RadioButton
            android:id="@+id/radioBlue"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Blue" />

        <RadioButton
            android:id="@+id/radioSpinner"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Spinner" />
    </RadioGroup>
```

### 5. ProgressBar
```Java
<ProgressBar
        android:id="@+id/progressBar"
        style="?android:attr/progressBarStyle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="8dp"
        app:layout_constraintLeft_toLeftOf="parent"
        android:layout_marginTop="8dp"
        app:layout_constraintTop_toBottomOf="@+id/radioGroup" />
```

### 6. Switch
```Java
<Switch
        android:id="@+id/mSwitch"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="0dp"
        android:layout_marginLeft="8dp"
        android:text="Switch"
        app:layout_constraintBottom_toBottomOf="@+id/progressBar"
        app:layout_constraintLeft_toRightOf="@+id/progressBar" />
```

### 6. SeekBar
```Java
<SeekBar
        android:id="@+id/seekBar"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        app:layout_constraintTop_toBottomOf="@+id/progressBar"
        android:layout_marginLeft="8dp"
        app:layout_constraintLeft_toLeftOf="parent"
        android:layout_marginRight="8dp"
        app:layout_constraintRight_toRightOf="parent" />
```

### 7. RatingBar
```Java
<RatingBar
        android:id="@+id/ratingBar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        app:layout_constraintTop_toBottomOf="@+id/seekBar"
        android:layout_marginLeft="8dp"
        app:layout_constraintLeft_toLeftOf="parent" />
```
