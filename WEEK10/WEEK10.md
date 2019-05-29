◎ SSO구축

    - 지난주에 이어서 계속 SSO구축을 진행하고 있다. CM 페이지 까지는 SSO로그인 페이지를 띄우는데는 성공했으나 Hue페이지를 SSO로 연결하려고 하는데 문제가 생겼다.
    해당 문제는 HUE의 metadata xml을 받지 못해서인데 이를 받기 위해서 cloudera가 saml방식으로 인증을 처리하도록 만들어야 한다. 공식 홈페이지의 내용을 토대로 해당 과정을 진행하였으나 바꾸고나서 metadata를 받으려고 url을 치면은 로그인 페이지가 리다이렉팅되면서 해당 화면이 계속 새로고침이 반복되는 현상이 일어났다. saml을 설정하지 않고 로그인을 한 뒤 metadata를 받기 위한 url주소 http://(해당 ip:포트)/saml2/metadata를 입력하고 enter를 치게되면 metadata.xml이 다운 받아지는게 아니라 hue의 impala페이지로 연결되는것을 볼 수 있었다. 그 다음 saml을 설정한 뒤 다시 치게 되면은 Hue 로그인 페이지로 연결이 되어서 해당 페이지가 무한반복되는 현상이 발생하는 것을 발견하였다. 어떤 문제인지 파악을 하기위해 여러가지를 살펴보았는데 Hue 페이지에 접속을 하게되면 상단에 error메세지가 뜨는것을 발견할 수 있었다. 그 eroor를 검색해보니 impala deamon port가 문제인걸 확인할 수 있었다.

     error 내용은 Impala cannot read or execute the parent directory of dfs.domain.socket.path가 뜨는 문제였다.

     CM에 들어가서 확인을 해보니 총 세개의 impala deamon이 올라가있지만 한개가 다운이 된 것을 발견할 수 있었다. 이에 해결법을 찾아보니 해당 impala deamon이 실행될때 사용되는 hdfs-socket이 없어서 일어나는 문제라는 것을 알 수 있었다. 해당 solution을 적용해보니 문제가 해결되었다. 문제 해결법은 /var/run/hdfs-sockets라는 파일을 만들어 주고난 뒤에 이를 hdfs로 유저와 그룹의 권한을 바꿔주면 해결이 되었다. 이 문제를 해결하고나서 다시 saml을 설정한 뒤에 다시 Hue로 접속을 해보았으나 동일한 문제가 계속 지속되는 것을 보고 impala오류문제가 아니라 좀더 근본적인 문제가 있음을 알 수 있었다. 그 다음으로 본 문제는 SSO를 하기위해선 CM이나 HUE의 인증방식을 saml로 바꿔줘야 된다고 앞서 설명하였는데 CM에서는 해당 내용을 따라가다보면 metadata.xml을 받는것은 매우 간단하였다. HUE에서 saml을 적용하려고 공식 홈페이지에 나와있는 과정을 그대로 따라해 보았지만 문제가 계속 발생하였다. 내용에서는 HUE를 saml로 설정하기 위해선 cluster에서 hue 를 간뒤 구성 페이지에서 hue_safety_valve.ini에 대한 Hue 서비스 고급 구성 스니펫(안전 밸브) 라는 부분을 수정해 주면 된다고 나와있다. 우선 설정 이전에 각 호스트들에게 아래의 명령어로 pysaml2과 djangosaml2을 미리 설치를 해 주고

        build/env/bin/pip install -e git+https://github.com/abec/pysaml2@HEAD#egg=pysaml2

        build/env/bin/pip install -e git+https://github.com/abec/djangosaml2@HEAD#egg=djangosaml2

    openssl을 아래의 명령어를 통해 다운

        yum install git gcc python-devel swig openssl

    xmlsec1을 아래의 명령어로 다운을 받는다.
        
        yum install xmlsec1 xmlsec1-openssl
    
    그다음 아래의 명령어로 키파일과 인증서, idp의 메타데이터를 저장할 디렉토리를 만들어준다.
        mkdir -pm 755 /opt/cloudera/security/saml/
        cd /opt/cloudera/security/saml/

    여기에 key파일과 pem파일, cert파일과 metadata.xml을 넣어주고는
    hue_safety_valve.ini에 대한 Hue 서비스 고급 구성 스니펫(안전 밸브)에서 
        [desktop]
        redirect_whitelist="^\/.*$,^http:\/\/  clr.sec.cloudera.com:8080\/.*$"
        [[auth]]
        backend=libsaml.backend.SAML2Backend
        [libsaml]
        xmlsec_binary=/usr/bin/xmlsec1
        metadata_file=/opt/cloudera/security/saml/idp-openam-metadata.xml
        key_file=/opt/cloudera/security/saml/host.key
        cert_file=/opt/cloudera/security/saml/host.pem
        username_source=nameid
        name_id_format="urn:oasis:names:tc:SAML:2.0:nameid-format:transient"
        entity_id=<host base name>
        logout_enabled=false
        
    위와 같은 구성으로 해당 값들을 설정해 준다.
    그러면 해당 값들이 hue web ui에서 바뀐 것을 확인이 가능하다.
<img width="961" alt="hue ini구성" src="https://user-images.githubusercontent.com/37497189/57675088-e48c1d00-765b-11e9-8215-2e570ed4801d.PNG">

    확인 방법은 hue web ui에 접속후 오른쪽 상단의 계정을 클릭 후 hue 관리 카테고리를 클릭하고난뒤 중앙의 구성 버튼을 누르고 해당 인자값을 누르면 확인이 가능하다.
    위의 과정을 끝내고난 뒤 http://<hue server ip:port>/saml2/metadata를 검색하면 원래는 가능하지만





◎ Kerberos된 cluster에서 Oozie등 웹 UI에 접속하기

    - 문제점
        Kerbersizing이 된 클러스터, 정확히는 kerverose를 쓰는 웹 UI에 접속하려고 하면 로그인과 비밀번호를 입력하라는 창이 뜬다.
        
        
        처음에는 SSO를 구축하느라 로그인과 비밀번호입력창을 잘못 띄운건줄 알았는데 각 서비스들의 구성 페이지에서 kerberos를 이용한 web페이지 인증사용을 체크를 하면 그 창이 뜨고 해제하면 안뜨는것을 확인하고는 kerberos의 문제인 것을 알게 되었다. 
        
        
        현재 이 로그인 창의 아이디와 비밀번호를 모르는 상태이고 이 로그인 인증이 어떤 계정과 권한에 대한 인증인지를 모르는 상태라 알아보고 있는 중이다. 

