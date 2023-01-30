package week01.BOJ_1620_S4_나는야_포켓몬_마스터_이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1620_S4_나는야_포켓몬_마스터_이다솜 {
	static Map<String, Integer> names = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int nameN, problemN;
		
		//input N
		String[] lineArr = in.readLine().split(" ");
		nameN = Integer.parseInt(lineArr[0]);
		problemN = Integer.parseInt(lineArr[1]);
		
		//inputNames
		int idx = 1;
		while(nameN-- > 0) {
			String name = in.readLine();
			names.put(name, idx++);
		}
		
		//오름차순 정렬 A-Z
		/*
		Collections.sort(names, (o1, o2)->{
			return o1..compareTo(s2);
		});*/
		
		
		//problems
		while(problemN-- > 0) {
			String answer = "";
			String problem = in.readLine();
			//문자열이 정수인지 아닌지 판별하는 방법 : 예외처리 이용
			if (isInteger(problem)) {
				answer = names.get(Integer.parseInt(problem) - 1); //-1을 하여 index 맞춰줌
			}else {
				answer = myIndexOf(problem, 0, names.size() - 1)  + 1 + ""; // +1을 하여 index 맞추고, ""를 더하여 문자열로 바꿔줌
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
	
	private static boolean isInteger(String str) {
		try{
			Integer.parseInt(str);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
		
	}
	
	//이분탐색..?
	private static int myIndexOf(String target, int start, int end) {
		int idx = (start + end) / 2;
		String midName = names.get(idx);
		if (target.compareTo(midName) == 0 || idx == end) {
			return idx;
		}
		else if (target.compareTo(midName) < 0) {
			return myIndexOf(target, start, idx);
		}
		else {
			return myIndexOf(target, idx, end);
		}
	}
}
