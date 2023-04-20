package model;

// This enum contains the diferents states for a Repair.
public enum EnumStatusRepair {
    PENDING("Pending"),
    IN_PROGRESS("In progress"),
    CANCELLED("Cancelled"),
    ACCEPTED("Accepted"),
    DENIED("Denied"),
    FINISHED("Finished");

    private final String label;

    EnumStatusRepair(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
