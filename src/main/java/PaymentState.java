public abstract class PaymentState {

    void activateMembership(RuleEngine ctx, PaymentType paymentType) {
        throw new IllegalStateException("this operation not valid");
    }
    void upgradeMembership(RuleEngine ctx, PaymentType paymentType) {
        throw new IllegalStateException("this operation not valid");
    }
    void handleEvent(RuleEngine ctx, PaymentType paymentType) {
        throw new IllegalStateException("this operation not valid");
    }
}
