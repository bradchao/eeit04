package tw.brad.tutor;

public class PokerV3 {

	public static void main(String[] args) {
		// 1. 文具行買回來
		int nums = 52;
		int[] poker = new int[nums];
		for (int i=0; i<poker.length; i++) poker[i] = i;
		
		// 2.
		for (int i=nums-1; i>0 ;i--) {
			int rindex = (int)(Math.random()*(i+1));
			// poker[i] <=> poker[rindex]
			
			int temp = poker[rindex];
			poker[rindex] = poker[i];
			poker[i] = temp;
		}
		
		for (int card : poker) {
			System.out.println(card);
		}		
	}

}
