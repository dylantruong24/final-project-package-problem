import java.util.Scanner;

public class PandaBuy {
    private String serviceName;

    public String getServiceName() {
        return this.serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //create objects
        PandaBuy service = new PandaBuy();
        PackageManager packageManager = new PackageManager();
        FirstClassPackage fcpkg1 = new FirstClassPackage();
        OvernightPackage ovpkg1 = new OvernightPackage();
        PriorityPackage prpkg1 = new PriorityPackage();
        TwoDayPackage tdpkg1 = new TwoDayPackage();

        //load data into objects
        service.setServiceName("PandaBuy");

        fcpkg1.setAddress("1021 S Water Blvd; Testing, Ohio 91001; USA");
        fcpkg1.setSender("Tustin Jan");
        fcpkg1.setRecipient("Dylan Truong");
        fcpkg1.setPackageType("First Class Package");
        fcpkg1.setPrice(19.99);
        fcpkg1.setWeight(5);
        fcpkg1.setDistance(400);

        ovpkg1.setAddress("578 Beaumont Ave; Testsite, Alabama 87851; USA");
        ovpkg1.setSender("Jerry Cat");
        ovpkg1.setRecipient("Tom Mouse");
        ovpkg1.setPackageType("Overnight Package");
        ovpkg1.setPrice(6.99);
        ovpkg1.setWeight(2);
        ovpkg1.setDistance(250);

        prpkg1.setAddress("12840 Bollock St; Testhouse, Florida 18923; USA");
        prpkg1.setSender("Finn Dahuman");
        prpkg1.setRecipient("Jake Dadog");
        prpkg1.setPackageType("Priority Package");
        prpkg1.setPrice(25.99);
        prpkg1.setWeight(4);
        prpkg1.setDistance(800);

        tdpkg1.setAddress("4839 Harry Pl; Testtower, California 91801; USA");
        tdpkg1.setSender("Dylan Truong");
        tdpkg1.setRecipient("Johnson Smith");
        tdpkg1.setPackageType("Two-Day Package");
        tdpkg1.setPrice(10.99);
        tdpkg1.setWeight(7);
        tdpkg1.setDistance(1120);

        packageManager.addPackage(fcpkg1);
        packageManager.addPackage(ovpkg1);
        packageManager.addPackage(prpkg1);
        packageManager.addPackage(tdpkg1);

        boolean running = true;
        while (running) { //prompt user on actions until exit
         System.out.println("========================================================================================");
         System.out.println("This is the delivery service " + service.getServiceName() + ". Select an action:");
         System.out.println("(1)Package List | (2)Add Package | (3)Remove Package | (4)Pricing Info | (5)Exit ");
         
         int select = scanner.nextInt();

         switch (select) {
            case 1: 
                packageManager.printList();
                break;
            case 2:
                packageManager.addNewPackage(scanner);
                break;
            case 3:
                System.out.print("Which package #[] would you like to remove?: ");
                int remove = scanner.nextInt();
                packageManager.removePackage(remove);
                break;
            case 4:
                packageManager.printPricing();
                break;
            case 5:
                running = false;
                System.out.println("Program stopped.");
                break;
            default:
                System.out.println("Invalid selection. Please choose a valid option.");
                break;
         }
       }
    }
}
