public abstract class BasePackage {
    private String address;
    private String sender;
    private String recipient;
    private String packageType;
    private double basePrice;
    private double weight;
    private double distance;

    //get
    public String getAddress() {
        return address;
    }
    public String getSender() {
        return sender;
    }
    public String getRecipient() {
        return recipient;
    }
    public String getPackageType() {
        return packageType;
    }
    public double getPrice() {
        return basePrice;
    }
    public double getWeight() {
        return weight;
    }
    public double getDistance() {
        return distance;
    }

    //set
    public void setAddress(String address) {
        this.address = address;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }
    public void setPrice(double basePrice) {
        this.basePrice = basePrice;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }

    //print info
    public void list() { 
        double total = calculateCost();
        double base = getPrice();

        System.out.println("--------------------------------------------------");
        System.out.println("Package Type: " + getPackageType());
        System.out.println("Sender: " + getSender());
        System.out.println("Recipient: " + getRecipient());
        System.out.println("Recipient Address: " + getAddress());
        System.out.println("Total: $" + String.format("%.2f", total));
        System.out.println("Base Price: $" + getPrice() + " (+$" + String.format("%.2f", (total-base)) + " shipping fee)");
    }

    public abstract double calculateCost(); //abstract function, used in each respective function
}
