## Permission

### Runtime Permission (API 23 '마쉬멜로우' 이상)

- 안드로이드는 마시멜로우(6.0) Api Level 23 이상 부터는 사용자가 접근 권한이 필요한 기능을 수행할때, 사용자로 하여금 해당 권한을 앱에 허락 할 것인지 묻고, 개발자가 아닌 사용자가 자신의 디바이스의 접근 권한을 결정하는 형태로 권한설정 구조를 변경했다

## 권한 획득처리

#### 1. 권한 획득하기 전 권한 유효성 체크

- checkSelfPermission(String) != PackageManager.PERMISSION_GRANTED
현재 앱이 특정 권한을 갖고 있는지 확인 가능

#### 2. 설명이 필요한 경우 처리

- shouldShowRequestPermissionRationale(String) <br>
권한 획득이 필요한 이유를 설명해야 한다면 다음 옵션을 추가하여 별도 처리가 가능. 사용자가 이전에 권한 요청을 거부한 경우에 true반환. 이 경우, 권한 요청을 위한 대화창에는 '다시 묻지 않기' 체크박스와 함께 표시된다. 사용자가 이를 선택하면 이후에 앱이 requestPermissions 메서드를 호출해도 권한 요청 대화창이 표시되지 않고, 바로 사용자가 해당 권한을 거부할 때와 동일 하게 콜백 함수가 호출된다.

#### 3. 권한 획득을 위한 API

- shouldShowRequestPermissionRationale(String) <br>
권한 획득이 필요한 이유를 설명해야 한다면 다음 옵션을 추가하여 별도 처리가 가능. 사용자가 이전에 권한 요청을 거부한 경우에 true반환. 이 경우, 권한 요청을 위한 대화창에는 '다시 묻지 않기' 체크박스와 함께 표시된다. 사용자가 이를 선택하면 이후에 앱이 requestPermissions 메서드를 호출해도 권한 요청 대화창이 표시되지 않고, 바로 사용자가 해당 권한을 거부할 때와 동일 하게 콜백 함수가 호출된다.

#### 4. 결과처리 - onRequestPermissionResult(int, String[], int[])

- 권한 획득에 대한 성공/실패에 대한 정보를 담은 callback. 다음 함수 내에서 배열로 전달되므로 필요한 퍼미션이 잘 받아졌는지 확인하여 이후 처리가 가능.
