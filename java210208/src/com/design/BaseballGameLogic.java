package com.design;

public class BaseballGameLogic {
	
	int cnt = 0;
	
	int[] randNum = new int[3];
	int[] myNum = new int[3];
	
	public void randGenerate(){
		randNum[0] = (int)(Math.random() * 9 + 1);
		do{
			randNum[1] = (int)(Math.random() * 10);
		} while(randNum[0] == randNum[1]);
		do{
			randNum[2] = (int)(Math.random() * 10);
		}while((randNum[0] == randNum[2]) || (randNum[1] == randNum[2]));
		System.out.println(randNum[0] + " " + randNum[1] + " " + randNum[2]);
	}
	
	public String screen(String input){
		
		int strike = 0;
		int ball = 0;
		int temp = 0;
		//반드시 세자리 숫자여야 한다.
		temp = Integer.parseInt(input);
		myNum[0] = temp / 100;
		myNum[1] = (temp % 100) / 10;
		myNum[2] = temp % 10;
		
		for(int i = 0; i < randNum.length; i++){
			for(int j = 0; j < myNum.length; j++){
				//같은 숫자가 존재하는 경우(볼확보)
				//컴퓨터가 채번한 숫자가 있는지 비교
				if(randNum[i] == myNum[j]){
					//자리수까지도 일치하는 경우(스트라이크확보)
					//그 숫자가 존재하는 배열의 인덱스값을 비교
					if(i == j)
						strike++;
					else
						ball++;
				}//  end of if          ////////////////
			}//////  end of inner for   ////////////////
		}//////////  end of outter for  ////////////////
		
		if(strike == 3) {
			return "CONGRATULATIONS!!";
		}
		return strike + "S, " + ball + "B";
	}/////////////  end of call ////////////////////////	
}
