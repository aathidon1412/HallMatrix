import java.util.Scanner;

abstract class User
{
    protected String name;
    protected String role;

    public User(String name,String role)
    {   this.name=name;
        this.role=role;
    }

    public String getRole()
    {   return role;}

    public String getName()
    {   return name;}

    public abstract void showRoleMenu(ReservationManager manager);
}

class AdminUser extends User
{   public AdminUser(String name)
    {   super(name,"Admin");}
    
    @Override
    public void showRoleMenu(ReservationManager manager)
    {   Scanner sc = HallMatrix.sc;
        int choice;
        do
        {   System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View Reservations");
            System.out.println("2. Approve/Reject Reservations");
            System.out.println("3. Logout");
            System.out.print("Enter Choice:");
            choice=sc.nextInt();

            switch(choice)
            {
                case 1:
                    manager.viewAll();break;
                case 2:
                    System.out.print("Enter Reservation ID:");
                    int id=sc.nextInt();
                    System.out.println("Approve ?(Yes/No):");
                    String ans=sc.next();
                    manager.approveOrReject(id,ans.equalsIgnoreCase("Yes"));
                    break;
                case 3:HallMatrix.loadingBar("Logging Out");return;
                default:System.out.println("Invalid Option!!");
            }
        }while(true);
    }
}

class FacultyUser extends User
{   public FacultyUser(String name)
    {   super(name,"Faculty");}

    @Override
    public void showRoleMenu(ReservationManager manager)
    {   Scanner sc=HallMatrix.sc;
        int choice;
        do
        {   System.out.println("\n--- Faculty Menu ---");
            System.out.println("1. Make Reservation");
            System.out.println("2. View Reservation");
            System.out.println("3. Logout");
            System.out.print("Enter Choice:");
            sc.nextLine();
            choice=sc.nextInt();
            

            switch (choice) {
                case 1:HallMatrix.makeReservation(this,manager); break;
                case 2:manager.viewAll();break;
                case 3:HallMatrix.loadingBar("Logging Out");return;
                default:System.out.println("Invalid Optiom!!");
            }
        }while(true);
    }
}

class StudentUser extends User 
{   public StudentUser()
    { super("StudentUser","Student");}
    
    @Override
    public void showRoleMenu(ReservationManager manager)
    {   System.out.println("Logged in as Student(view-only)");
        HallMatrix.loadingBar("Loading Reservations");
        manager.viewAll();
    }
}
