package tw.hightwo.tutor;

public class pokerV1 {
	
	public static void main(String[] args) {
		// 洗牌
		
		int[] poker = new int[52];
		for (int i = 0; i < poker.length; i++) {
			int temp = (int) (Math.random() * 52);

			// 檢查機制(重複)
			boolean isRepeat = false;
			for (int j = 0; j < i; j++) {
				if (temp == poker[j]) {
					// 重複了
					isRepeat = true;
					break;
				}
			}

				if (!isRepeat) {
					poker[i] = temp;
					System.out.println(poker[i]);
				} 
				else {
					i--;
				}
				

			}
			// 發牌

			// 攤牌 + 理排
		}
	}

