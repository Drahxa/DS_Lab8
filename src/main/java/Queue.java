public class Queue<T>
{
    //be sure that your attributes are protected, so subclasses can use them
	protected Node<T> head;
	protected Node<T> back;
	protected int size;


   public Queue()
   {
	   this.head = null;
	   this.back = null;
	   this.size = 0;
	   
   }


    /**Adds val to the end of the queue
     */
   public void push(T val)
   {
		Node<T> n = new Node(val, null);
	   if ( head == null ) {

		   head = n;
		   back = n;
		   
	   } else {
			back.next = n;
			back = n;

	   }
	   
	   size++;
   }


    /**
       removes and returns the oldest value in the queue
       throws QueueUnderFlowException if the queue is empty
     */
   public T pop()
   {
	   
	   if(head == null) {
    	   
    	   throw new QueueUnderFlowException();
    	   
	   }
	   
	   T oldVal = head.val;
	   head = head.next;
	   size--;

	   if (head == null){
		back = null;
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
	Node<T> next;
	
	public Node(T val, Node<T> next) {
		this.val = val;
		this.next = next;
	}
}