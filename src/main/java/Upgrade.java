import java.util.Map;

public class Upgrade implements PaymentState {
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
        //  apply the upgrade.
        switch (paymentType) {
            case UPGRADE:
                ctx.membership = Boolean.TRUE; // setting membership to +2 days
                System.out.println("In Upgrade (UPGRADE): " + ctx.membership + "\n");
                break;
            case MEMBERSHIP_UPGRADE:
                ctx.message = "Membership is Upgraded\n";
                generateEmail(ctx);
                break;
            default:
                break;
        }
    }
}
