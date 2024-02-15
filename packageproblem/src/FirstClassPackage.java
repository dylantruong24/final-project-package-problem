public class FirstClassPackage extends BasePackage {
    @Override //override from BasePackage class
    public double calculateCost() {
        double distance = getDistance();
        double distancePrice;

        if (distance > 1800) {
            distancePrice = 1.05;
        }
        else if (distance > 1400) {
            distancePrice = .85;
        }
        else if (distance > 1000) {
            distancePrice = .80;
        }
        else if (distance > 600) {
            distancePrice = .75;
        }
        else if (distance > 300) {
            distancePrice = .70;
        }
        else if (distance > 150) {
            distancePrice = .65;
        }
        else if (distance > 50) {
            distancePrice = .60;
        }
        else {
            distancePrice = .55;
        }

        return (getPrice() + (getWeight() * distancePrice));
    }

    @Override
    public void list() {
        super.list();
    }
}