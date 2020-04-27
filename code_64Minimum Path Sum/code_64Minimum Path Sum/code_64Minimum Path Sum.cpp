// code_64Minimum Path Sum.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include<vector>
#include<iostream>
#include<algorithm>
using namespace std;

class Solution {
public:
	int minPathSum(vector<vector<int>>& grid) {
		int size = grid.size();
		if (size <= 0){
			return 0;
		}	
		for (int i = 0; i < grid.size(); i++){
			for (int j = 0; j < grid[i].size(); j++){
				if (i == 0&&j>0){//第一排
					grid[i][j] = grid[i][j] + grid[i][j - 1];
				}
				else if (j == 0 && i>0){//第一列
					grid[i][j] = grid[i][j] + grid[i-1][j];
				}
				else if(i!=0&&j!=0){
					grid[i][j] = Min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j] ;
				}
			}
		}
		return grid[size - 1][grid[size - 1].size()-1];
	}
	int Min(int a, int b){
		if (a<b){
			return a;
		}
		return b;
	}
};
class Solution2{//代码整理
public:
	int minPathSum(vector<vector<int>>& grid) {
		int m = grid.size(), n = grid[0].size();

		for (int i = 1; i<m; i++)
			grid[i][0] += grid[i - 1][0];
		for (int i = 1; i<n; i++)
			grid[0][i] += grid[0][i - 1];

		for (int i = 1; i<m; i++)
		for (int j = 1; j<n; j++)
		{
			grid[i][j] += min(grid[i - 1][j], grid[i][j - 1]);
		}
		return grid[m - 1][n - 1];
	}
};
int _tmain(int argc, _TCHAR* argv[])
{
	vector<vector<int>> nums = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
	Solution so;
	cout<<so.minPathSum(nums);
	return 0;
}

