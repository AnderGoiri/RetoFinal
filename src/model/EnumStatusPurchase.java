package model;

public enum EnumStatusPurchase {
	NEW("New"),
	PENDING_PAYMENT("Pending"),
	PAYMENT_RECEIVED("Payment Received"),
	PAYMENT_ACCEPTED("Payment Accepted"),
	PAYMENT_DENIED("Payment Denied"),
	CANCELLED("Cancelled"),
	CLOSED("Closed");
	
    private final String label;

    EnumStatusPurchase(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
	

}
