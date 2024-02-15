public class OvernightPackage extends BasePackage implements RabbitCarrier {
    @Override //override from BasePackage class
    public double calculateCost() {
        double distance = getDistance();
        double distancePrice;

        if (distance > 1800) {
            distancePrice = 1.1;
        }
        else if (distance > 1400) {
            distancePrice = .875;
        }
        else if (distance > 1000) {
            distancePrice = .825;
        }
        else if (distance > 600) {
            distancePrice = .775;
        }
        else if (distance > 300) {
            distancePrice = .725;
        }
        else if (distance > 150) {
            distancePrice = .675;
        }
        else if (distance > 50) {
            distancePrice = .625;
        }
        else {
            distancePrice = .575;
        }

        return getPrice() + rabbitExpress(getWeight() * distancePrice);
    }

    @Override
    public double rabbitExpress(double cost) {
        return cost * 1.2;
    }

    @Override
    public void list() {
        super.list();
    }
}