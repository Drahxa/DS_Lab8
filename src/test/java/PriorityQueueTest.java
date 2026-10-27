import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;


public class PriorityQueueTest{

    
    Customer c1 = new Customer(1000, 1, 1);
    Customer c2 = new Customer(2000, 2, 2);
    Customer c3 = new Customer(3000, 3, 3);
    Customer c4 = new Customer(1000, 2, 3);


    @Test
    void PriorityQueue()
    {
        PriorityQueue<Customer> customerQueue = new PriorityQueue<Customer>(null);

        assertThrows(QueueUnderFlowException.class, () -> customerQueue.pop());
		customerQueue.push(c2);     //c2, null
		assertFalse(customerQueue.isEmpty());
		customerQueue.push(c1);      //c2, c1,  null
		customerQueue.push(c3);     //c3, c2, c1, null
		customerQueue.push(c4);     //c3, c2, c4, c1, null
		assertEquals(c3, customerQueue.pop());
		assertEquals(c2, customerQueue.pop());
		assertEquals(c4, customerQueue.pop());
		assertEquals(c1, customerQueue.pop());
		assertThrows(QueueUnderFlowException.class, () -> customerQueue.pop());


    }

    @Test
    void comparator()
    {
        

        Customer.WorthComparator worthComparator = new Customer.WorthComparator();

        assertThat(worthComparator.compare(c1, c4), lessThan(0));
        assertThat(worthComparator.compare(c1, c2), greaterThan(0));
        assertEquals(0, worthComparator.compare(c1, c3));
        
    }
}