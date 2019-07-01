public class UbiqumShoppingCart {

    public static void main(String[] args){

        Product pencil = new Product("pencil", 3);
        Product vacuumCleaner = new Product("vacuum cleaner", 100);
        Product bike = new Product("bike", 500);

        Cart cart = new Cart();

        cart.add(vacuumCleaner);
        cart.add(vacuumCleaner);
        cart.add(vacuumCleaner);
        cart.add(vacuumCleaner);
        cart.add(pencil);
        cart.add(pencil);
        cart.add(pencil);
        cart.add(pencil);
        cart.add(bike);

        System.out.println(cart.toString());

//        cart.replaceProduct(vacuumCleaner, pencil);

        System.out.println(cart.toString());
        System.out.println(cart.totalPrice());

    }
}
