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
