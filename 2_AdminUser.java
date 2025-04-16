import java.util.Scanner;
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
