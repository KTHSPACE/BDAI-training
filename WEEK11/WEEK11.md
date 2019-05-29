◎ Kerberos된 cluster에서 Oozie등 웹 UI에 접속하기

    - 해결해야될 문제
        
        현재 kerberos가 적용된 웹 UI에서 접속이 안되는 현상이 일어나고 있음.

    - 진행상황

        현재 진행상화은 KERBEROS의 문제인지 WEB UI의 구성이 문제인지를 정확히 파악하기 위하여 WEB UI를 KERBEROS사용 안함으로 바꾸고 적용을 해 보았는데 적용을 풀었을 때는 잘 들어가지는 것을 확인.
        따라서 이 문제는 KERBEROS의 문제가 맞다는 것은 인지.
<img width="286" alt="web_console" src="https://user-images.githubusercontent.com/37497189/58397484-253c5b00-808c-11e9-92c3-01a0ff4d6093.PNG">
        예상으로는 KERBEROS가 적용이 되면서  web UI의 인증이 되질 않아 나타나는 현상으로 보임. 이 현상을 해결하기 위해서는 KDC나 Active Directory의 설정을 바꿔줘야 될 수도 있음.

    - 결과
    
    결론은 해결을 못하여서 pm에게 물어본다고 하였다.
        

◎ SSO 구축
    - 해결해야될 문제
        1. Hue의 인증 방식이 saml 형식으로 적용이 됐는지를 확인하는 것 v
       
        2. Hue의 메타 데이터를 받는것(xml형식) v

        3. metadata를 IDP Server로 전달 v

        4.IDP와 SP(Hue Web UI)를 연결 v

        5. Hue Web UI 로그인페이지가 해당 IDP에서 제공하는 통합 인증 페이지로 연결됐는지 확인 v

        6. 로그인페이지에서 로그인 인증이 정상적으로 작동되는지 확인 v

        7. 각 사용자들에 맞게 role이 적용이 되는지 확인 v

    - 진행상황
        
        현재 진행상황은 토파즈에서 WSO2를 이용하여 SSO를 구축해야되는데 목요일까지 진행상황은 sml방식을 hue에 적용을 시켜서 hue의 메타데이터를 받아오는 것이 주요 목표였다.
        하지만 Document에 나와 있는대로 진행을 해 봤지만 적용이 안됐는지 메타데이터를 받을 수 없는 상황이었다.
        대략적으로 방식을 설명하자면 모든 노드들에 인증키를 받고 넘기기 위한 openssl과 openssl-xmlsec1, xmlsec1을 깔아줘야 된다. openssl은 키와 인정서를 만들때 사용되는 툴이고, openssl-xmlsec1은 openssl로 만들어진 키를 읽기위한 툴이다. xmlsec 라이브러리에 대한 OpenSSL 기반 암호화 서비스를 제공한다. 그리고 xmlsec1은 xmlsec xml security library 이다.
![image](https://user-images.githubusercontent.com/37497189/58541217-f7931580-8235-11e9-8079-1063edd85bbf.png)
        다음은 ㅇ키와 인증서를 만들어야 하는데 ADFS를 이용하려면 ADFS에서 제공하는 키와 인증서를 가지고 사용하면 되지만 WSO2에서 환경을 구축하려면 새로 key와 인증서를 만들어야 한다. key와 인증서는 openssl로 만들 수 있다. openssl말고 keytool을 이용하여서 만들 수도 있는데 해당 방식은 여기서 다루지는 않는다.
![image](https://user-images.githubusercontent.com/37497189/58541419-70926d00-8236-11e9-8b60-47bf45021dbc.png)
        키를 만들고 인증서를 만들었다면 다음은 hue의 구성을 바꾸어 주는 것이다. hue의 구성을 바꾸는 방법은 cm에서 hue 서비스를 누른다음 구성 페이지를 가고 hue_safety_value_ini에 대한 서비스 고급 구성 스니펫 부분을 작성하여 준다.
![image](https://user-images.githubusercontent.com/37497189/58541593-cc5cf600-8236-11e9-80e8-7b87d8bcd566.png)
        해당 인자들에 대한 설명은 다음과 같다.
![image](https://user-images.githubusercontent.com/37497189/58541634-e4347a00-8236-11e9-9943-c706751b4af7.png)
        다음 구성이 끝나면 hue의 웹 UI페이지로 가서 구성이 잘 되었나를 볼 수 있다.
![image](https://user-images.githubusercontent.com/37497189/58541720-0f1ece00-8237-11e9-8fd5-b2ede10e9cce.png)
        다음은 hue의 saml 구성이 적용된 metadata.xml을 받아야 한다. 해당 메타데이터를 받으려면 http://(해당 hue 서비스가 깔린 노드)/saml2/metadata 로 가면 받을 수 있다.
        설정이 제대로 안되었다면 해당 메타데이터를 받을 수 없을 것이다.
![image](https://user-images.githubusercontent.com/37497189/58541866-658c0c80-8237-11e9-96be-68bb5917c033.png)
        Hue의 메타데이터를 받았다면 이제 WSO2 identity Server로 가서 SP를 추가해 주면 된다.
![image](https://user-images.githubusercontent.com/37497189/58541968-91a78d80-8237-11e9-97f6-2b3e46e00b5a.png)
        추가 버튼을 눌러주면 인증서를 넣을 수 있는 창이 나온다. 해당 란에 위에서 만든 인증서를 넣어주거나 그 파일을 넣어주면 된다.
![image](https://user-images.githubusercontent.com/37497189/58542051-c3205900-8237-11e9-896b-587f23c51997.png)
        그 다음은 Hue의 메타데이터를 넣어주면 된다. claim을 적용하는데는 3가지의 방식이 있는데 메타데이터를 받을 수 있는 url을 적용시키는 방법과 직접 메타데이터를 받아서 넣는 방법, 구성 하나하나를 사용자가 정의해줘서 만드는 방법이 있다. 앞서 우리는 메타데이터를 받았기 때문에 두번째 방법을 쓰면 된다.
![image](https://user-images.githubusercontent.com/37497189/58542170-04b10400-8238-11e9-8b23-ad4c8b7ee92c.png)
        이렇게 메타데이터를 넣어주게 되면 설정이 끝이난다. 제대로 적용이 되었다면 WSO2에서 제공해주는 로그인 페이지를 볼 수가 있다.
![image](https://user-images.githubusercontent.com/37497189/58542234-290ce080-8238-11e9-8945-9f51a0416a50.png)

![image](https://user-images.githubusercontent.com/37497189/58542272-3b871a00-8238-11e9-99ed-8ee6abee6c75.png)

![image](https://user-images.githubusercontent.com/37497189/58542301-4f328080-8238-11e9-8db3-6a3cd154c0d2.png)

        위의 설명중 saml이 적용이 잘 안되어서 메타데이터를 받을 수 없을때 무슨 에러인지를 확인하고 500에러가 뜬다면 다음 작업을 진행하면 된다.
![image](https://user-images.githubusercontent.com/37497189/58542375-76894d80-8238-11e9-8140-50437b84bcc3.png)



◎ 다음주 해결해야 될 문제
    
    1. WSO2로 CM과 Hue를 SSO로 구축, 연결하고 사용자들의 그룹 설정에 따라 각각의 role들이 적용이 되게 만들어야 된다.
    
    2. 회사 부서 이전에 따라 네트워크와 장비들의 구성을 숙지해야 된다.
