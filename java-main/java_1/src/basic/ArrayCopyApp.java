package basic;

import java.util.Arrays;

/*배열의 복사
 * 한 번 생성된 배열은 길이를 변경할 수 없음
 * =>더 많은 데이터를 저장하기 위해 더 큰 배열을 생성하여 기존 배열의 데이터를 새로 만든 배열로 복사
 * 
 * [배열을 복사하는 방법]
 * 1. System 클래스의 arraycopy() 메소드
 *   -배열의 복사만을 위해 만들어져 가장 좋은 성능을 보임
 * 2. Arrays 클래스의 copyOf() 메소드
 *   -배열의 복사를 위해 가장 많이 사용되는 메소드
 * 3. Object 클래스의 clone() 메소드
 *   -이전 배열과 같은 길이의 배열만 만들 수 있음
 * 4. for문과 인덱스를 이용한 복사
*/
public class ArrayCopyApp {
	public static void main(String[] args) {
		int[] arr=new int[] {1,2,3,4,5};
		int newLen = 10;
		
		//1. System.arraycopy(원본배열,원본 배열의 복사 시작 지점, 복사할 배열, 복사할 배열의 복사시작 지점,복사할 요소의 갯수)
		int[] arr1=new int[newLen];
		System.arraycopy(arr, 0, arr1, 0, arr.length);
		
		System.out.print("System.arraycopy() >> ");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		System.out.println("=====================================================================");
		
		//2. Array.copyOf(원본배열,원본 배열에서 복사해올 길이)
		int[] arr2=Arrays.copyOf(arr, 10);
		System.out.print("Arrays.copyOf() >> ");
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		System.out.println("=====================================================================");
		//3. Object.clone()
		int[] arr3=(int[])arr.clone();
		System.out.print("Object.clone() >> ");
		for(int i=0;i<arr3.length;i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println();
		System.out.println("=====================================================================");
		
		//4. for 문과 인덱스를 사용한 복사
		int[] arr4=new int[newLen];
		
		for(int i=0;i<arr.length;i++) {
			arr4[i]=arr[i];
		}
		
		System.out.print("for 반복문 복사 >> ");
		for(int i=0;i<arr4.length;i++) {
			System.out.print(arr4[i]+" ");
		}
		System.out.println();
		System.out.println("=====================================================================");
		
		/*Enhanced for 문
		=>배열에서 자주 사용하는 간편화된 반복문
		=>명시한 배열이나 컬렉션의 길이만큼 반복되어 시행됨
		형식)for(타입 변수 이름: 배열이나 컬렉션 이름){
		 			배열의 길이만큼 반복적으로 실행하고자 하는 명령문
				}
		 *=>단, Enhance for문은 요소를 참조할 때만 사용하도록!
		 *=>요소의 값을 변경하는 작업에는 적합하지 않음 
		 */
		System.out.print("Enhanced for 구문 >> ");
		for(int e:arr) {
			System.out.print(e+" ");
		}
		
		System.out.println();
		System.out.println("=====================================================================");
		
		int[] forarray=new int[] {1,2,3,4,5};
		int[] enhancearray=new int[] {1,2,3,4,5};
		
		
		for(int i=0;i<forarray.length;i++) {
			forarray[i]+=10;
		}
		
		System.out.print("for을 통해 모든 요소에 +10 >>");
		for(int i=0;i<forarray.length;i++) {
			System.out.print(forarray[i]+" ");
		}
		System.out.println();
		System.out.println("=====================================================================");
		for(int e:enhancearray) {
			e+=10;
		}
		//요소의 값을 변경하는 작업에는 적합하지 않음 
		System.out.print("Enhanced for을 통해 모든 요소에 +10 >>");		
		for(int i=0;i<enhancearray.length;i++) {
			System.out.print(enhancearray[i]+" ");
		}
		
	}
}
