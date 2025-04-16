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