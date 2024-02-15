import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PackageManager {
    private List<BasePackage> packages;

    public PackageManager() {
        packages = new ArrayList<>();
    }

    public void addPackage(BasePackage p) {
        packages.add(p);
    }

    public void printList() { //print entire array list
        System.out.println("--------------------------------------------------");
        System.out.println("[" + packages.size() + "] package(s) in the collection. TOTAL COST: $" + calculateTotal());
        int counter = 1;
        for (BasePackage p : packages) {
            System.out.println("--------------------------------------------------");
            System.out.println("PACKAGE #[" + counter + "]");
            p.list();
            counter++;
        }
    }

    public String calculateTotal() {
        double total = 0;
        for (BasePackage p : packages) {
            total += p.calculateCost();
        }
        return String.format("%.2f", total);
    }

    public void removePackage(int num) {
        if (num < 1 || num > packages.size()) {
            System.out.println("[Invalid position. No package removed.]");
            return;
        }
        packages.remove(num - 1);
        System.out.println("[Package #[" + num + "] successfully removed.]");
    }

    public void addNewPackage(Scanner scanner) {
        System.out.println("-----------------------------");
        System.out.println("Please fill out the package details:");
        scanner.nextLine();

        System.out.print("Package Type [ (1)Overnight | (2)First Class | (3)Priority | (4)Two-Day ]: ");
        int packageType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Sender: ");
        String sender = scanner.nextLine().trim();

        System.out.print("Recipient: ");
        String recipient = scanner.nextLine().trim();

        System.out.print("Recipient Address: ");
        String address = scanner.nextLine().trim();

        System.out.print("Base Price of Item: ");
        double basePrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Weight of Item (lbs.): ");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Distance to Recipient (mi.): ");
        double distance = scanner.nextDouble();
        scanner.nextLine();

        switch (packageType) {
            case 1: 
                OvernightPackage ovpkg = new OvernightPackage();
                ovpkg.setAddress(address);
                ovpkg.setSender(sender);
                ovpkg.setRecipient(recipient);
                ovpkg.setPackageType("Overnight Package");
                ovpkg.setPrice(basePrice);
                ovpkg.setWeight(weight);
                ovpkg.setDistance(distance);
                addPackage(ovpkg);
                System.out.println("[Overnight Package successfully added.]");
                break;
            case 2: 
                FirstClassPackage fcpkg = new FirstClassPackage();
                fcpkg.setAddress(address);
                fcpkg.setSender(sender);
                fcpkg.setRecipient(recipient);
                fcpkg.setPackageType("First Class Package");
                fcpkg.setPrice(basePrice);
                fcpkg.setWeight(weight);
                fcpkg.setDistance(distance);
                addPackage(fcpkg);
                System.out.println("[First Class Package successfully added.]");
                break;
            case 3: 
                PriorityPackage prpkg = new PriorityPackage();
                prpkg.setAddress(address);
                prpkg.setSender(sender);
                prpkg.setRecipient(recipient);
                prpkg.setPackageType("Priority Package");
                prpkg.setPrice(basePrice);
                prpkg.setWeight(weight);
                prpkg.setDistance(distance);
                addPackage(prpkg);
                System.out.println("[Priority Package successfully added.]");
                break;
            case 4: 
                TwoDayPackage tdpkg = new TwoDayPackage();
                tdpkg.setAddress(address);
                tdpkg.setSender(sender);
                tdpkg.setRecipient(recipient);
                tdpkg.setPackageType("Two-Day Package");
                tdpkg.setPrice(basePrice);
                tdpkg.setWeight(weight);
                tdpkg.setDistance(distance);
                addPackage(tdpkg);
                System.out.println("[Two-Day Package successfully added.]");
                break;
            default:
                System.out.println("[Invalid package type. Package failed to add.]");
                break;
        }
    }

    public void printPricing() {
        System.out.println("+-----------------+-----------------+------------------+-----------------++--------------+");
        System.out.println("|    OVERNIGHT    |   FIRST CLASS   |     PRIORITY*    |     TWO-DAY     ||  [DISTANCE]  |");
        System.out.println("+-----------------+-----------------+------------------+-----------------++--------------+");
        System.out.println("|             1.1 |            1.05 |            1.025 |              .9 ||       1800 + |");
        System.out.println("+-----------------+-----------------+------------------+-----------------++--------------+");
        System.out.println("|            .875 |             .85 |             .825 |             .75 ||  1401 - 1800 |");
        System.out.println("+-----------------+-----------------+------------------+-----------------++--------------+");
        System.out.println("|            .825 |              .8 |             .775 |              .7 ||  1001 - 1400 |");
        System.out.println("+-----------------+-----------------+------------------+-----------------++--------------+");
        System.out.println("|            .775 |             .75 |             .725 |             .65 ||   601 - 1000 |");
        System.out.println("+-----------------+-----------------+------------------+-----------------++--------------+");
        System.out.println("|            .725 |              .7 |             .675 |              .6 ||    301 - 600 |");
        System.out.println("+-----------------+-----------------+------------------+-----------------++--------------+");
        System.out.println("|            .675 |             .65 |             .625 |             .55 ||    151 - 300 |");
        System.out.println("+-----------------+-----------------+------------------+-----------------++--------------+");
        System.out.println("|            .625 |              .6 |             .575 |              .5 ||     51 - 150 |");
        System.out.println("+-----------------+-----------------+------------------+-----------------++--------------+");
        System.out.println("|            .575 |             .55 |             .525 |             .45 ||         < 50 |");
        System.out.println("+-----------------+-----------------+------------------+-----------------++--------------+");
        System.out.println();
        System.out.println("SHIPPING COST = WEIGHT(lbs.) x PRICE(based on type and distance(mi.))");
        System.out.println("Please note Overnight Rabbit Express adds another 20% on top of this cost.");
    }
}
