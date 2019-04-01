◎ 월요일
    * 동영상 강의
        - 
        - 
    * oozie 
    
        - oozie는 workflow와 coordinator, bundle기능을 제공한다.
        - workflow
            workflow기능은 말 그대로 workflow를 관리하는 역할이다.
            hadoop에서 각각의 프레임 워크들이 동작을 하는것을 action이라고 하는데
            이러한 action들의 동작 순서와 흐름을 제어해 준다.
        - coordinator
            coordinator기능은 workflow 작업을 시간대에 맞춰서 자동으로 실행시켜주는 기능이다. 원하는 시간대에 얼마나 작업을 진행시킬지를 설정해 줄수 있고 그에 따라서 workflow가 진행되게 된다.
        - bundle
            bundle기능은 coordinator의 집합이다. 여러 coordinator들을 효율적으로 관리를 할 수 있다.
◎ 화요일
    * HUE를 이용해 Oozie로 HIVE, PIG 돌려보기
        -  workflow
            HUE를 이용해 Oozie로 HIVE작업과 PIG작업을 총 네단계로 나누어서 workflow를 만들어 주었다.
            Oozie를 동작시키는 방법은 CLI를 이용하는 방법과 Hue Web UI를 이용하여 실행시키는 방법이 있다.
            CLI를 이용해서 실행을 하게 되면 job.property와 workflow.xml을 직접 작성해 주어야 된다. 작성된 workflow.xml을 보고서 Oozie는 workflow를 진행하게 된다. 
            Hue Web UI를 통해 진행할 경우에는 실행할 작업을 끌어와서 넣어주기만 하면 workflow.xml과 job.property를 자동으로 만들어 준다는 장점이 있다.
            하나의 HIVE job을 돌리기 위해서는 hive-site.xml이 필요하다. HIVE나 PIG job을 돌리기 위해서는 작업을 진행시킬 xml파일을 미리 만들어 놓아야 된다.
            실행 해볼 예제에서는 총 3개의 HIVE작업과 1번의 PIG작업이 있다.
            우선 DROPHIVETABLE.xml파일에 대해 설명하자면 미리 만들어져있는 CLEANSED_TABLE과 SUMMARY_TABLE을 지워주는 작업이다. <br>
            <img width="209" alt="캡처3day_5" src="https://user-images.githubusercontent.com/37497189/55126779-70e88c00-5151-11e9-949f-9ebce18d370c.PNG"><br>
            이것들을 왜 지우냐면 PIG를 진행하면 쿼리문으로 앞서 나온 두개의 테이블을 만들어 주게 된다. 그러나 이미 그 테이블이 있다면 오류메세지를 보내게되고 작업은 멈추게 된다. 이를 방지하기 위해서 미리 만들어져있던 두개의 테이블을 지워주고 PIG를 돌릴때 다시 만드는 작업을 거치게 하기 위해서 DROP TABLE을 해주는 것이다.<br> 
            그다음은 PIG 작업이다. PIG작업은 CleamseData.txt를 이용하여 진행한다. CleanData는 log.txt파일에서 필요없는 정보들을 지우고 원하는 정보만 남겨두는 작업이다. <br>
            ![image](https://user-images.githubusercontent.com/37497189/55293588-f3fc3180-5432-11e9-8c7b-307f51f8d090.png)
<br>
           다음은 CreateHiveTables.txt작업이다. 이는 HIVE 작업인데 cleandata로 원하는 데이터만 추출된 상태를 가지고 넣을 테이블을 만들어 놓는 작업이다. <br>
           ![image](https://user-images.githubusercontent.com/37497189/55297628-0beba980-5463-11e9-8356-fa3cbb96bbc4.png)
<br>
           그 다음 작업은 만들어진 테이블에다가 원하는 데이터들을 넣는 작업이다. 이는 HIVE로 작업을 진행하게 되고 동일하게 HUE 웹 UI에다가 끌어다가 쓰면된다.<br>
           ![image](https://user-images.githubusercontent.com/37497189/55297649-50774500-5463-11e9-9725-b756d8f306f3.png)
<br>
           작업을 진행하는 txt 파일 이름은 SummarizeData.txt이다.
           HUE를 이용한 작업은 엄청난 효율을 보여주었는데 그 이유는 원하는 작업을 할때 위에서 끌어다가 박스안에 넣고 작업 하고자 하는 파일을 넣어준다음에 실행만 하면 끝이라는 것이다. 작업에 매개변수가 들어간다면 그 매개변수들을 적어주어야 한다. 매개변수를 가지고 작업의 대상을 찾아가기 때문이다. 위와같은 작업을 CLI에서 진행하려면 작업을 시작하기전 미리 txt파일을 다 만들어 놔야한다. 웹 UI에서 작업을 하려고 하면 workflow.txt와 jobproperty는 따로 만들 필요가 없다. 웹 UI에서 끌어다 놓으면 그대로 알아서 만들어 주기 때문이다. CLI에서는 그런 기능이 없기 때문에 사용자가 직접 만들어 주어야 한다. HIVE 작업을 할 떄에는 HIVE-SITE.xml이 필요하다. <br>
           ![image](https://user-images.githubusercontent.com/37497189/55297978-ef9d3c00-5465-11e9-94a1-72fdf620ba5a.png)
<br>
           이는 경로 설정때문에 필요로 한 것이지 안에있는 모든 것을 다 설정해 줄 필요가 없다. 사용자가 매번이 모든것을 적용시키려면 초보자는 접근이 어렵기 때문에 불필요한 기능이 될 것이다. 
           앞서 설명한 모든 작업을 완료하고나면 이런 창을 보게 된다.<br>
           ![image](https://user-images.githubusercontent.com/37497189/55298329-080e5600-5468-11e9-86bf-623cfadf7952.png)
<br>




◎ 수요일 ~ 금요일
    - 화요일까지 workflow를 완성하였고 수요일부터는 coordinator기능과 bundle기능을 구현해 보려고 하였다. coordinator를 이용하려면 hue의 시간대와 Oozie의 시간대가 맞아야 제대로된 결과가 나와있었다. hue는 cloudera에 들어가서 Hue에 들어간다음에 수정을 하면 되었는데 Oozie는 Oozie 웹 UI에 접속을 하여서 설정을 바꿔줘야 된다고 나와있어서 이를 설정하려고 봤는데 오류가 떠서 앞서 진행하셨던 김동현 인턴의 인수인계 자료를 보고 문제 해결을 하려고 하였다. 설명에 의하면 jdk 최신버전을 다운받으면된다고 하여서 jdk 최신버전인 버전을 다운받은 후 환경변수까지 설정을 하였으나 해결이 안되었다.<br>
    ![image](https://user-images.githubusercontent.com/37497189/55297155-1ce5ec00-545e-11e9-93be-c313e0475c29.png)
    <br>
    여기에 더해서 이후에 503에러까지 났다. 503에러는 서버에 문제가 생겨서 나는 것이라고 설명이 나와있었다.<br>
    이에 서버를 껐다가 키는 과정을 해 보아도 안되고 여러가지 방법을 시도해 보았지만 해결이 되질 않았다. 그리고 coordinator기능을 쓰려고 hue를 통해 coordinator를 작성하였는데 거부 메세지가 떠서 진행이 불가능 하였다. 목요일에는 설상가상으로 오류까지 떠서 원인을 분석하려 하였지만 해결을 할 수가 없었다. coordinator페이지에서는 오류는 아니지만 trace back이라는 메세지가 계속떠서 이를 해결하려 하였지만 하지 못하였다. 그러다가 금요일에는 아예 서버자체가 망가져 버려서 namenode가 죽어서 복구가 불가능 하게 되었다. <br>
   ![image](https://user-images.githubusercontent.com/37497189/55298101-9eda1300-5466-11e9-87f9-d0441f71ac3f.png)
<br>
    namenode가 죽기전에는 HIVE 작업은 HUE 웹 UI에서 동작하는 것을 확인하였다. 다만 PIG작업은 503 error때문에 작업이 진행되질 않았다. 아래 사진은 HUE 웹 UI에서 PIG작업이 진행되지 않는 상황을 보여주는 사진이다.
    <br>
    ![image](https://user-images.githubusercontent.com/37497189/55298203-540ccb00-5467-11e9-9443-e39d4b1a8799.png)
<br>
아래의 사진은 HIVE작업이 HUE에서 잘 진행됨을 보여주는 사진이다.<br>
![image](https://user-images.githubusercontent.com/37497189/55298268-c1b8f700-5467-11e9-9725-35e15cf1c216.png)
<br>
    이에 백업 기능의 소중함을 느끼게 되었고, 4명이서 하나의 서버에서 작업을 같이 하려다보니 과부화가 걸린거 같고 오류를 잡는데에 에로사항이 많다는 것을 느끼게 되었다. 금요일 퇴근전에는 모든 서버를 내리고 다시 재 구성을 진행하였다. 새로 설치를 한다음에 snapshot기능을 통해 망가지더라도 복구를 쉽게 하도록 설정을 해 주었다.