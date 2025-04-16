import java.util.Scanner;
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
