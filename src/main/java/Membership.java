public class Membership extends PaymentState{

    @Override
    void handleEvent(RuleEngine ctx, PaymentType paymentType) {
        // activate that membership.
        switch (paymentType) {
            case MEMBERSHIP:
                ctx.membership = 2; // setting membership to 2 days
                break;
            case MEMBERSHIP_UPGRADE:
                String message = "Membership is activated\n";
                generateEmail(ctx, message);
                break;
            default:
                break;
        }
    }
}
