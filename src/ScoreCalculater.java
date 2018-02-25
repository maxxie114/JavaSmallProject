/**
 * This class calculate the score of guessing the number
 * 
 * @author Max
 * 
 * @version 4.0
 * 
 * copied: 0%
 * 
 */
public class ScoreCalculater {
	private int count;
	private String score;
	private int num;

	// constructor
	public ScoreCalculater() {
		count = 0;
		score = "";
		num = 0;
	}

	/**
	 * This method prompt the user for the information that use to calculate the
	 * score
	 * 
	 * @param numOfGuess  the number of guess that the user take to guess the number
	 * @param maxi  the number that the user need to guess
	 * 
	 */
	public void setScore(int numOfGuess, int maxi) {
		count = numOfGuess;
		num = maxi;
	}

	/**
	 * This method calculate the score
	 * 
	 * @return  the score
	 * 
	 * */
	public String scoreCalculation(){
		if(num < 1000 && num > 100){
			if(count <= 20){
				score = "A";
			}else if(count <= 50 ){
				score = "B";
			}else if(count <= 100 ){
				score = "C";
			}else{
				score = "D";
			}
			
		}else if(num < 100000 && num > 1000){
			if(count <= 50){
				score = "A";
			}else if(count <= 100 && count > 50){
				score = "B";
			}else if(count <= 200 && count > 100){
				score = "C";
			}else{
				score = "D";
			}
		}else if(num < 10000000 && num > 100000){
			if(count <= 100){
				score = "A";
			}else if(count <= 200 && count > 100){
				score = "B";
			}else if(count <= 300 && count > 200){
				score = "C";
			}else{
				score = "D";
			}
		}else if(num <= 100){
			if(count <= 5){
				score = "A";
			}else if(count <= 10 && count > 5){
				score = "B";
			}else if(count <= 20 && count > 50){
				score = "C";
			}else{
				score = "D";
			}
		}else{
			score = "N / A";
		}
		return score;
	}
}
