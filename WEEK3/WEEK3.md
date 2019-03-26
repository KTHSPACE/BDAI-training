이번주 주제 : Zookeeper + HA, Sqoop + HUE, Ozzie + Pig, Flume + Kafka가 무엇인지(역할 분담) 조사
발표 준비
cloudera 기본교육

◎월요일

    * 강의내용
        1. 전통적인 분산 컴퓨팅
            - 대용량 데이터 처리를 위해서 분산 병렬 시스템 필수

            - 전통적으로 디스크는 고가 자원

            - 중앙 집중적인 데이터 관리

            - 수행시에 데이터가 프로세서로 이동

            -네트워크 트레픽 병목현상 발생

        2. 새로운 분산 시스템 설계 기준
            - 데이터가 여러 개의 노드에 중복 저장

            - 데이터가 저장된 노드에서 처리

            - 노드 가느이 통신 최소화

        3. 분산처리는 값이 변하지않는 분석용 데이터만 용이하다.

        4. fail-over -> fault tolerance
            - fsimage는 현재 시점의 전체 데이터

            - edits는 시간 변화 동안의 변화돤 데이터 기록

        5. secondary namenode(체크포인트라고 보면됨)
            현재 시간의 데이터를 가지고있음->업데이트
            secondary namenode가 죽어도 namenode가 돌아간다면 시스템상에선 문제가 없다.

        6. 

        7. The real operation is fully distributed mode
            - LocalJobRunner
                개발자모드

            - Pseudo-distributed
                가상으로 서버를 돌려보는 테스트 목적
            
            - Fully distributed
                실제로 분석하는 환경

        8. 마스터 노드들은 별도의 서버로 구성하는것이좋다 한 곳에 일을 
        집중적으로 넣으면  과부하가 걸림그게 마스터 노드이면
        시스템에 큰 문제를 일으킬 수 있음.

        9. fault tolerance란?
            시스템이나 하드웨어가 고장날것을 미리 가정해 놓고 대비하는 시스템
            이는 시스템이나 하드웨어가 고장이 났을때 기능이 한번에 멈추면 
            문제가 있기 때문에 단계적으로 줄이는 과정과 그 과정에서 복구를
            하는 과정이 있다.

        10. Hadoop Cluster
            - 마스터 노드(Master nodes)

            - 작업 노드(slave nodes)

            - 분산 처리를 위한 노드 그룹
                ㆍ 마스터노드는 관리자 역할
                    보통 클러스터에 2개 이상
                
                ㆍ 단일 장애 지점 - SPOF(single point of failure) 대비를 위한 캐리어 급 H/W

                ㆍ Namespace 및 자원 관리

            - 워커 노드는 실제 작업 수행
                ㆍ 필요 시 다수의 워커 노드들 확장 가능

                ㆍ워커 노드들은 고장을 가정

                ㆍ실제 데이터 저장 및 처리

        11. YARN의 가장 큰 장점
            - 여러개의 컴퓨팅 플랫폼을 효율적으로 쓰기위해
                ex)100대의 구성을 가진 클러스터가 있으면 여기에 mapreduce랑 spark를 구성한다고 하면 2가지 방법이 있다. 100대 전체에 MapReduce랑 spark를 다 설치하는 방법, 50대에 MapReduce를, 나머지 50대에 Spark를 설치하는 방법 첫번째 방법은 두개를 동시에 구돟하려하면 자원을 50%씩 잡아먹게되어 MapReduce가 구동하는 동안은 50%를 차지하는 Spark는 사용을 못하게 되고 Spark가 동작하고있을땐 MapReduce를 구동하지 못하게되는 불상사가 일어난다. 두번째 방법인 50대씩 설치는 Mapreeduce가 실행 될 동안은 Spark를 설치한 컴퓨터는 놀게되는 문제가 발생하게 된다.  위와같은 문제를  해결하는게 YARN이다. 100대의 컴퓨터에 YARN을 설치하게되면 YARN이 자원을 효율적으로 배분해줘서 100대에서 작업을 나누어서 잘 작동하게 해줌. 

        12. Parcels
                패키지는 전체를 깐다면 Parcel은 작은단위로 다운이 가능하고 
                rolling update(서버를 정지하지 않아도 업그레이드 가능)가 가능하다.

        13. fsimage, edits -> metadata

        14. safe mode란
            업데이트가 일어나지 않는 모드 ->읽기는 가능한데
            쓰거나 삭제를 못함(자동으로 safe모드가 잡힐때는 namenode가 리부팅할때) 유지부수를 하기 위해서 강제적으로 할 수도 있음. 빠져나오는건 수동으로 가능하지만 데이터노드에서 80%정도 block reoprt를 받아오면 자동으로 빠져나온다.

        15. 로컬에서 HDFS로 파일을 가져오는것은 put, HDFS에서 로컬로 파일을 가져오는 것은 GET, 리눅스와는 다르게 working directory개념이 없기때문에 절대경로나 현재 디렉토리만 인식이 가능하다.


* 해결해야 될 문제
    1. RM이 죽으면?

    2. AM이 죽으면?

    3. NM가 죽으면?

    4. Maptask가 죽으면?

    5. Ambari에 무엇이 대체로 들어갈지

    6. Kudu가 뭔지
        Apache Kudu는  structure data에서 동작하는 storage engine이다. Hbase는 Laterncy time이 빠른 반면에 핸들링 할수 있는 size는 작다. random한 데이터를 찾아가기 용이하다. HDFS는 연속된 블록의 데이터들은 처리하기 쉽다. size가 큰 데이터를 처리하긴 쉽지만 laterncy는 작다. 처리해야될 데이터에 따라서 Hbase를 쓰거나 다른것을 써야지 속도가 빠르다고 Hbase만 쓰는것은 아니다. Kudu는 이러한 구조의 중간 지점이다. 두가지의 장단점을 섞어놓은것이 Kudu이다. Kudu는 HDFS와 상관없이 올라간다. 하지만 거기에 있는것처럼 read, write를 할 수 있다. 그러나 조금 불편. 그래서 Kudu랑 impala랑 같이 쓴다. Kudu는 impala랑 같이 개발되었다. 깔때는 데이터노드에 깔아야 된다. kudu 구조도 3node구조이다. master와 slave구조이다.

    7. NoSQL에 HBase말고 뭐가 있는지(HDFS가 꼭 필요) 이것은 뭐가 다른지, 뭐를 할 수 있는지
        오픈소스이고 Nosql이다. HDFS의 와 연동되는 하나의 클라이언트이다. 칼럼형 데이터베이스를 저장한다. random write와 random read기능을 제공한다. 초당 수천TB현태의 데이터를 핸들링 가능하다. MongoDB, Kasandra, cuchibase등이 있다. 최근에 많이 쓴느게 Apache Kudu이다.



    8. Block ID가 뭔지

    9. HDFS에서 NM에 데이터가 저장되는 구조 알아보기
        Namenode에는 fsimage와 edits라는 저장 공간이 있다. fsimage는 현재 상태의 데이터 경로들을 저장하고 edits는 변화된 상태들을 기록한다. Secondarynamenode의 역할은 Namenode의 fail-over의 기능이 아니라 backup기능을 수행한다. fsimage와 edit의 기록들을 Secondarynamenode에 저장한 뒤에 fsimage랑 edits를 합한뒤 Namenode의 fsimage를 최신으로 업데이트를 해준다. 이 과정을 반복하면서 저장을 하는 구조이다. Secondarynamenode가 죽는다고 해서 시스템이 정지하는것이 아니다. 앞서 설명한 바와 같이 Secondarynamenode의 역할은 Namenode가 죽었을때 동작하는 fail-over의 기능이 아니라 Namenode가 죽었을때 저장해 놓았던 기록들을 불러들여 복구를 하는 용도이기 때문이다. 

    10. HDFS에서 데이터 노드가 죽으면 그안에 있던 데이터목록들을 보고 다른 데이터 노드들로 복사를 해 준다. 그러나 데이터노드가 복구가 된다면 기존에 있던 데이터노드를 지우거나 새로 복사된 데이터블록들을 없애는게 아니라 랜덤으로 없어지게 된다. 

    11. 전체적인 HDFS의 구조를 볼수 있는 방법은?
        1) Cloudera Manager에서 볼수 있음(7080포트)->HDFS페이지로 가서 볼수 있음
        2) Namenode로 접속해서 볼수 있음(50070 포트)->웹UI
        3) HUE에서 볼 수 있음
        4) CLI커맨드 안에서 볼 수 있음 

◎ 화요일~수요일

    * 강의내용
        1. YARN이란?
            - Yet Another Resource Negotiator(YARN)

            - sqoop은 ozzi를통해 실시간 데이터를 가져올수있고 
            real time수집은 kafka, flume은 데이터가 발생할때 받아올 
            수 있음. YARN은 메모리, CPU를 효율적으로 사용할 수 
            있게 해주는 프레임워크이다. YARN에서는 자원의 묶음을 
            container라고 한다.

            - MapReduce
                안정성이 있다. key-value형태로 저장되어있는 
                데이터를 분산병렬로 처리 한다.  구조상으로는
                Mapper와 suffle, Reducer로 나뉜다. Mapper는 
                데이터를 Key-value 형태로 나누어준다. 
                Reducer는 실질적으로 액션을 해서 결과를 만들어준다.
                Mapper과 Reducer는 기본적으로 함수여서 사용자가 
                직접 개발할 수 있다. 이에따라 결과가 바뀐다. 
                input데이터가 오면 input spliter에 의해 
                각각의 블록으로 나뉘어서 각각의 노드로 이동하여 
                RecordReder에 의해 읽히고, Mapper과정을 통해 
                Key-Value로 만들어져서 Partitioner에 의해 분리되고 
                Shuffle과정과 Sort과정을 통해 분배되어서 Reducer에 
                들어가게 된다. 그뒤 원하는 결과값이 도출된다. 
                Mapper에서 key-Value값으로 나온것을 
                저장(기록)해야 되는데 이는 로컬에서 저장이 된다. 
                그래서 이 저장공간이 확보가 되지않으면 프로그램이 멈춘다. 
                Shuffle과 sort과정에서는 같은 키를 
                가진 애들끼리 모아서 Reducer로 전달한다. 
                Reducer가 만든 결과는 HDFS에 저장을 한다. 
                Job은 여러개의 task로 구성되어 있다. 
                task에는 map task와 Reduce task가있다. 
                task는 mapReduce의 가장 하위 level이다. 
                task는 각각의 일을 수행하게 된다. 
                task가 돌기위해선 container가 있어야한다.
                container는 cpu와 메모리의 조합이다. 

            - Spark
               빠르다는게 강점, 인메모리구조로 모든게 메모리에 올라가서 속도가 
               빠름 스트리밍 데이터 처리를 할 수 있음 머신러닝도 되는 파워풀한 
               프레임워크이다. Hive와 Pig도 돌릴 수 있다. 그러나 자원을 
               많이 먹는다는 단점이 있다.
               spark는 하나의 Application에 여러개의 Job이 들어갈 수 있다. 하둡의 에코시스템으로 개발이 되었지만 현재는 하둡처럼 하나의 큰 구조를 가지게 되었다. 로직에만 포커스를 맞출 수 있다. wokernode를 이용하여 처리하고 원한다면 추가로 더 구성을 할 수 있다는 장점이 있다. Spark Apllication을 만들때 Python이나 Scala, Java를 이용할 수 있다. Spark에서 Application을 Deployment하는 방법이 두가지가 있다. "Client Deployment Mode"와 "Cluster Deployment Mode"가 있다. 이 구성은 Spark Driver가 어디 있느냐에 따라 달라진다. Client Deployment Mode는 Spark Driver를 Client에서 돌리는 것 이고, Cluster Deployment Mode는 ApplicationMaster에서 돌리는 것이다. RDD란 (Resilient, Distributed, Dataset)이다. Resilient란 이를 이용해서 데이터나 메모리가  없어져도 그것을 다시 만들 수 있다. Resilient는 바뀐 데이터 정보를 가지고 있다. 이는 클러스터 전체 메모리에 나누어져서 저장되어 있다. 이것이 Distributed이다. RDD에서 RDD로 바꾸는것을 변환(transform)이라 한다. 그리고 그 RDD에서 만든것을 action이라 한다. container에서 도는데 execute로 돈다. YARN에서 spark가 돈다. 그러나 spark는 혼자서도 돌 수 있다. job History Server는 분산병렬을 수행하기 때문에 몇개의 잡이 도는지 알수가 없어 핸들링 할 수 가 없다. 이 말은 디버깅을 할 수 없다는 얘기이다. 이에 로그를 보고 하는데 이를 해주는게 job history이다. JobHistory에 서버를 만들어주는게 Nodemanager이다.
               spark가 빠르고 자원을 많이 잡아먹는 이유는 도는동안 쓰고있던 execute들이 컨테이너에 다 담겨있다. MapReduce는 쓰고나면 다 없어진다. 이 구조랑 비슷한게 impala인데 이러한 이유로 inpala랑 MapReduce는 같이 돌리면 안된다.

◎ 목요일~금요일

    * ozzie란?
        1. 정의
            아파치 우지(Apache ozzie)는 하둡의 잡(job)을 관리하기 위한 
            서버 기반의 워크플로 스케줄링 시스템이다.
            우지의 워크플로는 워크플로 정의 안에 ${inputDir}등의 변수를 
            사용하여 파라미터화 할 수 있다. 우지의 워크플로는 방향성 비사이클
            그래프에서 제어 흐름과 액션 노드의 모임으로 정의된다.
            제어 흐름 노드는 워크플로의 시작과 끝(시작,끝,실패 노드),
            그리고 워크 플로 실행 경로를 제어하기 위한 
            구조(결정,포크,조인 노드)를 정의한다. 액션 노드들은 워크플로가
            계산/처리 작업의 실행을 명령하는 메커니즘이다. 우지는 하둡 
            맵리듀스, 하둡 분산파일 시스템 조작, 피그, SSH, 이메일을 포함한 
            각기 다른 종류의 액션의 지원을 제공한다. 우지는 추가적인 유형의 
            액션을 지원하도록 확장할 수도 있다.
            
            
HDFS실습

1. <img width="426" alt="캡처2day_1" src="https://user-images.githubusercontent.com/37497189/54888178-26130e00-4ede-11e9-9933-f2fdadc807dc.PNG">

2. <img width="470" alt="캡처2day_2" src="https://user-images.githubusercontent.com/37497189/54888191-4773fa00-4ede-11e9-8258-3c7305058560.PNG">

3. <img width="465" alt="캡처2day_3" src="https://user-images.githubusercontent.com/37497189/54888196-56f34300-4ede-11e9-8b47-38971aff9e7b.PNG">

4. <img width="382" alt="캡처2day_4" src="https://user-images.githubusercontent.com/37497189/54888200-62466e80-4ede-11e9-856e-b21c18cc377f.PNG">

5. <img width="413" alt="캡처2day_5" src="https://user-images.githubusercontent.com/37497189/54888206-6ecac700-4ede-11e9-8512-99a58aa26147.PNG">

6. <img width="466" alt="캡처2day_6" src="https://user-images.githubusercontent.com/37497189/54888216-7e4a1000-4ede-11e9-84b2-cabe137c1d52.PNG">

7. <img width="435" alt="캡처2day_7" src="https://user-images.githubusercontent.com/37497189/54888219-87d37800-4ede-11e9-8dda-fbfb8d490b31.PNG">

8. <img width="487" alt="캡처2day_8" src="https://user-images.githubusercontent.com/37497189/54888221-928e0d00-4ede-11e9-9ddb-f60697403212.PNG">


.