class HallReservation 
{   static int idCounter=1;
    int reservationId;
    String department,floor,roomNo,purpose,status;
    User user;
    
    HallReservation(String department,String floor,String roomNo,String purpose,User user)
    {   this.reservationId=idCounter++;
        this.department=department;
        this.floor=floor;
        this.roomNo=roomNo;
        this.purpose=purpose;
        this.user=user;
        this.status="Pending";
    }
    
    public String toString()
    {   return "ID:"+reservationId+"| Dept:"+department+"| Floor:"+floor+
        "| Room:"+roomNo+"| User:"+user.getName()+"| Purpose:"+purpose+"| Status:"+status;}
}
