package main

func removeKdigits(num string, k int) string {
	numArr := []byte(num)
	if len(numArr) <= k {
		return "0"
	}

	//新整数的最终长度 =  原整数长度-k
	newLength := len(numArr) - k
	//创建一个栈，用于接收所有的数字
	stack := make([]byte, len(numArr))
	top := 0

	for _, c := range numArr {
		for top > 0 && stack[top-1] > c && k > 0 {
			top--
			k--
		}
		stack[top] = c
		top++
	}

	offset := 0
	for offset < newLength && stack[offset] == '0' {
		offset++
	}
	if offset == newLength {
		return "0"
	} else {
		return string(stack[offset:newLength])
	}

}
