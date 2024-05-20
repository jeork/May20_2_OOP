
public class Referee {
	int cnt = 1;

	public void calling_me() {
		System.out.println("나오세요!");
	}

	public int ask_friend_answer(Friend f) {
		System.out.print("1~100 숫자를 종이에 쓰세요: ");
		f.friend_answer();
		return (f.paper >= 1 && f.paper <= 100) ? f.paper : ask_friend_answer(f);
	}

	public int ask_me_answer(Me m) {
		System.out.print("정답: ");
		m.my_answer();
		return (m.my_answer >= 1 && m.my_answer <= 100) ? m.my_answer : ask_me_answer(m);
	}

	public void judge_answer(Friend f, Me m) {
		ask_me_answer(m);
		if (f.paper == m.my_answer) {
			System.out.printf("%d번 만에 정답!", cnt);
		} else if (f.paper > m.my_answer) {
			cnt++;
			System.out.println("UP!");
			judge_answer(f, m);
		} else if (f.paper < m.my_answer) {
			cnt++;
			System.out.println("DOWN!");
			judge_answer(f, m);
		}
	}

	public void start(Friend f, Me m) {
		calling_me();
		ask_friend_answer(f);
		judge_answer(f, m);
	}
}
