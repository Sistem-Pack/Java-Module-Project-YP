public class Calculator {

    double allPriceSum;
    String basket;

    public void addGoods(String newGoods, double goodsPrice) {
        if (this.basket == null) {
            this.basket = newGoods;
        } else {
            this.basket = this.basket + "\n" + ((this.basket.compareToIgnoreCase(newGoods) != 0) ? newGoods : "");
        }
        this.allPriceSum = this.allPriceSum + goodsPrice;
    }

    public String correctStringCurrency(int peopleCount) {
        double lastValue = (allPriceSum / peopleCount) % 100 / 10;
        String retValue;
        if ((int)lastValue == 1) {
            return "рублей";
        } else {
            switch ((int) Math.floor((allPriceSum / peopleCount) % 10)) {
                case 1:
                    retValue = "рубль";
                    break;
                case 2, 3, 4:
                    retValue = "рубля";
                    break;
                default:
                    retValue = "рублей";
                    break;
            }
        }
        return retValue;
    }
}
