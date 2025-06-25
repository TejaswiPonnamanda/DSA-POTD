package lld.design.designPatterns;

public class Payment {
    private final String paymentType;
    private final double amount;

    // Private constructor, only accessible from the builder
    private Payment(PaymentBuilder builder) {
        this.paymentType = builder.paymentType;
        this.amount = builder.amount;
    }

    // Getters (optional)
    public String getPaymentType() {
        return paymentType;
    }

    public double getAmount() {
        return amount;
    }

    // Builder Class
    public static class PaymentBuilder {
        private String paymentType;
        private double amount;

        public PaymentBuilder paymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public PaymentBuilder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }

    // Test method (you can call this from main or any client code)
    public static void main(String[] args) {
        Payment payment = new Payment.PaymentBuilder()
                .paymentType("UPI")
                .amount(500)
                .build();

        System.out.println("Payment Type: " + payment.getPaymentType());
        System.out.println("Amount: " + payment.getAmount());
    }
}
