public class Membership extends PaymentState{

    @Override
    void handleEvent(RuleEngine ctx, PaymentType paymentType) {
        // activate that membership.
        switch (paymentType) {
            case MEMBERSHIP:
                ctx.membership = 2; // setting membership to 2 days
                System.out.println("In Membership (MEMBERSHIP): " + ctx.membership + "\n");
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
