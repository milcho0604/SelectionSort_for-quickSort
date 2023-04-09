package hw5_1;

import java.util.Scanner;

//코드 완성 이후에 chatGPT를 이용하여 변수명을 더욱 깔끔하게 수정하였음.
//퀵정렬에 사용한 분할 알고리즘을 이용하여 선택 정렬 알고리즘을 구현하기.
public class Main_202014036 {

	public static void main(String[] args) {
		System.out.println("hw5_1:김창현");

		// 사용자가 원하는 갯수의 정수값을 입력받음
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}

		// 선택 정렬의 최솟값.
		System.out.println(selectSort(array, 0, n - 1, 1));
		// 선택 정렬의 중간 값.
		System.out.println(selectSort(array, 0, n - 1, n / 2));
		// 선택 정렬의 마지막 값.
		System.out.println(selectSort(array, 0, n - 1, n));

		// 선택 정렬 결과를 반복문으로 출력
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		sc.close();
	}

	// 선택 정렬 알고리즘을 구현함.
	private static int selectSort(int[] array, int startIndex, int pivotIndex, int targetIndex) {

		if (startIndex == pivotIndex) { // 1일 경우
			return array[startIndex];
		}
		int partitionIndex = partition(array, startIndex, pivotIndex); // partitionIndex에 partition메소드의 결과 값을 저장.

		int partitionSize = partitionIndex - startIndex + 1;

		if (targetIndex < partitionSize) { // 기준값보다 작은 값에서 찾기.
			return selectSort(array, startIndex, partitionIndex - 1, targetIndex);
		} else if (targetIndex == partitionSize) { // 기준값과 일치하는 경우.
			return array[partitionIndex];
		} else { // 기준값보다 큰 수에서 찾기.
			return selectSort(array, partitionIndex + 1, pivotIndex, targetIndex - partitionSize);
		}

	}

	// 퀵 소트 알고리즘에서 구현한 분할을 여기서도 동일하게 구현.
	private static int partition(int[] array, int startIndex, int endIndex) {
		int pivot = array[endIndex]; // 기준 원소 pivot을 선언한다.
		int i = startIndex - 1; // i구역의 1구역의 끝지점.
		for (int j = startIndex; j < endIndex; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, endIndex);
		return i + 1; // 기준값을 리턴한다.
	}

	// swap을 이용해서 작은 값을 앞으로 보내기 위한 교환
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}