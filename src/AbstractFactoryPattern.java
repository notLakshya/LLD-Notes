interface PaymentGateway {
    void pay();
}
class Paypal implements PaymentGateway {
    public void pay() {
        System.out.println("Paying via PayPal");
    }
}
class PayU implements PaymentGateway {
    public void pay() {
        System.out.println("Paying via PayU");
    }
}
interface Innvoice {
    void generateInvoice();
}
class GSTInvoice implements Innvoice {
    public void generateInvoice() {
        System.out.println("Generating GST Invoice");
    }
}
class USTInvoice implements Innvoice {
    public void generateInvoice() {
        System.out.println("Generating UST Invoice");
    }
}

interface CountryFactory {
    PaymentGateway accessPaymentGateway(String gatewayName);
    Innvoice accessInvoice(String invoice);
}
class IndiaFactory implements CountryFactory {
    public PaymentGateway accessPaymentGateway(String gatewayName) {
        return new PayU();
    }
    public Innvoice accessInvoice(String invoice) {
        return new GSTInvoice();
    }
}
class USFactory implements CountryFactory {
    public PaymentGateway accessPaymentGateway(String gatewayName) {
        return new Paypal();
    }
    public Innvoice accessInvoice(String invoice) {
        return new USTInvoice();
    }
}
class PaymentService {
    private PaymentGateway paymentGateway;
    private Innvoice innvoice;
    private String gatewayName;
    public PaymentService(PaymentGateway paymentGateway, Innvoice innvoice, String gatewayName) {
        this.paymentGateway = paymentGateway;
        this.innvoice = innvoice;
        this.gatewayName = gatewayName;
    }
    public PaymentService(CountryFactory countryFactory, String gatewayName, String invoice) {
        this.paymentGateway = countryFactory.accessPaymentGateway(gatewayName);
        this.innvoice = countryFactory.accessInvoice(invoice);
        this.gatewayName = gatewayName;
    }
    public void checkout() {
        paymentGateway.pay();
        innvoice.generateInvoice();
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(
                new IndiaFactory(),
                "PayU",
                "GST"
        );
        paymentService.checkout();
        PaymentService paymentServiceUS = new PaymentService(
                new USFactory(),
                "Paypal",
                "UST"
        );
        paymentServiceUS.checkout();
    }
}
