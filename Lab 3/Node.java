//package Question1;

public class Node {
        public char ch;
        public int freq;
        public Node left, right, next;

        Node(){
          ch=' ';
          freq =0;
          left  = null;
          right = null;
          next = null;
        }
        Node(char ch, int freq)
        {
         this.ch = ch;
         this.freq = freq;
         left  = null;
         right = null;
         next = null;
        }
        Node(char ch, int freq, Node left, Node right, Node next) {
            this.ch    = ch;
            this.freq  = freq;
            this.left=left;
            this.right=right;
        }//end constructor
        
        public boolean isLeaf() { //Is it a leaf?
            return (left == null) && (right == null);
        }//end method isLeaf

}//end class Node
