IDP - SSO구축 현황



---------------------------------------------------------------------------------------------
서버 : WSO identity- server

ID Provider : Shibboleth

로그인 UI제공 : travelo city -> 다른 앱을 이용해도 되지만 유료인 것이 많음 

SP : Cloudera Managere, Hue

Metadata-store : H2(API Manager에서 기본저공, WSO identity-server에서는 제공x)->mysql로 바꾸거나 AD연동해서 진행해도 됨
----------------------------------------------------------------------------------------------

SSO를 구성하기 위해선 WSO2 Identity Server를 구축해야 한다. 이는 현재 오준석 사원의 자리에 구축한 것을 이용하고 있다. 서버자체는 여러 곳에 구축이 가능하지만 한 곳에서 관리를 하는게 나중에
혼선이 나는 것을 방지 할 수 있을것 같아서 여러 곳에서 안하고 한 서버에서 cm, hue등을 연결하는것을 실험하는 중이다.

<img width="942" alt="WSO2_main" src="https://user-images.githubusercontent.com/37497189/57257761-54673a00-7095-11e9-90cf-98db52a5967d.PNG">

위의 사진은 WSO2의 메인 화면이다. 기본 로그인은 ID : admin, Password : aadmin

<img width="935" alt="WSO2_main2" src="https://user-images.githubusercontent.com/37497189/57257924-d2c3dc00-7095-11e9-9d93-b59d387895a4.PNG">

로그인을 하고나면 보여지는 페이지이다. 이 페이지에서 각종 서비스들을 이용할 수 있다.

왼쪽에 보이는 카탈로그들이 이용가능한 목록들이다.

맨처음 보이는 User and Roles는 WSO2의 사용자들을 관리하는 페이지이다. 여기에서 로그인할 수 있는

사용자들의 목록을 관리할 수 있고 각각의 권한또한 조정이 가능하다.

<img width="603" alt="WSO2_User" src="https://user-images.githubusercontent.com/37497189/57258120-672e3e80-7096-11e9-861d-74a4a8f6d15e.PNG">

위의 사진은 User and Roles의 add를 누른 사진.

<img width="467" alt="WSO2_User2" src="https://user-images.githubusercontent.com/37497189/57258222-c429f480-7096-11e9-8202-8aa7af0e621c.PNG">

위의 사진과 같이 새로운 User를 등록 할 수 있다.

여기서 우리가 해 줘야 할것은 WSO2를 IDP서버로 만들었으니 여기에 SP로 Cloudera Maager를 추가해 줘야 된다.

<img width="710" alt="WSO2_SP" src="https://user-images.githubusercontent.com/37497189/57258352-24209b00-7097-11e9-956d-7d60674e8899.PNG">

위와 같이 Service Provider 의 add버튼을 눌러 새로운 SP를 추가 할 수 있다. 맨 위에는 SP의 이름을 적은뒤
그 밑은 설명을 적을 수 있고 다음은 어플리케이션 인증서를 넣어 줘야된다. 이 인증서를 보고 IDP서버는 신뢰할 수 있다고 판단을 하여 서비스가 이루어지게 된다. 이 인증서를 만드는 방법은 아래에서 설명을 할 것이다.

<img width="740" alt="WSO2_SP2" src="https://user-images.githubusercontent.com/37497189/57258613-e53f1500-7097-11e9-83c7-18f3ae99456a.PNG">

다음은 옵션들이다. 위의 인증서 까지 추가하고 나면은 밑에서 세부사항들을 정의해 줄 수가 있다.

<img width="684" alt="WSO2_SP3" src="https://user-images.githubusercontent.com/37497189/57258732-33ecaf00-7098-11e9-93d0-fd75d841844a.PNG">

위의 사진은 SP페이지에 적용이 될 Role과 Permission을 지정할 수 있는 페이지이다. 적용을 시키기 위해선 미리 Role and Permission페이지에서 만든 것을 가져오는 방식을 사용해야 된다.

<img width="733" alt="WSO2_SP4" src="https://user-images.githubusercontent.com/37497189/57258861-a493cb80-7098-11e9-807b-bb30db57ef98.PNG">

다음은 Inbound Authentication Configuration페이지에 대한 설명이다.
이 페이지에서는 SP에대한 SAML2 Web configuration에 관한 것을 정의해 줄 수 있다. 그 밖에도 OAuth/OpenID connet Configuration, Kerberos KDC등을 정의 할 수 있지만 지금 쓸 것은 SAML방식이기 때문에 먼저  SAML2의 페이지를 수정하여 볼 것이다.

<img width="738" alt="WSO2_SP5" src="https://user-images.githubusercontent.com/37497189/57259093-621ebe80-7099-11e9-9c96-e87d6e1871c7.PNG">

위의 사진은 SAML2 Web configuration의 추가 버튼을 누르면 보이는 페이지이다.
여기에서 SP가 SAML을 이용하여 연결하는 URL을 추가 할 수 있다. 이는 CM에서 설정을 해 주어야 한다.
기존의 CM은 SAML방식이 아니다. SAML방식은 XML을 이용하여 데이터를 주고받은 방식을 말하는데 이를 이용하여 인증서등을 전송해서 인증을 받는 방식을 여기선 적용시켜 주어야 한다. CM페이지로 이동하여 외부 인증페이지에서 이를 설정을 해 줄 수가 있는데 현재 토파즈에서는 AD를 이용하여 인증을 하고 있다. SSO를 이용하기 위해선 무조건 SAML을 이용해야 하는것은 아니나, 간단히 테스트를 진행하기 위해서는 SAML방식을 이용하여 진행하는게 제일 빠르다고 판단하였다.

이를 수정하는 방법은 
    1) CM의 구성페이지로 이동

    2) 왼쪽의 목록에서 외부 인증을 클릭

    3) 외부인증 방식을 SAML방식으로 변경

    4) 그 밑의 세부 사항들을 정의

위의 과정을 진행한 뒤에 WSO2의 페이지로 돌아와 앞서 설정해 주었던 것들을 적용시켜 주면 된다.

현황 
1. 예제 구글 연동은 끝난상태 cloudera magager를 sp로 추가하는게 관건 ->방법을 찾고있는중

2. WSO2를 이용해서 cloudera Manager를 sso페이지로 연결성공

3. 연결 페이지에서 로그인시 cm으로 가지게 

4. Hue를 연결하기 위해선 키 저장소를 구축해야 할 필요가 있음

5. 키 저장소 구축은 기존의 기를 가지고 인증을 받는 방법을 채택(새로운 인증을 받을 수도 있음)

    - 방법 -
        1) Export the .der file

ㅍ        keytool -export -alias sample -file sample.der -keystore my.jks

        2) Convert the .der file to unencrypted PEM (crt file)

        openssl x509 -inform der -in sample.der -out sample.crt

        3) Export the .p12 file

        keytool -importkeystore -srckeystore my.jks -destkeystore keystore.p12 -deststoretype PKCS12

        4) Convert the .p12 file to unencrypted PEM (key file)

        openssl pkcs12 -in keystore.p12 -nodes -nocerts -out server.key

해결해야될 문제

sso로 cm뿐만아니라 hue페이지랑도 연계해서 로그인 한번으로 다 들어가지게 만들기

role을 적용시켜서 접속하는 아이디에 맞게 페이지가 보여지는게 다르게 만들기


