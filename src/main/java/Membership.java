import java.util.EnumMap;
import java.util.Map;

public class Membership implements PaymentState{

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
        // activate that membership.
        switch (paymentType) {
            case MEMBERSHIP:
                ctx.membership = Boolean.TRUE; // setting membership to 2 days
                System.out.println("In Membership (MEMBERSHIP): " + ctx.membership + "\n");
                break;
            case MEMBERSHIP_UPGRADE:
                ctx.message = "Membership is activated\n";
                generateEmail(ctx);
                break;
            default:
                break;
        }
    }
}
