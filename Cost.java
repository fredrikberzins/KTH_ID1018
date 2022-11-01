class Cost
{
    public static void main (String[] args)
    {
        System.out.println("Cost");
        System.out.println();

        java.util.Scanner in = new java.util.Scanner(System.in);
        in.useLocale(java.util.Locale.US);

        System.out.print("Amount: ");
        int amount = in.nextInt();
        System.out.print("Price per: ");
        double price = in.nextDouble();

        double cost = amount * price;

        System.out.println("Total cost: " + cost);
    }
}