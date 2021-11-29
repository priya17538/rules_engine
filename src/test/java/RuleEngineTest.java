import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class RuleEngineTest {

    private RuleEngine ruleEngine = new RuleEngine("abc@gmail.com");

    @Test
    public void testCase1() {
        // First activate the membership
        ruleEngine.handleClientEvent(PaymentType.MEMBERSHIP);
        assertEquals(ruleEngine.membership, Boolean.TRUE);
        ruleEngine.handleClientEvent(PaymentType.MEMBERSHIP_UPGRADE);
        assertEquals(ruleEngine.message, "Membership is activated\n");
        ruleEngine.handleClientEvent(PaymentType.PHYSICAL_PRODUCT);
        assertTrue(ruleEngine.packingSlip.contains("generating packing slip for shipping"));
        ruleEngine.handleClientEvent(PaymentType.PHYSICAL_PRODUCT_Book);
        assertTrue(ruleEngine.commissionPayment.contains("generate a commission payment to the agent"));
        ruleEngine.handleClientEvent(PaymentType.VIDEO);
        assertTrue(ruleEngine.packingSlip.contains("add a free “First Aid” video to the packing slip"));
    }

    @Test
    public void testCase2() {
        // First activate the membership
        ruleEngine.handleClientEvent(PaymentType.MEMBERSHIP);
        assertEquals(ruleEngine.membership, Boolean.TRUE);
        ruleEngine.handleClientEvent(PaymentType.BOOK);
        assertTrue(ruleEngine.packingSlip.contains("generating duplicate packing slip for the royalty department\n"));
        ruleEngine.handleClientEvent(PaymentType.PHYSICAL_PRODUCT_Book);
        assertTrue(ruleEngine.commissionPayment.contains("generate a commission payment to the agent."));
        ruleEngine.handleClientEvent(PaymentType.MEMBERSHIP_UPGRADE);
        assertEquals(ruleEngine.message, "Membership is Upgraded\n");
        ruleEngine.handleClientEvent(PaymentType.VIDEO);
        assertTrue(ruleEngine.packingSlip.contains("add a free “First Aid” video to the packing slip"));
        ruleEngine.handleClientEvent(PaymentType.UPGRADE);
        assertEquals(ruleEngine.membership, Boolean.TRUE);
    }

    @Test
    public void testCase3() {
        assertThrows(IllegalStateException.class, () -> ruleEngine.handleClientEvent(PaymentType.UPGRADE));
    }

}
