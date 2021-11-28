public class RuleEngine {
    static final PaymentState PhysicalProduct = new PhysicalProduct();
    static final PaymentState Book = new Book();
    static final PaymentState Membership = new Membership();
    static final PaymentState Upgrade = new Upgrade();
    static final PaymentState Video = new Video();

    private PaymentState currentState = Membership;
    protected Integer membership;
    protected String packingSlip;
    protected String emailId;
    protected String commissionPayment;

    RuleEngine(Integer membership, String emailId) {
        this.membership = membership;
        packingSlip = "";
        this.emailId = emailId;
        commissionPayment = "";
    }

    PaymentState getCurrentState() {
        return currentState;
    }
    void setCurrentState (PaymentState paymentState) {
        this.currentState = currentState;
    }


}
