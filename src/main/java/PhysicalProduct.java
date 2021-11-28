public class  PhysicalProduct extends PaymentState{

    @Override
    void handleEvent(RuleEngine ctx, PaymentType paymentType) {
        switch (paymentType) {
            case PHYSICAL_PRODUCT:
                ctx.packingSlip = "generating packing slip for shipping\n";
                break;
            case PHYSICAL_PRODUCT_Book:
                ctx.commissionPayment = "generate a commission payment to the agent.\n";
                break;
            default:
                break;
        }
    }
}
