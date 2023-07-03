// 연습5-6
// 메서드 recur3의 비재귀적 구현

import java.util.Scanner;

class Recur3 {

	//--- 메서드 recur의 비재귀적 구현 ---//
	static void recur3(int n) {
		int[] n_stk = new int[100];     // n을 쌓아둘 배열
		int[] step_stk = new int[100];     // 각 n의 step을 대응해줄 배열
		int ptr = -1;      			   // n과 step을 대응할 인덱스 ptr
		int step = 0;

		while (true) {
			if (n > 0) {
				//일단 막바지까지 n을 쭉 스택에 쌓는다.
				ptr++;
				n_stk[ptr] = n;
				step_stk[ptr] = step;   // step을 부여한다

				if (step == 0)      // 0스텝이면 recur(n-1) 돌리기
					n = n - 1;
				else if (step == 1) {    //1스텝이면 recur(n-2)돌리기
					n = n - 2;      	 // n을 n-2값으로 갱신
					step = 0;       	 //갱신된 recur(n)를 돌리기 위해 step은 0으로 초기화
				}
				continue;
			}
			do {
				n = n_stk[ptr];     		//가장 최근의 n을 꺼내고
				step = step_stk[ptr] + 1;   // 위의 if문을 빠져나왔으니 최근 step을 꺼내 +1한다.
				ptr--;
				//왜 ptr-- 하는가?
				//1. step2인경우 print 하고나서 다시 상위의 n으로 올라와야 한다.
				//2. ptr<0과 관련있다. 처리할 n이 더이상 있는지 판단하기 위함.

				if (step == 2) {   //recur(n-2)를 마치고 온 n이었다면,
					System.out.println(n);    //print한다.
					if (ptr < 0)
						return;
				}
			} while (step == 2);
		}
	}
}