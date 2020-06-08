public class lab6 {
    public static void main(String[] args) {
        System.out.println("Уткін Владислав");
        System.out.println("9227%13="+9227%13);
        System.out.println("Варіант: Тарифи мобільної компанії");
        Tariffs T = new Tariffs();
        T.sortTariffsDecrease();
        T.outP();
        T.search(60);
        T.numOfCustomers();
     }
}

class one {
    private int payPerMonth;
    private double textPrice;
    private double talkPrice;
    private int internetPrice;
    private int customersOnThisTariff;
    private String name;

    public one(int payPerMonth, double textPrice, double talkPrice, int
            internetPrice, int customersOnThisTariff, String name) {
        this.customersOnThisTariff = customersOnThisTariff;
        this.internetPrice = internetPrice;
        this.name = name;
        this.payPerMonth = payPerMonth;
        this.talkPrice = talkPrice;
        this.textPrice = talkPrice;
    }

    public double getPriceTalk() {
        return talkPrice;
    }

    public double getPriceText() {
        return textPrice;
    }

    public double getPriceInternet() {
        return internetPrice;
    }

    public int getCustomers() {
        return customersOnThisTariff;
    }

    public int getPricePerMonth() {
        return payPerMonth;
    }

    public String getNameOfTariff() {
        return name;
    }
}
class EverythingPayed extends one {
    public EverythingPayed(int payPerMonth, double textPrice, double talkPrice,
                           int internetPrice, int customersOnThisTariff, String name){

        super(payPerMonth, textPrice, talkPrice, internetPrice,

                customersOnThisTariff, name);
    }
}
class Tariffs {
    private one oneCompany[];

    public Tariffs() {
        oneCompany = new one[]{
                new EverythingPayed(0, 0.10, 0.15, 10, 5000, "Nothing Unlim"),

                new UnlimInternetTalkText(60, 0, 0, 0, 35000, "Unlim Talk + Text + Internet"),

                new unlimTalkPayedTextInternet(10, 0.10, 0.15, 10, 10000, "Unlim Talk&quot"),

                new UnlimTextPayedTalkInternet(5, 0, 0.15, 10, 2000, "Unlim text"),

                new UnlimTextTalkPayedInternet(20, 0, 0, 15, 6000, "Unlim Talk + Text & quot"),
        };
    }


    public void outP(){
        System.out.format("======================================================================================\n");

        System.out.printf("| Plan name |Cost PM|Inter. 1Gig |Text 1msg |Talk 1min |Customers |\n");
        System.out.format("======================================================================================\n");

        String leftAlighName="| %-28s |";
        String leftAlignCost=" %-5d |";
        String leftAlignPrices=" %-10s |";
        String leftAlignText="%-9s |";
        for(int i=0; i<oneCompany.length; i++){
            System.out.format(leftAlighName,

                    oneCompany[i].getNameOfTariff());

            System.out.format(leftAlignCost,

                    oneCompany[i].getPricePerMonth());

            String internetPrice = String.format("%.2f",

            oneCompany[i].getPriceInternet());

            System.out.format(leftAlignPrices, internetPrice);
            String textPrice = String.format("%.2f",

            oneCompany[i].getPriceText());

            System.out.format(leftAlignText, textPrice);
            String talkPrice = String.format("%.2f",

            oneCompany[i].getPriceTalk());

            System.out.format(leftAlignText, talkPrice);
            System.out.format(leftAlignText, oneCompany[i].getCustomers());
            System.out.println();
        }

        System.out.format("======================================================================================");
    }
    public void search(int price){
        if(price<0){
            System.out.println("Wrong price entered. ");
        }else{
            System.out.println("Tariffs that are in your price range: ");
            boolean check=false;
            for(int i=0; i<oneCompany.length; i++){
                if(oneCompany[i].getPricePerMonth()<=price){

                    System.out.println(oneCompany[i].getNameOfTariff());

                    check=true;
                }
            }
            if(check==false){
                System.out.println("None found.");
            }
        }
    }
    public void numOfCustomers(){
        System.out.print("Total amount of customers: ");
        int temp=0;
        for(int i=0; i<oneCompany.length; i++){
            temp+=oneCompany[i].getCustomers();
        }
        System.out.println(temp);
    }
    public void sortTariffsIncrease(){
        one temp;
        for(int i=0; i<oneCompany.length; i++){
            for(int j=i+1; j<oneCompany.length; j++){

                if(oneCompany[j].getPricePerMonth()<=oneCompany[i].getPricePerMonth()){

                    temp=oneCompany[i];
                    oneCompany[i]=oneCompany[j];
                    oneCompany[j]=temp;
                }
            }
        }
    }
    public void sortTariffsDecrease(){
        one temp;
        for(int i=0; i<oneCompany.length; i++){
            for(int j=i+1; j<oneCompany.length; j++){

                if(oneCompany[j].getPricePerMonth()>=oneCompany[i].getPricePerMonth()){

                    temp=oneCompany[i];
                    oneCompany[i]=oneCompany[j];
                    oneCompany[j]=temp;
                }
            }
        }
    }
}
class UnlimInternetTalkText extends one{
    public UnlimInternetTalkText(int payPerMonth, double textPrice, double
            talkPrice, int internetPrice, int customersOnThisTariff, String name){
        super(payPerMonth, textPrice, talkPrice, internetPrice,

                customersOnThisTariff, name);
    }
}
class unlimTalkPayedTextInternet extends one{
    public unlimTalkPayedTextInternet(int payPerMonth, double textPrice, double
            talkPrice, int internetPrice, int customersOnThisTariff, String name){
        super(payPerMonth, textPrice, talkPrice, internetPrice,

                customersOnThisTariff, name);
    }
}
class UnlimTextPayedTalkInternet extends one{
    public UnlimTextPayedTalkInternet(int payPerMonth, double textPrice, double
            talkPrice, int internetPrice, int customersOnThisTariff, String name){
        super(payPerMonth, textPrice, talkPrice, internetPrice,

                customersOnThisTariff, name);
    }
}
class UnlimTextTalkPayedInternet extends one{
    public UnlimTextTalkPayedInternet(int payPerMonth, double textPrice, double
            talkPrice, int internetPrice, int customersOnThisTariff, String name){
        super(payPerMonth, textPrice, talkPrice, internetPrice,

                customersOnThisTariff, name);
    }
}