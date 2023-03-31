package basic;

public class IfApp {
	public static void main(String[] args) {
		//if문
		int su=90;
		
		if(su>=50) {
			System.out.println("su= "+su);
		}
		
		System.out.println("======================================================");
		//if문-점수가 60점 이상이면 합격, 미만이면 불합격을 출력하는 프로그램
		int score=80;
		
		if(score>=60) {
			System.out.println("[결과]점수가 60점 이상이므로 <합격>입니다.");
		}
		else {   //if(score<60)
			System.out.println("[결과]점수가 60점 미만이므로 <불합격>입니다.");
		}
		
		System.out.println("======================================================");
		//if문-변수값을 짝수 혹은 홀수로 구분하여 출력하는 프로그램
		int num=9;
		if(num%2==0) {
			System.out.println(num+">> 짝수");
		}
		else {   //if(num%2!=0)
			System.out.println(num+">> 홀수");
		}
		
		System.out.println("======================================================");
		//문자변수에 저장된 문자값을 영문자와 비영문자로 구분하여 출력하는 프로그램 작성
		char mun='O';
		if(mun>='A'&&mun<='Z'||mun>='a'&&mun<='z') {
			System.out.println("[결과]"+mun+": 영문자");
		}
		else {
			System.out.println("[결과]"+mun+": 비영문자");
		}
		/*if(mun>='A'&&mun<='Z') {
			System.out.println(mun+": 영문자 대문자");
		}
		else if(mun>='a'&&mun<='z') {
			System.out.println(mun+": 영문자 소문자");
		}
		else {
			System.out.println(mun+": 비영문자");
		}
		*/
		System.out.println("======================================================");
		//조건식 대신 boolean 변수값을 사용하여 명령을 선택하여 실행 가능
		boolean sw=true;
		if(sw) {
			System.out.println("현재 변수값은 [참]입니다.");
		}
		else {
			System.out.println("현재 변수값은 [거짓]입니다.");
		}
		/*if(!sw) {
			  System.out.println("현재 변수값은 [거짓]입니다.");
		  }
		  else {
			  System.out.println("현재 변수값은 [참]입니다.");
		  }*/
		System.out.println("======================================================");
		//변수값이 0~100 범위의 유효값인지 아닌지를 구분하여 출력하는 프로그램 작성=>입력값에 대한 유효성 검증
		int jumsu=85;
		if(jumsu>=0&&jumsu<=100) {
			 //변수값으로 등급을 구분하여 출력하는 프로그램 작성-if문	
			//System.out.println("[결과]0~100 범위의 정상적인 점수가 입력되었습니다.");
			String grade="";
			if(jumsu>=90) {
				grade= "A";
				System.out.println("[결과]점수:"+jumsu+" 학점:"+grade);
			}
			else if(jumsu>=80) {
				grade= "B";
				System.out.println("[결과]점수:"+jumsu+" 학점:"+grade);
			}
			else if(jumsu>=70) {
				grade= "C";
				System.out.println("[결과]점수:"+jumsu+" 학점:"+grade);
			}
			else if(jumsu>=60) {
				grade= "D";
				System.out.println("[결과]점수:"+jumsu+" 학점:"+grade);
			}
			else{
				grade= "F";
				System.out.println("[결과]점수:"+jumsu+" 학점:"+grade);
			}
		}
		else {
			System.out.println("[결과]0~100 범위를 벗어난 비정상적인 점수가 입력되었습니다.");
		}
		
		System.out.println("======================================================");
		
		
		System.out.println("======================================================");
		
	}
}
