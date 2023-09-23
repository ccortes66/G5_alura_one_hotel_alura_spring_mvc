@import com.alura.hotelalura.springboottres.controller.responses.*
@import java.text.DecimalFormat


@param ReservaResponses reservaResponses
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
                                                       "Consultar Precio",
                                                       "bi-cash-stack fs-1")



                 <form action="/cliente/consultar/reservacion" method="post">
                  <div class="row g-3">

                     <div class="col-auto">
                         <label for="checkOut" class="form-label">Check In</label>
                         <input type="date" class="form-control" id="checkIn" name="checkIn" required  aria-label="First name">
                     </div>

                     <div class="col-auto">
                         <label for="checkOut" class="form-label">Check Out</label>
                         <input type="date" class="form-control" id="checkOut" name="checkOut" required aria-label="Last name">
                     </div>

                     <div class="col-auto">
                         <label for="categoria" class="form-label">Categoría</label>
                         <select class="form-select" id="categoria" name="categoria" aria-label="Default select example" required>
                             @for(var categoria: reservaResponses.listarCaregoria())
                                     <option class="text-capitalize" value="${categoria}">${categoria}</option>
                             @endfor

                         </select>
                     </div>


                      <div class="col-auto">
                          <input class="btn btn-outline-success btn-block " style="margin-top:33%"  type="submit" value="Consultar">
                      </div>

                 </div>
                 </form>

                 @if(response != null)

                     <div class="alert alert-danger alert-dismissible fade show mt-4" role="alert">
                             <strong>Error ${response.erroNumber()}</strong> ${response.message()}
                             <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                     </div>

                 @elseif(reservaResponses.consultaResponses() != null)

                     <div class="card mb-3 mt-4" style="max-width: 540px;">
                         <div class="row g-0">
                             <div class="col-md-4">
                                 <img src="https://i.ibb.co/vVhTHRy/logo.png" class="img-fluid rounded-start" alt="...">
                             </div>
                             <div class="col-md-8">
                                 <div class="card-body">
                                     <h5 class="card-title">Consultar Precio</h5>
                                     <p class="card-text">Cálculo del costo según la duración de la estadía .</p>

                                    <ul class="list-unstyled">
                                        <li id="myInicio" class="card-text">Check In:${String.valueOf(reservaResponses.consultaResponses().checkIn())}</li>
                                        <li id="myFin" class="card-text">Check Out:${String.valueOf(reservaResponses.consultaResponses().checkOut())} </li>
                                        <li id="myCategoria" class="card-text">Categoria: ${reservaResponses.consultaResponses().categoria()}</li>
                                        <li class=" card-text">Precio(USD) $${new DecimalFormat("#,###.00").format(reservaResponses.consultaResponses().precio())}</li>
                                     </ul>

                                 </div>
                             </div>
                         </div>
                     </div>
                 @endif

             </div>

         </div>
   </section>


@template.partes.includes.footer()
</body>
</html>