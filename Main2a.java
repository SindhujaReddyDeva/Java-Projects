import java.util.Scanner;
public class Main2a{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Panel ID : ");
        int PanelID = sc.nextInt();
        System.out.println("Enter the Energy generated in Kwh : ");
        double Energygenerated= sc.nextDouble();
        System.out.println("Enter the number of solar panels : ");
        int Nosolarpanels= sc.nextInt();
        System.out.println("Enter the System Status : ");
        char SystemStatus= sc.next().charAt(0);

        System.out.println(" Panel ID : " + PanelID);
        System.out.println(" Energy generated in Kwh : " + Energygenerated +" Kwh ");
        System.out.println(" Number of Solar panels : " + Nosolarpanels);
        System.out.println(" System Status : " + SystemStatus);

    }
}