package tw.brad.tutor;

public class PokerV2 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] poker = new int[52];
		boolean isRepeat;
		int temp;
		for (int i=0; i<poker.length; i++) {
			do {
				temp = (int)(Math.random()*52);
				
				// 檢查機制
				isRepeat = false;
				for (int j=0; j<i; j++) {
					if (poker[j] == temp) {
						// 重複
						isRepeat = true;
						break;
					}
				}
				
			}while(isRepeat);
			
			poker[i] = temp;	
			
		}
		System.out.println("----");
		System.out.println(System.currentTimeMillis() - start);
		System.out.println("----");
		//-------------
		for (int card : poker) {
			System.out.println(card);
		}
		
		
	}

}
