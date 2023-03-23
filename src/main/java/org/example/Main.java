package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.Scanner;

public class Main
{
    public static final Logger logger = (Logger) LogManager.getLogger(Main.class);
    public static void main(String[] args)
    {
        logger.info("Calculator Application started...");
        calculator();
        logger.info("Calculator Application ended");
    }
    public static void calculator()
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do
        {
            System.out.println("Welcome to Scientific Calculator");
            System.out.println("------------------------------");
            System.out.println("Give your choice");
            System.out.println("1. Square root function - √x");
            System.out.println("2. Factorial function - x!");
            System.out.println("3. Natural logarithm (base )е ln(x)");
            System.out.println("4. Power function - x^b");
            System.out.println("0: Exit the Application");

            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    logger.info("SQUARE ROOT FUNCTION IMPLEMENTING...");
                    System.out.println("Enter a number: ");
                    double sqrt_number = sc.nextDouble();
                    logger.info("Input Number received: "+ sqrt_number);
                    double sqrt_ans = getSqrt(sqrt_number);
                    System.out.println("The square root is: "+sqrt_ans);
                    logger.info("SQUARE ROOT: "+ sqrt_ans);
                    break;

                case 2:
                    logger.info("FACTORIAL FUNCTION IMPLEMENTING...");
                    System.out.println("Enter a number: ");
                    int fact_number = sc.nextInt();
                    logger.info("Input Number received: "+ fact_number);
                    double fact_ans = getFact(fact_number);
                    System.out.println("The FACTORIAL is: "+fact_ans);
                    logger.info("FACTORIAL: "+ fact_ans);
                    break;

                case 3:
                    logger.info("NATURAL LOGARITHM FUNCTION IMPLEMENTING...");
                    System.out.println("Enter a number: ");
                    double log_number = sc.nextDouble();
                    logger.info("Input Number received: "+ log_number);
                    double log_ans = getLog(log_number);
                    System.out.println("The NATURAL LOGARITHM is: "+log_ans);
                    logger.info("NATURAL LOGARITHM: "+ log_ans);
                    break;

                case 4:
                    logger.info("POWER FUNCTION IMPLEMENTING...");
                    System.out.println("Enter a number: ");
                    double pow_number = sc.nextDouble();
                    logger.info("Input Number received: "+ pow_number);

                    System.out.println("Enter a base: ");
                    double pow_base = sc.nextDouble();
                    logger.info("Input Base received: "+ pow_base);

                    double pow_ans = getPow(pow_base, pow_number);
                    System.out.println("The POWER is: "+pow_ans);
                    logger.info("POWER FUNCTION: "+ pow_ans);
                    break;

                case 0:
                logger.info("Exiting...");
                    System.out.println("Exiting...");
                    break;

                default:
                    logger.info("Invalid choice...");
                    System.out.println("Invalid choice. Please try again.");
            }


        }while(choice!=0);

        sc.close();

    }

    //function for square root
    public static double getSqrt(double sqrt_number)
    {
        return Math.sqrt(sqrt_number);
    }

    //function for Factorial
    public static int getFact(int fact_number)
    {
        int fact_ans= 1;
        for(int i = 1; i <= fact_number; i++)
        {
            fact_ans *= i;
        }
        return fact_ans;
    }

    //Function for Logarithm
    public static double getLog(double log_number)
    {
        return Math.log(log_number);
    }

    //Function for Power Function
    public static double getPow(double pow_base, double pow_number)
    {
        return Math.pow(pow_base, pow_number);
    } //
}