/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labex11;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


/**
 *
 * @author Desktop pc
 */
public class foodprgrm
{
    public static void main(String args[])
    {
       ArrayList<String> menu = new ArrayList<String>();
        HotelThread Thread1 = new HotelThread("Thread 1");
        HotelThread Thread2 = new HotelThread("Thread 2");

        Thread1.start();

        try
        {
            Thread1.join();
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }

        System.out.println();

        Thread2.start();

        try
        {
            Thread2.join();
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }

        System.out.println();

       
        System.out.println("Enter the Items ,Type x to Finish");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            String item = reader.readLine();

            while (!item.equalsIgnoreCase("x"))
            {
                menu.add(item);
                item = reader.readLine();
            }

        }
        catch (IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }

       Client client1 = Thread1.GetCClient();
        Client client2 = Thread2.GetClient();

        System.out.println("Order For Client-1");

        for (String food : client1)
        {
            if (menu.contains(food))
            {
                System.out.println(food + "is present");
            } else
            {
                System.out.println(food + "is Not present");
            }
        }

        System.out.println("Order For Client-2");

        for (String food : client2)
        {
            if (menu.contains(food))
            {
                System.out.println(food + "is present");
            } else
            {
                System.out.println(food + "is Not present");
            }
        }

        System.out.println("---------Thankyou----- Visitagain--------");
    }
}
class Client extends ArrayList<String>
{
  

   
    private String name;

   
    public Client()
    {
        super();
    }

   
    public Client(Client obj)
    {
        super(obj);
    }

    
    public Client(int size)
    {
        super(size);
    }

  
    public void SetName(String Name)
    {
        name = Name;
    }

   
    public String GetName()
    {
        return name;
    }
}

class HotelThread extends Thread
{
    private Client client;

    public HotelThread(String ThreadName)
    {
        super(ThreadName);
        client = new Client();
    }

    public void run()
    {
        synchronized (client)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try
            {
                System.out.println("From, " + super.getName());

                System.out.println("Enter Name: ");
                String name = reader.readLine();

                customer.SetName(name);

                System.out.println("Enter the Items ,Type x to Finish:");

                String food = reader.readLine();

                while (!food.equalsIgnoreCase("x"))
                {
                    client.add(food);
                    food = reader.readLine();
                }

            }
            catch (IOException e)
            {
                System.out.println(e);
                System.exit(1);
            }
        }
    }

    
    Client GetClient()
    {
        return client;
    }
}
