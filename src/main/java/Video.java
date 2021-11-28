import java.util.Map;

public class Video implements PaymentState{
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
        //  “Learning to Ski,” add a free “First Aid” video to the packing slip (the result of a court
        //decision in 1997).
        if (paymentType == PaymentType.VIDEO) {
            ctx.packingSlip += "\nadd a free “First Aid” video to the packing slip\n";
            System.out.println("In Video packingSlip(VIDEO): " + ctx.packingSlip);
        }
    }
}
