package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteNode(node *ListNode) {
	if node.Next != nil {
		node.Val = node.Next.Val
		node.Next = node.Next.Next
	}
}

func main() {
	node := &ListNode{
		4,
		&ListNode{5,
			&ListNode{
				1, &ListNode{
					9,
					nil,
				},
			},
		},
	}
	deleteNode(node.Next)
	for node != nil {
		fmt.Println(node.Val)
		node = node.Next
	}

}
