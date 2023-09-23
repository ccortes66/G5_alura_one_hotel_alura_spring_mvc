@import com.alura.hotelalura.springboottres.controller.responses.*
@import java.text.DecimalFormat


@param ReservaClienteResponses reservaResponses
@param ErrorResponses response 



<!doctype html>
<html lang="en">
@template.partes.includes.head()
<body>

    
    <section class="container-fluid">
         <div class="row">
             @template.partes.includes.siderbar()

             <div class="col-sm p-3 min-vh-100">
                 <!-- content -->
                 @template.partes.includes.titulos(reservaResponses.username(),
                                                  "Generar Reservación",
                                                  "bi-card-list fs-1")

                 <form action="/cliente/generar/reservacion" method="post">
                  <div class="row g-3">

                     <div class="col-auto">
                         <label for="checkOut" class="form-label">Check In</label>
                         <input type="date" class="form-control" name="checkIn" required  aria-label="First name">
                     </div>

                     <div class="col-auto">
                         <label for="checkOut" class="form-label">Check Out</label>
                         <input type="date" class="form-control" id="checkOut" name="checkOut" required aria-label="Last name">
                     </div>

                     <div class="col-auto">
                         <label for="categoria" class="form-label">Categoría</label>
                         <select class="form-select" id="categoria" name="categoria" aria-label="Default select example" required>
                             @for(var categoria: reservaResponses.listarCategoria())
                                     <option class="text-capitalize" value="${categoria}">${categoria}</option>
                             @endfor
                         </select>
                     </div>

                     <div class="col-auto">
                         <label for="metodoPago" class="form-label">Método de pago</label>
                         <select class="form-select" id="metodoPago" name="metodoPago" aria-label="Default select example" required>
                             @for(var pago: reservaResponses.listaMetodoPago())
                                     <option value="${pago}">${pago}</option>
                              @endfor
                          
                         </select>
                     </div>

                      <div class="col-auto">

                          <input class="btn btn-outline-primary btn-block " style="margin-top:33%"  type="submit" value="Reservar">
                      </div>

                 </div>
                 </form>
                 @if(response != null)
                      <div class="alert alert-danger alert-dismissible fade show mt-4" role="alert">
                             <strong>Error ${response.erroNumber()}</strong> ${response.message()}
                             <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                     </div>

                 @elseif(reservaResponses.listarReservacion() != null)
                         <div class="alert alert-success alert-dismissible fade show mt-4" role="alert">
                             <h4 class="alert-heading">¡La reserva se ha realizado con éxito!</h4>
                             <p> Esperamos que disfrute de su estancia en el Hotel Alura. Aquí tiene los detalles de su reserva:</p>
                             <p> ID: ${reservaResponses.listarReservacion().reservaId()} </p>
                             <p> Precio (en USD):${new DecimalFormat("#,###.00").format(reservaResponses.listarReservacion().precio())} </p>
                             <p> Número de habitación: ${reservaResponses.listarReservacion().habitacion()}</p>
                             <hr>
                             <p class="mb-0">Hotel Alura G5 &copy; ${java.time.LocalDate.now().getYear()}.</p>
                             <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                         </div>
                   

                 @endif


             </div>

         </div>
   </section>

@template.partes.includes.footer()
</body>
</html>