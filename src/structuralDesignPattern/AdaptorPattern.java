package structuralDesignPattern;

public class AdaptorPattern {
    interface PaymentGateway {
        void makePayment(String orderId, double price);
    }
    class PayUGateway implements PaymentGateway {
        @Override
        public void makePayment(String orderId, double price) {
            System.out.println("Payment for orderId: " + orderId + " $" + price);
        }
    }
    class RazorPayAPI {
        public void pay(String invoice, double cost){
            System.out.println("Payment for invoice: " + invoice + " $" + cost);
        }
    }
    class RazorPayAdaptor implements PaymentGateway {
        RazorPayAPI razorPayAPI;
        public RazorPayAdaptor() {
            this.razorPayAPI = new RazorPayAPI();
        }
        @Override
        public void makePayment(String orderId, double price) {
            System.out.println("Payment for orderId: " + orderId + " $" + price);
            razorPayAPI.pay(orderId, price);
        }
    }

    class CheckoutService {
        private PaymentGateway paymentGateway;
        public CheckoutService(PaymentGateway paymentGateway) {
            this.paymentGateway = paymentGateway;
        }
        public void checkout(String orderId, double price) {
            paymentGateway.makePayment(orderId, price);
        }
    }
    public static void main(String[] args) {
        AdaptorPattern razorPayAdaptor = new AdaptorPattern();
        CheckoutService checkoutService = razorPayAdaptor.new CheckoutService(razorPayAdaptor.new RazorPayAdaptor());
        checkoutService.checkout("12345", 100.0);
    }
}
