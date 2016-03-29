package com.arr;

public class FirstSingle {
	/*
	 * 从第1个字符串中删除第2个字符串中含有的字----先把第二个字符串放入hash表中,遍历第一个字符串,O(1)时间判定,时间复杂度On
	 * 
	 * 删除一个字符串中重复的字符,每个字符只保留一个----定义boolean的hash表,当第一次出现时,置true,第二次出现时,查表得已经出现,
	 * 直接删除
	 * 
	 * 单词的互位词----遍历第一个单词,记录每个字母出现的次数,再遍历第二个单词,如果第一个单词出现过,次数-1,没出现过直接退出,
	 * 最后再判断是不是表中所有次数都是0
	 * 
	 */
	// 降低时间复杂度可以考虑增加空间复杂度
	// 第一个只出现一次的字符
	public char firstSingle(char[] str) {

		if (str == null || str.length == 0) {
			return 0;
		}
		int[] times = new int[256];
		for (int i = 0; i < times.length; ++i) {
			times[i] = 0;
		}

		int length = str.length;
		for (int i = 0; i < length; ++i) {
			++times[str[i]];
		}

		for (int i = 0; i < times.length; ++i) {
			if (times[i] == 1) {
				return (char) i;
			}
		}

		return 0;
	}
}
