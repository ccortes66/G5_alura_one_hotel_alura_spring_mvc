@import com.alura.hotelalura.springboottres.controller.responses.*
@import java.time.LocalDate;


@param BuscarResponsesEmpleado buscarResponses


<!doctype html>
<html lang="en">
@template.partes.includes.head()
<body>

    
    <section class="container-fluid">
         <div class="row">
             @template.partes.includes.siderbarEmpleado()

             <div class="col-sm p-3 min-vh-100">
                 <!-- content -->
                 @template.partes.includes.titulos(buscarResponses.username(),
                                                  "Buscar Reservación",
                                                   "bi-search fs-1")
                 

                  <form id="formulario" action="/operacion/buscar/reservacion" method="post">
                     <div class="row g-3">
                         
                         <div class="col-sm-5">
                             <label for="inputPassword2" >reservaId</label>
                             <input type="text" style="margin-top:3%; width:100%;"  class="form-control" id="precio" name="reservaId">
                         </div>

                         <div class="col-auto">
                             <label for="checkOut" class="form-label">Check In</label>
                             <input type="date" style="margin-top:3.6%;" id="checkIn" class="form-control" name="fechaInicio"   aria-label="First name">
                         </div>

                         
                         <div class="col-auto">

                             <button class="btn btn-outline-primary btn-block " style="margin-top:73%; border-radius: 100%;"  type="submit">
                                 <i class="bi-search"></i>
                             </button>
                         </div>

                     </div>
                 </form>




                    <table class="table table-hover mt-3">
                     <thead >
                         <tr>
                             <th scope="col">Reserva</th>
                             <th scope="col">CheckIn</th>
                             <th scope="col">CheckOut</th>
                             <th scope="col">Categoria</th>
                             <th scope="col">Método de Pago</th>
                             <th scope="col">Habitación</th>
                             <th scope="col">Accion</th>
                         </tr>
                     </thead>
                     <tbody>
                   
                        @if(buscarResponses.listarCriteria() != null)
                            @for(var busqueda: buscarResponses.listarCriteria() )
                             <tr class="myResult">
                                <td class="text-capitalize">${busqueda.reservaId()}</td>
                                <td class="text-capitalize">${busqueda.checkIn()}</td>
                                <td class="text-capitalize">${busqueda.checOut()}</td>
                                <td class="text-capitalize">${busqueda.categoria()}</td>
                                <td class="text-capitalize">${busqueda.metodoDePago()}</td>
                                <td class="text-capitalize">${busqueda.numeroDeHabitacion().toString()}</td>
                                <td class="text-capitalize">
                                    @if(LocalDate.parse(busqueda.checkIn()).isAfter(LocalDate.now().plusDays(1)))
                                    <a  class="btn btn-outline-danger btn-block btnEliminar">Eliminar</a>
                                    @endif
                                </td>
                             </tr>   
                            @endfor
                        @endif

                     
                     
                     </tbody>
                 </table>
                
             </div>

         </div>
   </section>

    @raw
    <script>
        const btnEliminar = document.querySelectorAll(".btnEliminar");
         
        btnEliminar.forEach((btn,index) =>{
            btn.addEventListener("click",()=>{
                Swal.fire({
                    title: '¿Estás seguro?',
                    text: "¡Esta acción no se puede deshacer!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Sí',
                    cancelButtonText: 'No',
                    reverseButtons: false
                }).then((resultado)=>{
                    if(resultado.isConfirmed)
                    { const filas = document.querySelectorAll('.myResult');
                      window.location.href = "/operacion/eliminar/reservacion?busqueda="+filas[index].getElementsByTagName("td")[0].innerHTML;    
                    }

                });
            });

        }); 
        
    </script>
    @endraw

@template.partes.includes.footer()
</body>
</html>