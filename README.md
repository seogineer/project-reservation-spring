# project-reservation-spring

사용 기술 및 도구 : HTML, CSS, JSP, JSTL, Javascript, jQuery, Java 8, Spring Framework 4.3.5, mariaDB 10.5, Git, Eclipse

## 1. Main 화면
![main](https://user-images.githubusercontent.com/19875940/106590008-02b45200-6590-11eb-844b-aa8a89bbeebd.PNG)

기능 및 특징
1. 상단 프로모션 이미지들이 슬라이드 되어서 일정 시간 마다 오른쪽에 왼쪽으로 넘어갑니다.
2. Ajax 비동기 통신으로 화면 전체가 새로고침되지 않고 카테고리 별로 행사 개수를 표시하도록 구현했습니다.
3. 스프링에서 페이징 처리를 하여 하단 더보기를 누르면 4개씩 추가로 읽어옵니다.

<br>

## 2. 상세 화면
![detail1](https://user-images.githubusercontent.com/19875940/106590606-a271e000-6590-11eb-86df-ce624795a14f.PNG)<br>
![detail2](https://user-images.githubusercontent.com/19875940/106590610-a3a30d00-6590-11eb-9216-45f9e550f496.PNG)<br>
![detail3](https://user-images.githubusercontent.com/19875940/106590613-a43ba380-6590-11eb-93f9-b07bc0e5898f.PNG)<br>

기능 및 특징
1. 행사에 대한 설명을 접었다 펼 수 있습니다.
2. 이용자들의 후기, 후기 건수 그리고 평점을 표시합니다.

<br>

## 3. 로그인 화면
![login](https://user-images.githubusercontent.com/19875940/106590818-dcdb7d00-6590-11eb-895b-ce180e39232d.PNG)<br>
<br>
![login2](https://user-images.githubusercontent.com/19875940/106590823-de0caa00-6590-11eb-9bdb-d1ead30bf158.PNG)<br>

기능 및 특징
1. DB에서 예약자 이메일 주소를 이용해서 예약 목록을 조회합니다.
2. 예약한 사용자의 이메일인 경우 session에 저장되어 상단 화면이 예약확인 글자가 이메일로 바뀝니다.

<br>

## 4. 예약 화면
![reservation1](https://user-images.githubusercontent.com/19875940/106590934-01cff000-6591-11eb-956f-2cf4908f4ddf.PNG)<br>
![reservation2](https://user-images.githubusercontent.com/19875940/106590941-03011d00-6591-11eb-8849-8464721fe2d9.PNG)<br>
![reservation3](https://user-images.githubusercontent.com/19875940/106590942-03011d00-6591-11eb-8acb-26db324351c0.PNG)<br>

기능 및 특징
1. +/- 버튼을 눌러서 표 개수를 동적으로 조정할 수 있습니다.
2. 약관 동의 체크를 하면 예약하기 버튼이 활성화됩니다.

<br>

## 5. 예약 조회 화면
![reservation_list2](https://user-images.githubusercontent.com/19875940/106591231-612e0000-6591-11eb-89bf-0fe7d01735fd.PNG)<br>
![reservation_list3](https://user-images.githubusercontent.com/19875940/106591234-61c69680-6591-11eb-9c69-da15fae20a52.PNG)<br>
![reservation_list1](https://user-images.githubusercontent.com/19875940/106591237-625f2d00-6591-11eb-8e95-ae20103772b5.PNG)<br>

기능 및 특징
1. DB에서 예약 내역을 조회합니다.
2. 취소 버튼을 누르면 예약을 취소할 수 있고 목록에서 취소로 변경됩니다.
3. 이용완료 버튼을 누르면 후기 작성 화면으로 이동하고 목록에서 이용 완료로 변경됩니다.

<br>

## 6. 후기 조회 화면
![comment2](https://user-images.githubusercontent.com/19875940/106597650-09e05d80-659a-11eb-9187-d667dc752c18.PNG)<br>
![comment3](https://user-images.githubusercontent.com/19875940/106597646-08af3080-659a-11eb-81f8-c8e54f6bca49.PNG)<br>

기능 및 특징
1. 후기, 후기 건수 그리고 평점을 조회합니다.
2. 첨부한 이미지를 표시합니다.

<br>

## 7. 후기 입력 화면
![review1](https://user-images.githubusercontent.com/19875940/106591412-9a667000-6591-11eb-90ec-50dbeb4b0c5b.PNG)<br>

기능 및 특징
1. 평점에 따라 별이 색칠됩니다.
2. 입력 글자수를 입력받을 때마다 검증합니다.
3. png, jpg 파일을 첨부하고 미리보기 이미지를 표시합니다.
