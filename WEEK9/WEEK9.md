IDP - SSO구축 현황



---------------------------------------------------------------------------------------------
서버 : WSO identity- server

ID Provider : Shibboleth

로그인 UI제공 : travelo city -> 다른 앱을 이용해도 되지만 유료인 것이 많음 

SP : Cloudera Managere, Hue

Metadata-store : H2(API Manager에서 기본저공, WSO identity-server에서는 제공x)->mysql로 바꾸거나 AD연동해서 진행해도 됨
----------------------------------------------------------------------------------------------



현황 
1. 예제 구글 연동은 끝난상태 cloudera magager를 sp로 추가하는게 관건 ->방법을 찾고있는중

2. 