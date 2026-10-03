import java.util.Scanner;
public class Main2c{
    static double calculateTotalEnergy(double morning, double evening){
        return morning+evening;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);

        System.out.println("ENTER MORNING ENERGY : ");
        double morning=sc.nextDouble();
        System.out.println("ENTER EVENING ENERGY : ");
        double evening =sc.nextDouble();

        System.out.println(calculateTotalEnergy(morning ,evening));
    }
}