module java_1 {
	//Java 프로젝트의 모듈에서 사용하기 위한 JRE System Library의 모듈을 요구하기 위한 명령
	requires java.se;
}
//보안문제로 필요한 클래스만 요청해 사용할 수 있도록 작성