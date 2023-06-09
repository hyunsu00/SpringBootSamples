# 스프링 부트 샘플 프로젝트

## STEP 1. JAVA 설치
```bash
# openjdk-17-jdk
$ sudo apt install openjdk-17-jdk 
```
<br/>

## STEP 2. JAVA_HOME 설정 (PATH라는 환경변수에 설정)
<br/>

### 2.1. Java 설치된 경로 확인
```bash
$ readlink -f $(which java)
```
<br/>

### 2.2. JAVA_HOME 경로 등록
```bash
$ sudo vi /etc/profile​
# /etc/profile 코드 추가
# openjdk-17-jdk
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$PATH:$JAVA_HOME/bin
```
<br/>

### 2.3 source 명령어로 적용
```bash
$ source /etc/profile
```
<br/>

### 2.4. 환경 변수 설정된 것을 확인
```bash
$ echo $JAVA_HOME
$ echo $PATH | grep java
```
<br/>

## 3. JDK 삭제 방법
```bash
$ sudo apt-get purge openjdk*
```
<br/>

## 4. vscode 확장팩 설치
1. [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)  
2. [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack)
3. [Lombok Annotations Support for VS Code](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-lombok)  
4. [Gradle for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-gradle) 
<br/>


## 5. 프로젝트 생성 및 실행
1. [Ctrl + Shift + P] => ‘Spring initalizr: Create a Gradle Project’
2. Spring Boot version 선택: 예) 3.0.7
3. Project language 선택: 예) Java
4. Group Id 등록: 예) io.honeymon.boot.springboot.vscode
5. Artifact Id 등록: 예) spring-boot-of-vs-code
6. Packaging type 선택: 예) Jar
7. Java Version 선택: 예) 17
8. Dependnecies 선택: 예)
    - Spring Boot DevTools
    - Lombok
    - Spring Configuration Processor
    - Spring Web
    - Spring Data JPA
    - H2 Database
    - Flyway Migration
    - MariaDB Driver
9. 저장소 생성위치 지정
<br/>

## 참고)
- [Spring](https://spring.io/)  
- [Spring initializr](https://start.spring.io/)
- [Running and debugging Java](https://code.visualstudio.com/docs/java/java-debugging) 
- [Spring Boot in Visual Studio Code](https://code.visualstudio.com/docs/java/java-spring-boot)
- [Visual Studio Code 개발환경 세팅](https://www.youtube.com/watch?v=ZNsEVrE9NW0&t=478s)
- [Visual Studio Code 에서 스프링 부트 프로젝트 개발하기](http://honeymon.io/tech/2021/01/06/use-vs-code-for-spring-boot.html)
<br/>

## [회사의 윈도우용 SSL 인증서를 WSL ubuntu에 설치하기](https://nameng.tistory.com/139)
```powershell
PS> certmgr.msc
# 신뢰할 수 있는 루트인증 기관 → 인증서 -> HC_SSL 더블클릭 -> 자세히 -> 파일에 복사(C)... 
# -> DER로 인코닝된 바이너리 X.509(.CER)(D) -> HC_SSL.cer 내보내기
# WSL 경로에 HS_SSL.cer 복사
```
```bash
# WSL
$ sudo openssl x509 -inform DEM -in HC_SSL.cer -out ./HC_SSL.crt
$ sudo mkdir /usr/share/ca-certificates/extra
$ sudo cp -rf HC_SSL.crt /usr/share/ca-certificates/extra/
$ sudo chmod 644 /usr/share/ca-certificates/extra/*
$ sudo dpkg-reconfigure ca-certificates
# extra/HC_SSL.crt 체크후 <OK>
```
