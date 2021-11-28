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

    RuleEngine(String emailId) {
        this.membership = 0;
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

    void handleClientEvent(PaymentType paymentType) {
        if (membership > 0) {
            currentState.handleEvent(this, paymentType);
        } else {
            System.out.println("Please activate Membership\n");
        }
    }
}
