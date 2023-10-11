import java.util.*;
import java.text.DecimalFormat;

class Currency_Converter {
    public static void main(String[] args) {
        double rupee, dollar, pound, code, euro, KWD;
        DecimalFormat f = new DecimalFormat("##.###");
        Scanner sc = new Scanner(System.in);

        // ANSI color codes
        String skyBlue = "\u001B[36m";
        String blue = "\u001B[35m";
        String green = "\u001B[32m";
        String cyan = "\u001B[36m";
        String yellow = "\u001B[33m";
        String red = "\u001B[31m";
        String resetColor = "\u001B[0m";

        System.out.println(skyBlue + "*** WelCome to Currency Converter Project ***" + resetColor);
        System.out.println(green +"1: Rupees\n2: Dollar\n3: Pound\n4: Euro\n5: Kuwaiti dinar\n"+resetColor);
         System.out.println(cyan +"Enter the currency code"+resetColor);


        code = sc.nextInt();

        if (code == 1) {
            System.out.println(yellow +"Enter amount in rupees:");
            rupee = sc.nextFloat();
            dollar = rupee / 75;
            System.out.println(blue  + "Dollar: " + resetColor + f.format(dollar));
            pound = rupee / 101;
            System.out.println(blue  + "Pound: " + resetColor + f.format(pound));
            euro = rupee / 84;
            System.out.println(blue  + "Euro: "  + resetColor+ f.format(euro));
            KWD = rupee / 250;
            System.out.println(blue +"Kuwaiti dinar: "  + resetColor+ f.format(KWD)  );
        } else if (code == 2) {
            System.out.println(yellow +"Enter amount in dollar:");
            dollar = sc.nextFloat();
            rupee = dollar * 75;
            System.out.println(cyan + "Rupees: " + resetColor + f.format(rupee) );
            pound = dollar * 0.72;
            System.out.println(cyan + "Pound: "  + resetColor+ f.format(pound) );
            euro = dollar * 0.88;
            System.out.println(cyan + "Euro: "  + resetColor+ f.format(euro) );
            KWD = dollar * 0.30;
            System.out.println(cyan +"Kuwaiti dinar: "  + resetColor+ f.format(KWD));
        } else if (code == 3) {
            System.out.println(yellow +"Enter amount in Pound:"+resetColor);
            pound = sc.nextFloat();
            rupee = pound * 101;
            System.out.println(green + "Rupees: "  + resetColor+ f.format(rupee) );
            dollar = pound * 1.35;
            System.out.println(green  + "Dollar: "  + resetColor+ f.format(dollar) );
            euro = pound * 1.36;
            System.out.println(green  + "Euro: "  + resetColor+ f.format(euro) );
            KWD = pound * 0.4;
            System.out.println(green +"Kuwaiti dinar: "  + resetColor+ f.format(KWD));
        } else if (code == 4) {
            System.out.println(yellow +"Enter amount in Euro:"+resetColor);
            euro = sc.nextFloat();
            rupee = euro * 84;
            System.out.println(cyan + "Rupees: " + resetColor + f.format(rupee));
            dollar = euro * 1.12;
            System.out.println(cyan + "Dollar: "  + resetColor+ f.format(dollar));
            pound = euro * 0.73;
            System.out.println(cyan+ "Pound: "+ resetColor + f.format(pound) );
            KWD = euro * 0.34;
            System.out.println(cyan +"Kuwaiti dinar: " + f.format(KWD));
        } else if (code == 5) {
                        System.out.println(yellow +"Enter amount in Kuwaiti dinar:"+resetColor);

            KWD = sc.nextFloat();
            rupee = KWD * 250;
            System.out.println(skyBlue+ "Rupees: "  + resetColor+ f.format(rupee));
            dollar = KWD * 3.30;
            System.out.println(skyBlue+ "Dollar: "  + resetColor+ f.format(dollar) );
            pound = KWD * 2.5;
            System.out.println(skyBlue + "Pound: "  + resetColor+ f.format(pound));
            euro = KWD * 2.94;
            System.out.println(skyBlue +"Euro: " + resetColor + f.format(euro));
        } else {
            System.out.println(red + "Invalid Choice!"+resetColor);
        }
    }
}
