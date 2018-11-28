//package Question1;

public class HuffmanQueue
{
  // inserts data into the queue in order of priority
 // so the element with highest priority (lowest number) is first
 // remove() takes the  first element from queue

 public Node front;
 public int size;

 public HuffmanQueue()
 {
  front = null;
  size = 0;
 }//end default constructor
 
 public HuffmanQueue(Node front, int size)
 {
  this.front = front;
  this.size = size;
 }//end default constructor
        
 public void insert(Node n)
 {
  //if(n.left!=null){System.out.println("left:"+n.left.freq);}
  //if(n.right!=null){System.out.println("right:"+n.right.freq);}
  
  //System.out.println("inserting: -" +((int)n.ch) + "- / " + n.freq);
  char ch = n.ch;
  int priority = n.freq;
  // finds the proper place for x and insets there
  Node p = n;
  
  Node q = front;
  Node r = null; // r follows q 
  while (q != null && (q.freq <= priority)) 
   // stops when a q priority is larger or exhausts the list
  {
   r = q; // behind q
   q = q.next;
  }
  if (r == null) // insert at front
  {
   p.next = front;
   front = p;
  }
  else // insert Node r into its proper place
  {
   r.next = p;
   p.next = q;
  }

  size++;
 }//end method insert
        
 public Node remove()
 {
  if (size == 0)
  {
   System.out.println("Priority Queue underflow");
   System.exit(0);
  }
  Node temp = front;
           

  front = front.next;
  size--;
           
  return temp;
 }//end method remove
 
 public Node returnFront(){
  return front;
 }//end method returnFront
 
 public int returnSize(){
  return size;
 }//end method returnSize
 
 public void printQueue(){
  Node temp = front;
  while(temp!=null){
   System.out.println(temp.ch + ": " + temp.freq);
   temp = temp.next;
  }//end while
 }//end method printQueue
 
 public void printTree(Node n){
  Node temp = n;
  
  while(temp.left.freq>0){
   System.out.println(temp.freq + " " + temp.ch);
   printTree(temp.left);
   
  }//end while
  
  while(temp.right.freq>0){
   System.out.println(temp.freq + " " + temp.ch);
   printTree(temp.right);
   
  }//end while
 }//end method printTree
 
 public void setSize(int sizePassed){
  size = sizePassed;
 }
}//end class HuffmanQueue