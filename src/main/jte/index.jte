@import com.alura.hotelalura.springboottres.controller.responses.ListarReservacionResponses
@import java.text.DecimalFormat

@param ListarReservacionResponses resultadoLista 

<!doctype html>
<html lang="en">
@template.partes.includes.head()
<body>

    <section class="container-fluid">
         <div class="row">
             @template.partes.includes.siderbar()

             <div class="col-sm p-3 min-vh-100">
                 
                  @template.partes.includes.titulos("users",
                                                    "Mis reservaciones",
                                                    "bi-arrow-repeat fs-1")
                  
                 <table class="table">
                     <thead class="thead-dark">
                     <tr>
                         <th scope="col">reserva</th>
                         <th scope="col">checkIn</th>
                         <th scope="col">checkOut</th>
                         <th scope="col">precio</th>
                         <th scope="col">categoria</th>
                         <th scope="col">habitacion</th>
                     </tr>
                     </thead>
                     <tbody>
                     
                     @if(resultadoLista.listarReservacion() != null)
                         @for(var reservaInfo: resultadoLista.listarReservacion())
                             <tr>
                                 <td class="text-capitalize">${reservaInfo.getReservaId()}</td>
                                 <td class="text-capitalize">${String.valueOf(reservaInfo.getCheckIn())}</td>
                                 <td class="text-capitalize">${String.valueOf(reservaInfo.getCheckOut())}</td>
                                 <td class="text-capitalize">${new DecimalFormat("#,###.00").format(reservaInfo.getPrecioHabitacion())}</td> 
                                 <td class="text-capitalize">${reservaInfo.getCategoria()}</td>
                                 <td class="text-capitalize">${String.valueOf(reservaInfo.getNumeroHabitacion())}</td>
                             </tr>
                         @endfor
                     @endif
                     
                     </tbody>
                 </table>
             </div>

         </div>
   </section>

@template.partes.includes.footer()
</body>
</html>