import java.util.Map;

public interface PaymentState {
    default void handleEvent(RuleEngine ctx, PaymentType paymentType) {
        throw new IllegalStateException("this operation not valid");
    }

    default void generateEmail(RuleEngine ctx) {
      //  ctx.emailId is accessible
        System.out.println(ctx.message);
        //posting this message to the email-id
    }

    public Map<PaymentType, PaymentState> getRule();


}
