import java.util.ArrayList;
import java.util.LinkedList;

import org.w3c.dom.Node;

public class Main {

	public static void main(String[] args) {

		
		TreeNode f =new TreeNode(6,null,null);
		TreeNode e =new TreeNode(5,null,null);
		TreeNode c =new TreeNode(3,null,null);
		TreeNode d= new TreeNode(4,e,f);
		TreeNode b= new TreeNode(2,d,null);
		TreeNode a= new TreeNode(1,b,c);
		ArrayList<LinkedList<TreeNode>> al=createLevelLL2(a);
		for(LinkedList<TreeNode> ll: al){
			for(TreeNode t:ll){
				System.out.print(t.data +" ");
			}
			System.out.println();
		}

		//System.out.println(isBalanced2(a));	

	}
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLL2(TreeNode root){
		if(root==null) return null;
		
		ArrayList<LinkedList<TreeNode>> al=new ArrayList<>();
		LinkedList<TreeNode> ll=new LinkedList<>();
		ll.add(root);
		//LinkedList<TreeNode> currentLL=ll;
		
		while(ll.size()>0){
			 al.add(ll);//add previous level
			 LinkedList<TreeNode> parents=ll;//,switch name, Go to next level
			 ll=new LinkedList<>();
			 for(TreeNode t:parents){
				 if(t.left!=null) ll.add(t.left); 
				 if(t.right!=null)ll.add(t.right);
			 }
		}
		
		return al;	
	}

	
	public static ArrayList<LinkedList<TreeNode>> createLevelLL(TreeNode root){
		ArrayList<LinkedList<TreeNode>> al=new ArrayList<LinkedList<TreeNode>>();
		createLevelLL(root,al,0);
		return al;
	}
	
	
	public static void createLevelLL(TreeNode t,ArrayList<LinkedList<TreeNode>> al,int level){
		
		//ArrayList<LinkedList<TreeNode>> al=new ArrayList<LinkedList<TreeNode>>();
		if(t==null) return;
		
		LinkedList<TreeNode> ll=null;
		if(al.size()==level){
			ll=new LinkedList<TreeNode>();
			al.add(ll);
		}else{
			ll=al.get(level);
		}
		ll.add(t);
		createLevelLL(t.left,al,level+1);
		createLevelLL(t.right,al,level+1);
		
	}


}
