◎ 월요일 ~ 금요일

    - IDP 구축(SSO)
        * SSO란?
          - SSO(Single sign on)란 한번의 로그인으로 여러가지    서비스들에 인증절차의 중복 없이 들어갈 수 있게 해주는 서비스이다.
          사용자가 단 한 번의 인증 절차만으로 다수의 애플리케이션에 접속할 수 있도록 해주는 인증 프로세스를 의미한다.
![image](https://user-images.githubusercontent.com/37497189/56902999-67e33580-6ad6-11e9-99a3-eab6394e3609.png)

          - SSO를 구축하는 의미는 추가적인 인증을 요구받지 않아 사용자의 편의를 증대시키기 위함이다.
          이로 인해 App마다 인증절차를 거치지 않으므로 다수의 패스워드를 별도로 관리할 피요가 없어져 보안이 강화된다.
        * IDP란?
          - IDP(Identity Provider)는 사용자 인증 대행 및 인증된 사용자의 이름, 역할 등을 담은 SAML 토큰을 발행하는 역할을 담당하는 서버이다. 
          현재 나와있는 IDP Server용 프로그램들은 많은데 그중 대중적이고 편한것이 WSO2와 Shibolleth등이 있다. 그중 인수 인계 자료에도 나와있는 WSO2를 이용해서 진행을 해보려 한다.

        * SAMML이란?
          - 보안 도메인 간에 인증과 권한이 있는 데이터 교환을 위해 만들어진 표준 프로토콜이다. xml파일을 이용하여 데이터를 전달하는 방식이다.

        * SP란?
          - 사용자가 접근하려는 서비스 또는 어플리케이션이다.
          진행해보려는 테스트에서는 cloudera manager랑 hue등이 해당된다.

        * SAML이란?
          - 같은 네트워크 내의 인증과 권한에 관한 데이터를 서로 교환하기 위한 xml 기반의 표준 프로토콜이다.
          xml안의 내용은 Profiles, Bindings, Protocols, Assertion 으로 나누어져 있다. 여기서는 Metadata를 xml로 만들어서 이 데이터를 가지고 사용자를 인증하는 방식을 사용한다.


<img width="473" alt="SSO" src="https://user-images.githubusercontent.com/37497189/56875037-16588d80-6a79-11e9-9014-b7b4e3017d3c.png">


<img width="415" alt="SSO" src="https://user-images.githubusercontent.com/37497189/56875064-43a53b80-6a79-11e9-8dae-be50b1f35bfa.png">


          아래는 IDP 제공 목록
            1. Shibboleth (On-premise & Open Source)

            2. miniOrange (클라우드 및 온 - 프레미스)

            3. Okta (클라우드)

            4. OneLogin (클라우드)

            5. ADFS (온 - 프레미스)

            6. 비트 륨 (클라우드)

            7. SimpleSAMLPHP (온 프레미스 및 오픈 소스)

            8. KeyCloak (온 프레미스 및 오픈 소스)

            9. WSO2 (온 프레미스 및 오픈 소스)

            10. PingIdentity (온 - 프레미스)
          

          여기서 사용할 목록은 WSO2랑 Shibboleth이다. 둘다 오픈소스로 무료이고 다루기 쉽다는 설명이 다수였다.
          인수인계 사항으로도 WSO2가 올려져 있어서 먼저 구축을 진행하게 되었다.






        * 구축모델
          - 서버는 WSO2에서 제공하는 WSO2 Identity Server를 이용하기로 하였다. 거기에 Metadata를 저장하는 저장소로는 WSO2에서는 identity Server를 제외한 제품들에는 H2라는 저장소가 있지만 identity Server에는 제공을 안하기 때문에 mysql을 연결해서 진행하려 한다.
          mysql말고도 AD(Active Directory), ldap서버를 이용하여서 구축을 진행하여도 된다. 거기에 로그인 웹 UI제공자는 travelocity라는 앱을 이용하기로 하였다.
          그다음 예제에서는 WSO2 API Manager라는 것을 SP로 만들어서 identity서버와 API Manager간의 SSO를 테스트 해보는 과정을 진행하기로 하였다. 거기에 더해서 SP로 구글도 추가를 하여서 구글과 API Manager, Identity Server간의 SSO를 구축하는게 WSO2에서 제공하는 training 과정이다. 우선 이 테스트들을 진행 한 뒤에 cloudera와  hue에서도 적용을 시켜 보려 한다. 전체적인 큰 그림은 client가 SP에 로그인을 하고 싶어서 요청을 보내면 trevelocity라는 로그인 웹페이지를 통하여 로그인을 하게된다. IDP server인 WSO identity server로 그 정보가 넘어가게 되고 이 정보를 가지고 메타스토에 해당 인증이 있는지 비교후에 있다면 인증을 통과시키고 다시 IDP서버로 전달후 SP로 전달해 로그인을 하게 되는 로직이다. 이후에 다른 SP로 접속을 하게되면 이미 인증을 받았기 때문에 불필요한 인증 과정없이 바로 로그인이 된다.
<img width="517" alt="SSO" src="https://user-images.githubusercontent.com/37497189/56874867-cb8a4600-6a77-11e9-9ea8-f0e91f8280ea.png">


- 구상도  
<img width="479" alt="SSO" src="https://user-images.githubusercontent.com/37497189/56875088-6172a080-6a79-11e9-8559-3898107074f0.png">

- 흐름도  
<img width="521" alt="SSO" src="https://user-images.githubusercontent.com/37497189/56875120-954dc600-6a79-11e9-9e9f-e136bae2e1d2.png">



    - 현재까지 진행된 상황

    진행된 상황은 Identity Server를 로컬에 깔아서 개인 로컬을 Identity서버로 만들었다. 여기까진 순조로웠으나 저장소를 구축하는게 문제였다. mysql을 로컬에 깐뒤에 mysql을 메타데이터 저장소로 만들려 하였으나 에러가 계속 나는 상황이다. AD를 연동해서 해보려고 해도 현재 구축이 되어있는 AD가 고장이나면 안되기 때문에 AD를 가지고는 실험을 할 수 가 없었다. mysql을 적용하기 위해선 xml파일들을 고쳐야 하는데 이 작업중 조금만 잘못 고쳐도 에러가 나서 진행이 안되던 상황이었다. 메타데이터를 저장할 공간이 없기 때문에 서버는 구축되어 있지만 Identity server를 운영하는데 error사항이 많아서 해결을 진행하는 중이다. ID 제공자로 Shibolleth를 붙여보려 하였지만 erorr가 나서 install이 제대로 안되고 있는 중이다. 