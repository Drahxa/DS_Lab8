import java.util.Comparator;

public class PriorityQueue<T> extends Queue<T>
{

   Comparator<T> compare;

   public PriorityQueue(Comparator<T> comp)
   {
      compare = comp;
   }


    //@Override
   public void push(T val)
   {
      Node<T> newNode = new Node<T>(val, null);

      if (head == null) {
         head = newNode;
         back = newNode;
      }
      else if (compare.compare(newNode.val, head.val) > 0) {
         newNode.next = head;
         head = newNode;
      }
      else if (compare.compare(newNode.val, back.val) <= 0) {
         back.next = newNode;
         back = newNode;
      }
      else {
         Node<T> current = head;
         while (current.next != null && compare.compare(newNode.val, current.next.val) <= 0) {
            current = current.next;
         }
         newNode.next = current.next;
         current.next = newNode;
      }
   }


}
