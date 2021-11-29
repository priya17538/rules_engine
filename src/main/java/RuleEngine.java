import java.util.EnumMap;
import java.util.Map;

public class RuleEngine {
    public static final PaymentState PHYSICAL_PRODUCT = new PhysicalProduct();
    public static final PaymentState BOOK = new Book();
    public static final PaymentState MEMBERSHIP = new Membership();
    public static final PaymentState UPGRADE = new Upgrade();
    public static final PaymentState VIDEO = new Video();

    private PaymentState currentState = MEMBERSHIP;
    protected Boolean membership;
    protected String packingSlip;
    protected String emailId;
    protected String message;
    protected String commissionPayment;

    RuleEngine(String emailId) {
        this.membership = Boolean.FALSE;
        packingSlip = "";
        this.emailId = emailId;
        commissionPayment = "";
        message = "";
        initializeStateMachine();
    }

    private void initializeStateMachine() {
        Map<PaymentType, PaymentState> membershipRule = new EnumMap<>(PaymentType.class);
        membershipRule.put(PaymentType.MEMBERSHIP, MEMBERSHIP);
        membershipRule.put(PaymentType.BOOK, BOOK);
        membershipRule.put(PaymentType.MEMBERSHIP_UPGRADE, MEMBERSHIP);
        membershipRule.put(PaymentType.PHYSICAL_PRODUCT, PHYSICAL_PRODUCT);
        membershipRule.put(PaymentType.PHYSICAL_PRODUCT_Book, PHYSICAL_PRODUCT);
        membershipRule.put(PaymentType.VIDEO, VIDEO);
        Membership.setRule(membershipRule);

        Map<PaymentType, PaymentState> bookrule = new EnumMap<>(PaymentType.class);
        bookrule.put(PaymentType.UPGRADE, UPGRADE);
        bookrule.put(PaymentType.VIDEO, VIDEO);
        bookrule.put(PaymentType.MEMBERSHIP_UPGRADE, UPGRADE);
        bookrule.put(PaymentType.PHYSICAL_PRODUCT, PHYSICAL_PRODUCT);
        bookrule.put(PaymentType.PHYSICAL_PRODUCT_Book, BOOK);
        Book.setRule(bookrule);
        Video.setRule(bookrule);
        PhysicalProduct.setRule(bookrule);
        Upgrade.setRule(bookrule);
    }

    PaymentState getCurrentState() {
        return currentState;
    }
    void setCurrentState (PaymentState paymentState) {
        System.out.println("RuleEngine from current state: " + this.currentState + "to new state: " + paymentState + "\n");
        this.currentState = paymentState;
    }

    void handleClientEvent(PaymentType paymentType) {
        if(!currentState.getRule().containsKey(paymentType)) {
            System.out.println("\n Illegal Payment Type in current state");
            throw new IllegalStateException("Event is not valid in current state.");
        }
        setCurrentState(currentState.getRule().get(paymentType));
        currentState.handleEvent(this, paymentType);
    }
}
