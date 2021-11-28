import java.util.Map;

public class Book implements PaymentState{
    protected static Map<PaymentType, PaymentState> rule;

    public static void setRule(Map<PaymentType, PaymentState> rules) {
        rule = rules;
    }
    @Override
    public Map<PaymentType, PaymentState> getRule() {
        return rule;
    }
    @Override
    public void handleEvent(RuleEngine ctx, PaymentType paymentType) {
        // create a duplicate packing slip for the royalty department.
        switch (paymentType) {
            case BOOK:
                ctx.packingSlip += " generating duplicate packing slip for the royalty department\n";
                System.out.println("In PhysicalProduct packingSlip(PHYSICAL_PRODUCT): " + ctx.packingSlip);
                break;
            case PHYSICAL_PRODUCT_Book:
                ctx.commissionPayment = "generate a commission payment to the agent.\n";
                System.out.println("In PhysicalProduct packingSlip(PHYSICAL_PRODUCT_Book): " + ctx.commissionPayment);
                break;
            default:
                break;
        }
    }
}
