// code_507perfect numbers.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"
#include<iostream>
/*507--������*/
class Solution {
public:
	bool checkPerfectNumber(int num) {
		if (num == 1)
			return false;
		int sum = 1;
		for (int i = 2; i <sqrt(num); ++i)
		if (num%i == 0)
			sum += num / i + i;
		else if (sum>num)
			return false;

		if (sum == num)
			return true;
		return false;
	}
};

int _tmain(int argc, _TCHAR* argv[])
{
	return 0;
}

