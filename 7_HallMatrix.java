import java.util.*;
import java.io.*;
class HallMatrix 
{   static Scanner sc=new Scanner(System.in);
    static final String FACULTY_FILE="faculty_credentials.txt";
    public static void main(String[] args) 
    {   ReservationManager manager=new ReservationManager();
        while(true)
        {
            System.out.println("\n---- Welcome to HallMatrix ----");
            System.out.println("1. Admin");
            System.out.println("2. Faculty");
            System.out.println("3. Student");
            System.out.println("0.Exit Program");
            System.out.print("Choose Option:");
            int choice=sc.nextInt();
            User currentUser=null;
            switch(choice)
            {   case 1:currentUser=adminLogin();break;
                case 2:currentUser=facultyLogin();break;
                case 3:currentUser=new StudentUser();break;
                case 0:loadingBar("Exiting Hall Matrix");
                    loadingBar("Thank You");
                    System.exit(0);
                default:System.out.println("Invalid Option!!");
            }
            if(currentUser!=null)
            {   currentUser.showRoleMenu(manager);}
        }   
    }

    static User adminLogin()
    {   System.out.print("Enter Admin Username:");
        String username=sc.next();
        System.out.print("Enter Password:");
        String password=sc.next();

        if(username.equals("admin")&&password.equals("admin123"))
        {   loadingBar("Logging in");
            return new AdminUser(username);
        }
        else
        {   System.out.println("Invalid Admin Credentials!!");
            return null;
        }
    }

    static User facultyLogin()
    {   System.out.print("Do you have an account(Yes/No):");
        String hasAccount=sc.next();
        if (hasAccount.equalsIgnoreCase("yes")) 
        {   System.out.print("Enter Username:");
            String username=sc.next();
            System.out.print("Enter Password:");
            String password=sc.next();
            if (validateFacultyLogin(username, password)) 
            {   loadingBar("Logging in");
                return new FacultyUser(username);
            } 
            else 
            {   System.out.println("Invalid credentials.");
                return null;
            }
        } 
        else 
        {   System.out.print("Enter new username: ");
            String newUsername = sc.next();
            System.out.print("Enter new password: ");
            String newPassword = sc.next();
            registerFaculty(newUsername, newPassword);
            System.out.println("Registered. Please login again.");
            return null;
        }
    }

    static boolean validateFacultyLogin(String username,String password)
    {   try
        {   FileReader fr=new FileReader(FACULTY_FILE);
            String line="";
            int ch;
            while((ch=fr.read())!=-1)
            {   if((char)ch=='\n')
                {   String[] parts=line.trim().split(",");
                    if(parts.length==2&&parts[0].equals(username)&&parts[1].equals(password))
                    {   fr.close();
                        return true;
                    }
                    line="";
                }
                else
                {   line+=(char)ch;}
            }
            fr.close();
        }
        catch(IOException e)
        {   System.out.println("Error reading faculty credentials.");}
        return false;
    }

    static void registerFaculty(String username,String password)
    {   try 
        {   FileWriter fw = new FileWriter(FACULTY_FILE, true);
            fw.write(username + "," + password + "\n");
            fw.close();
        } 
        catch (IOException e) 
        {   System.out.println("Error saving credentials.");}
    }

    public static void makeReservation(User user,ReservationManager manager)
    {   System.out.print("Enter Department: ");
        String dept = sc.next();
        System.out.print("Enter Floor Number: ");
        String floor = sc.next();
        System.out.print("Enter Room Number: ");
        String room = sc.next();
        System.out.print("Enter Purpose: ");
        String purpose = sc.next();

        loadingBar("Processing Reservation");
        manager.bookHall(dept,floor,room,purpose,user);
    }

    public static void loadingBar(String message)
    {   try
        {   System.out.print(message);
            for(int i=0;i<3;i++)
            {   System.err.print(".");
                Thread.sleep(500);
            }
            System.out.println();
        }
        catch(InterruptedException e)
        {   System.out.println("Loading interrupted!!");}
    }
}
