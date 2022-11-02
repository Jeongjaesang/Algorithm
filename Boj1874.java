package algorithm;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1874 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		boolean yesOrNo = true;
		int baseNum = 0;
		int nextNum = 0;
		Stack<Integer> stack = new Stack<>();
		
		ArrayList<String> boolArr = new ArrayList<>();
		
		for(int i = 1; i<=n; i++) {
			int input = Integer.parseInt(br.readLine());
			if(i == 1) {  
				baseNum = input;
				for(int j = 1; j<=baseNum; j++) {
					stack.push(j);
					boolArr.add("+");
				}
				stack.pop();
				boolArr.add("-");
			} 
			else {
				
				nextNum = input;
				
				if(nextNum < baseNum) {   
					
					if(stack.peek() != nextNum) {
						yesOrNo = false;
					}
					
						stack.pop();
						boolArr.add("-");
				}
				else {
					int rn = nextNum - baseNum;
					for(int j = 0; j<rn; j++) {
						stack.push(++baseNum);
						boolArr.add("+");
					}
					stack.pop();
					boolArr.add("-");
					baseNum = nextNum;
				}
			}
		}
		
		if(yesOrNo) {
			for(int i = 0; i<boolArr.size(); i++) {
				System.out.println(boolArr.get(i));
			}
		} else {
			System.out.println("NO");
		}
	}

}
