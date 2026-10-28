import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class PriorityQueueTest{

    
    Customer c1 = new Customer(1000, 1, 1);
    Customer c2 = new Customer(2000, 2, 2);
    Customer c3 = new Customer(3000, 3, 3);
    Customer c4 = new Customer(1000, 4, 4);
    
    Customer copy_1 = new Customer(1000, 1, 2);
    Customer copy_2 = new Customer(2000, 2, 3);
    Customer copy_3 = new Customer(3000, 3, 4);
    Customer copy_4 = new Customer(1000, 4, 4);




    @Test
    void PriorityQueue()
    {
        PriorityQueue<Customer> customerQueue = new PriorityQueue<Customer>(new Customer.WorthPoliteComparator());
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
        assertTrue(worthComparator.compare(c1, c3) < 0);
        assertTrue(worthComparator.compare(c3, c2) > 0);
        assertEquals(0, worthComparator.compare(c1, copy_1));

        Customer.LoyaltyComparator loyaltyComparator = new Customer.LoyaltyComparator();
        assertTrue(loyaltyComparator.compare(c1, c3) < 0);
        assertTrue(loyaltyComparator.compare(c3, c2) > 0);
        assertEquals(0, loyaltyComparator.compare(c2, copy_2));

        Customer.WorthPoliteComparator worthPoliteComparator = new Customer.WorthPoliteComparator();
        assertTrue(worthPoliteComparator.compare(c3, copy_3) < 0);
        assertTrue(worthPoliteComparator.compare(copy_1, c1) > 0);
        assertEquals(0, worthPoliteComparator.compare(c4, copy_4));
        
    }
}