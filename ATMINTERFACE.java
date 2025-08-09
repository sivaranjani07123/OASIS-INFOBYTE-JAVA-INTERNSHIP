import java.util.ArrayList;
import java.util.Scanner;
public class ATMINTERFACE 
{
    static class UserAccount 
    {
        String ID, PIN;
        double initialbalance;
        ArrayList<String> history = new ArrayList<>();
        UserAccount(String id, String pin, double bal) 
        {
            this.ID = id; this.PIN = pin; this.initialbalance = bal;
        }
    }
    public static void main(String args[]) 
    {
        Scanner money = new Scanner(System.in);
        UserAccount u1 = new UserAccount("user1", "8967", 50000);
        UserAccount u2 = new UserAccount("user2", "5467", 30000);
        UserAccount current = null;
        for (int i = 0; i < 3; i++) 
        {
            System.out.println("\nID: ");
            String ID = money.nextLine();
            System.out.println("\nPIN: ");
            String PIN = money.nextLine();
            if (ID.equals(u1.ID) && PIN.equals(u1.PIN)) 
            {
                current = u1;
            }
            else if (ID.equals(u2.ID) && PIN.equals(u2.PIN)) 
            {
                current = u2;
            }
            else 
            {
                System.out.println("WRONG TRY AGAIN!");
            }
            if (current != null) 
            {
                break;
            }

        }
        if (current == null) 
        {
            System.out.println("LOGIN FAILED");
            money.close();
            return;
        }
        while (true) 
        {
            System.out.println("\n1)TRANSACTION HISTORY");
            System.out.println("\n2)WITHDRAWAL");
            System.out.println("\n3)DEPOSIT");
            System.out.println("\n4)TRANSFER");
            System.out.println("\n5)EXIT");
            System.out.println("\nENTER CHOICE :");
            String userchoice = money.nextLine();
            if ("1".equals(userchoice)) 
            {
                if (current.history.isEmpty()) 
                {
                    System.out.println("NO HISTORY");
                }
                else 
                {
                    current.history.forEach(System.out::println);
                    System.out.println("BALANCE: " + current.initialbalance);
                }
            } 
            else if ("2".equals(userchoice)) 
            {
                System.out.print("WITHDRAWAL AMOUNT: ");
                double A = Double.parseDouble(money.nextLine());
                if (A > 0 && A <= current.initialbalance) 
                {
                    current.initialbalance -= A;
                    current.history.add("WITHDRAW : " + A);
                    System.out.println("DONE.");
                } 
                else 
                {
                    System.out.println("INVALID.");
                }
            } 
            else if ("3".equals(userchoice)) 
            {
                System.out.println("DEPOSIT AMOUNT: ");
                double A = Double.parseDouble(money.nextLine());
                if (A > 0) 
                {
                    current.initialbalance += A;
                    current.history.add("DEPOSIT: " + A);
                    System.out.println("DONE.");
                } 
                else 
                {
                    System.out.println("INVALID.");
                }

            } 
            else if ("4".equals(userchoice)) 
            {
                System.out.print("Send to user1/user2: ");
                String to = money.nextLine();
                UserAccount dest = to.equals(u1.ID) ? u1 : to.equals(u2.ID) ? u2 : null;
                if (dest == null) 
                {
                    System.out.println("USER NOT FOUND.");
                }
                else if (dest == current) 
                {
                    System.out.println("Can't send to self.");
                }
                else 
                {
                    System.out.print("Amount: ");
                    double A = Double.parseDouble(money.nextLine());
                    if (A > 0 && A <= current.initialbalance) 
                    {
                        current.initialbalance -= A;
                        dest.initialbalance += A;
                        current.history.add("Sent " + A + " to " + dest.ID);
                        dest.history.add("Got " + A + " from " + current.ID);
                        System.out.println("TRANSFERRED.");
                    } 
                    else 
                    {
                        System.out.println("INVALID.");
                    }
                }
            } 
            else if ("5".equals(userchoice)) 
            {
                System.out.println("THANK YOU !");
                break;
            } 
            else 
            {
                System.out.println("INVALID CHOICE.");
            }
        }
        money.close();
    }
}