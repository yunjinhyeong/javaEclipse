# 부산IT교육센터 (2020-08-10~2020-02-00)<br><br>
[자바 오라클 연동](https://github.com/yunjinhyeong/javaEclipse/tree/master/web_booklist)

[자바 MySQL 연동](https://github.com/yunjinhyeong/javaEclipse/tree/master/java_study/src/java0923)

[javascript 공부](https://github.com/yunjinhyeong/javaEclipse/tree/master/javascript_study)

[jsp 공부](https://github.com/yunjinhyeong/javaEclipse/tree/master/jsp_study)


## MySQL 설정
#### C:\ProgramData\MySQL\MySQL Server 5.7\my.ini에서
- [client] default-character-set=utf8
- [mysql] default-character-set=utf8
- [mysqld] default-character-set=utf8
    - collation-server = utf8_unicode_ci
    - init-connect='SET NAMES utf8'
    - init_connect='SET collation_connection = utf8_general_ci'
    - character-set-server=utf8

#### mysql 터미널 접속해서 utf8 설정 확인
##### show variables like 'c%';<br><br>
#### * 참고 (혹시 root 아이디 허용이 안되어 있으면 아래와 같이 세팅해준다)
##### C:\> mysql -u root -p
##### GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root';
##### FLUSH PRIVILEGES;<br><br>
#### 데이터베이스 사용자 계정 생성
##### GRANT ALL PRIVILEGES
##### ON sakila.* TO 'myid'@'localhost'
##### IDENTIFIED BY 'mypwd';<br><br>

##### GRANT ALL PRIVILEGES
##### ON sakila.* TO 'myid'@'%'
##### IDENTIFIED BY 'mypwd';<br><br>
#### 데이터베이스 선택
##### use sakila;<br><br>
#### 회원 테이블 생성
##### CREATE TABLE memeber (
##### 	id VARCHAR(50) PRIMARY KEY,
##### 	passwd VARCHAR(50) NOT NULL,
##### 	name VARCHAR(50) NOT NULL,
##### 	reg_date TIMESTAMP
##### );