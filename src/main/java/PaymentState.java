public abstract class PaymentState {
    void handleEvent(RuleEngine ctx, PaymentType paymentType) {
        throw new IllegalStateException("this operation not valid");
    }
    void generateEmail(RuleEngine ctx, String message) {
      //  ctx.emailId is accessible
        System.out.println(message);
        //posting this message to the email-id
    }
}
