// code_1Two Sum.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"
#include<vector>
class Solution {
	public:
		vector<int> twoSum(vector<int>& nums, int target) {
			for (int i = 0; i<nums.size() - 1; i++)
			{
				for (int j = i + 1; j<nums.size(); j++)
				{
					if (nums[i] + nums[j] == target)
					{
						return{ i, j };
					}
				}
			}
			return{ 0 };
		}
};

int _tmain(int argc, _TCHAR* argv[])
{

	return 0;
}

