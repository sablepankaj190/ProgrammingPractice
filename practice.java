Q.1- Print 2-D array in spiral form.

Code--

package com.practice.main;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<ArrayList<Integer>> lst = new ArrayList<>();
		ArrayList<Integer> arylist = new ArrayList<Integer>();
		ArrayList<Integer> arylist1 = new ArrayList<Integer>();
		ArrayList<Integer> arylist2 = new ArrayList<Integer>();

		arylist.add(1);
		arylist.add(2);
		arylist.add(3);
		lst.add(arylist);
		arylist1.add(4);
		arylist1.add(5);
		arylist1.add(6);
		lst.add(arylist1);
		arylist2.add(7);
		arylist2.add(8);
		arylist2.add(9);
		lst.add(arylist2);
		lst.forEach(System.out::println);
		System.out.println(spiralOrder(lst));

	}

	public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
		ArrayList<Integer> result = new ArrayList<>();
		int m = 0;
		for (ArrayList<Integer> tmp : A) {
			m = tmp.size();
		}
		System.out.println("Size of M : " + m);
		int dir = 0;
		int n = A.size();

		System.out.println("Size of N : " + n);
		int top = 0;
		int bottom = n - 1;
		int left = 0;
		int right = m - 1;
		
		
		while (  left <= right && top <= bottom) {
			if (dir == 0) {
				for (int i = left; i <= right; i++) {
					result.add(A.get(top).get(i));
				}
				top++;
//				dir = 1;
			}
			if (dir == 1) {
				for (int i = top; i <= bottom; i++) {
					result.add(A.get(i).get(right));
				}
				right--;
//				dir = 2;
			}
			if (dir == 2) {
				for (int i = right; i >= left; i--) {
					result.add(A.get(bottom).get(i));

				}
				bottom--;
//				dir = 3;
			}
			if (dir == 3) {
				for (int i = bottom; i >= top; i--) {
					result.add(A.get(i).get(left));

				}
				left++;
//				dir = 0;
			}
			dir = (dir + 1) % 4;
		}
		
		return result;
	}
}



Q.2 - If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

Code--

package com.practice.main;

import java.util.ArrayList;

public class Test1 {

	public static void main(String[] args) {
		ArrayList<Integer> arylist = new ArrayList<Integer>();
		arylist.add(2);
		arylist.add(9);
		arylist.add(9);
		arylist.add(9);
		arylist.add(9);

		System.out.println(plusOne(arylist));
	}

	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		
        int last = 0;
        int carry = 0;
        int sum = 0;
        for(int i=A.size()-1; i>=0; i--) {
        	last = A.get(i);
  
        	sum = last + 1;
        	if(sum<10) {
        		A.set(i, sum);
        		carry = 0;
        	}
        	else if(sum>=10 && i == 0) {
        		A.set(0, 1);
        		A.add(0);
        		carry = 0;
        	}
        	else if(sum>=10) {
        		carry = 1;
        		A.set(i, 0);
        		continue;
        	}
        	if(carry == 0)
        		break;
        }
        while(A.get(0) == 0) {
        	A.remove(0);
        }
		return A;
	}
}
