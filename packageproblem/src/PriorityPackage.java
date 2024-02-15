public class PriorityPackage extends BasePackage {
    @Override //override from BasePackage class
    public double calculateCost() {
        double distance = getDistance();
        double distancePrice;

        if (distance > 1800) {
            distancePrice = 1.025;
        }
        else if (distance > 1400) {
            distancePrice = .825;
        }
        else if (distance > 1000) {
            distancePrice = .775;
        }
        else if (distance > 600) {
            distancePrice = .725;
        }
        else if (distance > 300) {
            distancePrice = .675;
        }
        else if (distance > 150) {
            distancePrice = .625;
        }
        else if (distance > 50) {
            distancePrice = .575;
        }
        else {
            distancePrice = .525;
        }

        return (getPrice() + (getWeight() * distancePrice));
    }

    @Override
    public void list() {
        super.list();
    }
}