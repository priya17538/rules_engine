public class Upgrade extends PaymentState{
    @Override
    void handleEvent(RuleEngine ctx, PaymentType paymentType) {
        //  apply the upgrade.
        switch (paymentType) {
            case UPGRADE:
                ctx.membership += 2; // setting membership to +2 days
                System.out.println("In Upgrade (UPGRADE): " + ctx.membership + "\n");
                break;
            case MEMBERSHIP_UPGRADE:
                String message = "Membership is Upgraded\n";
                generateEmail(ctx, message);
                break;
            default:
                break;
        }
    }
}
