package com.revature.extramethods;



public class MathTime {
	
public int Addition(int a, int b) {
		
		if(a<=0 || b<=0) {
			return -1;
		}
		else {
			int total = a+b;
			if (total > 0) {
				return total;
			}
			else {
				return -1;
			}
		}
	}

public int DivideBy12(int a) {
	
	if(a<=0) {
		return -1;
	}
	else {
		int total = a/12;
		if (total > 0) {
			return total;
		}
		else {
			return -1;
		}
	}
}

public int Subtraction(int a, int b) {
	
	if(a<=0 || b<=0) {
		return -1;
	}
	else {
		int total = a-b;
		if (total >= 0) {
			return total;
		}
		else {
			return -1;
		}
	}
}

}
