import java.util.*;
class ReservationManager 
{   ArrayList<HallReservation> reservations=new ArrayList<>();

    void bookHall(String dept,String floor,String room,String purpose,User user)
    {   for(HallReservation r:reservations)
        {   if(r.department.equalsIgnoreCase(dept)&&r.floor.equalsIgnoreCase(floor)&&r.roomNo.equalsIgnoreCase(room))
            {   System.out.println("Room already Booked!!");
                return;
            }
        }

        HallReservation res=new HallReservation(dept,floor,room,purpose,user);
        reservations.add(res);
        System.out.println("Reservation ID:"+res.reservationId+" Created(Pending)!!");
    }
    void viewAll()
    {   if(reservations.isEmpty())
        {   System.out.println("No reservation Yet!!");
            return;
        }
        for(HallReservation r:reservations)
        {   System.out.println(r);}
    }
    void approveOrReject(int id,Boolean approve)
    {   for(HallReservation r:reservations)
        {   if(r.reservationId==id)
            {   r.status=approve?"Approved":"Rejected";
                System.out.println("Reservation"+(approve?"Approved":"Rejected"));
                return;
            }
        }
        System.out.println("Reservation Not Found!!");
    }
}
