package basic;

//연산자(Operator)
public class OperatorApp {
	public static void main(String[] args) {
		System.out.println("10+20*3= "+(10 + 20 * 3));
		System.out.println("(10+20)*3= "+((10 + 20) * 3));
		
		System.out.println("======================================");
		
		//양수화/음수화 연산자
		int a1=20;
		System.out.println("a1= "+a1);
		System.out.println("-a1= "+(-a1));
		
		System.out.println("======================================");
		
		//Not 연산자
		System.out.println("20>10= "+(20>10));
		System.out.println("!(20>10)= "+!(20>10));
		
		System.out.println("======================================");
		
		//증감 연산자
		int a2=10, a3=10;
		System.out.println("a2= "+a2+" a3= "+a3);
		++a2; 
		--a3;
		System.out.println("a2= "+a2+" a3= "+a3);
		
		System.out.println("======================================");
		
		//++연산자와 --연산자로만 구성된 단일 명령이 아닌 경우 연산자의 위치는 연산결과에 영향을 미침
		int a4=10, a5=10;
		System.out.println("a4= "+a4+" a5= "+a5);
		int result1=++a4; //전처리: ++a4 연산식이 실행된 후 result1=a4 연산식 실행_선연산 후명령
		int result2=a5++; //후처리: result2=a5 연산식이 실행된 후 a5++ 연산식 실행_선명령 후연산
		System.out.println("a4= "+a4+" a5= "+a5);
		System.out.println("result1= "+result1+"result2= "+result2);
		
		System.out.println("======================================");
		
		//산술 연산자
		int b1=20, b2=20;
		System.out.println(b1+"*"+b2+"="+(b1*b2));
		System.out.println(b1+"/"+b2+"="+(b1/b2));
		System.out.println(b1+"%"+b2+"="+(b1%b2));
		System.out.println(b1+"+"+b2+"="+(b1+b2));
		System.out.println(b1+"-"+b2+"="+(b1-b2));
		
		System.out.println("======================================");
		
		//비교(관계) 연산자
		System.out.println("20>10= "+(20>10));
		System.out.println("20<10= "+(20<10));
		System.out.println("20>=10= "+(20>=10));
		System.out.println("20<=10= "+(20<=10));
		System.out.println("20==10= "+(20==10));
		System.out.println("20!=10= "+(20!=10));
		
		System.out.println("======================================");
		
		//논리 연산자
		int c=20;
		System.out.println("c= "+c);
		//&&연산자는 첫번째 비교식이 거짓인 경우 두번째 조건식 미실행
		System.out.println("c>= 10 && c<=30= "+(c>= 10 && c<=30));
		//||연산자는 첫번째 비교식이 참인 경우 두번째 조건식 미실행
		System.out.println("c<10 || c>30= "+(c<10 || c>30));
		
		System.out.println("======================================");
		
		//대입 연산자
		int e=10; //순수 대입 연산자
		System.out.println("e= "+e);
		e+=20; //e=e+20 =>계산 대입 연산자
		System.out.println("e= "+e);
		System.out.println("======================================");
		
		//삼항 연산자
		int d1=10, d2=20;
		System.out.println("큰 값 = "+(d1>d2?d1:d2));
		
		int d3=10, d4=11;
		System.out.println(d3+"="+(d3%2==0?"짝수":"홀수"));
		System.out.println(d4+"="+(d4%2==0?"짝수":"홀수"));
		
	}
}
