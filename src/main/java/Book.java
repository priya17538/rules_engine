public class Book extends PaymentState{
    @Override
    void handleEvent(RuleEngine ctx, PaymentType paymentType) {
        // create a duplicate packing slip for the royalty department.
        switch (paymentType) {
            case BOOK:
                ctx.packingSlip += " generating duplicate packing slip for the royalty department\n";
                break;
            case PHYSICAL_PRODUCT_Book:
                ctx.commissionPayment = "generate a commission payment to the agent.\n";
                break;
            default:
                break;
        }
    }
}
