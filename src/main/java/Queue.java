public class Queue<T>
{
    //be sure that your attributes are protected, so subclasses can use them
	protected Node front;
	protected Node back;
	protected int size;


   public Queue()
   {
	   this.front = null;
	   this.back = null;
	   this.size = 0;
	   
   }


    /**Adds val to the end of the queue
     */
   public void push(T val)
   {
	   if ( front == null ) {
		   Node n = new Node(val, null);
		   
		   front = n;
		   back = n;
		   
	   } else {
		   Node n = new Node(val, null);
		   
		   for(int i = 0; i < size; i ++) {
			   curr =
		   }
	   }
	   
	   
   }


    /**
       removes and returns the oldest value in the queue
       throws QueueUnderFlowException if the queue is empty
     */
   public T pop()
   {
	   T oldVal;
       if(front == null) {
    	   
    	   throw new QueueUnderFlowException();
    	   
       } else if (size == 1){
    	   
    	   oldVal = front.val;
    	   
    	   front = null;
    	   back = null;
       
       } else {
    	   
    	   oldVal = front.val;
    	   front = front.next;
    	   
       }
       
       return oldVal;
   }    


    /**
      returns true if the queue is empty
     */

   public boolean isEmpty()
   {
      return size == 0;
   }




}

class Node<T>{
	T val;
	Node next;
	
	public Node(T val, Node next) {
		this.val = val;
		this.next = next;
	}
}