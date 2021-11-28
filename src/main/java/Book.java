public class Book extends PaymentState{
    @Override
    void handleEvent(RuleEngine ctx, PaymentType paymentType) {
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
