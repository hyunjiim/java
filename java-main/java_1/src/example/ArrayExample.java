package example;

public class ArrayExample {
	public static void main(String[] args) {
		//사람들의 나이를 저장한 배열 생성하여 참조변수에 저장		
		int[] age={27,16,22,36,57,60,43,23,14,29,44,52,59,51,39,33,11};
		
		//배열에 저장된 모든 사람들의 나이 평균을 계산하여 출력하세요.
		int sum=0;
		for(int i=0;i<age.length;i++) {
			sum+=age[i];
		}
		double avg=(double)sum/age.length;
		System.out.println("[결과]나이 평균: "+(int)(avg*100)/100.0);
		
		
		System.out.println("===============================================================");
		//배열에 저장된 사람들의 나이를 연령별로 구분하여 인원수를 계산하여 출력하세요.
		//ex) 10대 = 3명
		//    20대 = 4명
		//    ...
		//    60대 = 1명
		int[] cnt= new int[6]; //cnt[0]=>10대 인원수, cnt[1=>20대 인원수.....]
		
		for(int i=0;i<age.length;i++) { 		
			if(age[i]>=60) {
				cnt[5]++;
			}else if(age[i]>=50) {
				cnt[4]++;
			}else if(age[i]>=40) {
				cnt[3]++;
			}else if(age[i]>=30) {
				cnt[2]++;
			}else if(age[i]>=20) {
				cnt[1]++;
			}else if(age[i]>=10) {
				cnt[0]++;
			}
			}
		for(int i=10;i<=60;i+=10) {
			System.out.println(i+"대 = "+cnt[(i/10)-1]+"명"); 
			}
	
		
		System.out.println("===============================================================");
	}
}
