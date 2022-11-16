package algorithm;
import java.util.*;

public class Main { //백준 1991
  public static void main(String[] args) {

	  Scanner scanner = new Scanner(System.in);
	  BinaryTree bt = new BinaryTree();
	  
	  int numOfNodes = scanner.nextInt();
	  bt.arraySetter(numOfNodes);
	  
	  for(int i = 0; i<numOfNodes; i++) {
		  char parent = scanner.next().charAt(0);
		  bt.insert(parent, i, 0);
		  
		  char leftChild = scanner.next().charAt(0);
		  bt.insert(leftChild, i, 1);
		  
		  char rightChild = scanner.next().charAt(0);
		  bt.insert(rightChild, i, 2);
	  }
	  
	  bt.preorderPrint();
	  System.out.println();
	  bt.inorderPint();
	  System.out.println();
	  bt.postorderPrint();
  }
}

class BinaryTree {
	
	Node root = null;
	
	Node[] array;
	int arrayCount = 0;
	Node p = null;
	
	public void arraySetter(int arrayLength) {
		array = new Node[arrayLength];
	}
	
	class Node {
		char data;
		Node leftChild;
		Node rightChild;
	}
	
	
	public void insert(char ch, int LineNum, int charNum) {

		if(ch == '.') {return;}
		
		if(root == null) {
			Node newNode = new Node();
			newNode.data = ch;
			newNode.leftChild = null;
			newNode.rightChild = null;
			root = newNode;
			array[arrayCount++] = newNode;
			return;
		}
		
		Node newNode = new Node();
		newNode.data = ch;
		newNode.leftChild = null;
		newNode.rightChild = null;

		if(LineNum==0) { // 0번째 줄일 경우 조건없이 노드가 만들어져서 연결됨
					if(charNum==1) { //0번째 글자는 이미 받음 , 0번쨰 줄의 첫번째 글자일 경우 왼쪽 자식이 됨
						root.leftChild = newNode;
					} 
					else if (charNum ==2) { //0번쨰 줄의 2번째 글자일 경우 오른쪽 자식이 됨
						root.rightChild = newNode;
					}
					array[arrayCount++]= newNode;
					return;
		}
			
				else { // 0번째 줄이 아닐경우
					if(charNum == 0) { // 첫번째 글자일 때 
						for(int i = 0; i<arrayCount; i++) { //배열에 해당 글자를 가진 노드가 있는지 검색 (이미 나왔던 노드인지 검사) 
							if(array[i].data == ch) { // 있으면 
								p = array[i];
								break;
							}
						}
					}
					
					else if(charNum == 1) {
						p.leftChild = newNode;
						array[arrayCount++]= newNode;
					}
					
					else if(charNum == 2) {
						p.rightChild = newNode;
						array[arrayCount++]= newNode;
					}
				}
	}
	
		public void inorderPint() {
		inorder(root);
		}
		// p를 루트로 하는 트리를 중위 순회(재귀 알고리즘)
	
	
		private void inorder(Node p) {
		if(p != null) {
		inorder(p.leftChild);
		System.out.print(p.data);
		inorder(p.rightChild);
		}
		}

	
		public void preorderPrint() {
			preorder(root);
		}
		
		private void preorder(Node p) {
			if(p!=null) {
				System.out.print(p.data);
				preorder(p.leftChild);
				preorder(p.rightChild);
			}
		}
		
		
		public void postorderPrint() {
			postorder(root);
		}
		
		private void postorder(Node p) {
			if(p!=null) {
				postorder(p.leftChild);
				postorder(p.rightChild);
				System.out.print(p.data);
			}
		}		
}



