public class TwoDayPackage extends BasePackage {
    @Override //override from BasePackage class
    public double calculateCost() {
        double distance = getDistance();
        double distancePrice;

        if (distance > 1800) {
            distancePrice = .90;
        }
        else if (distance > 1400) {
            distancePrice = .75;
        }
        else if (distance > 1000) {
            distancePrice = .70;
        }
        else if (distance > 600) {
            distancePrice = .65;
        }
        else if (distance > 300) {
            distancePrice = .60;
        }
        else if (distance > 150) {
            distancePrice = .55;
        }
        else if (distance > 50) {
            distancePrice = .50;
        }
        else {
            distancePrice = .45;
        }

        return (getPrice() + (getWeight() * distancePrice));
    }

    @Override
    public void list() {
        super.list();
    }
}