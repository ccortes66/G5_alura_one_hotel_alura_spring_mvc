@import com.alura.hotelalura.springboottres.controller.responses.CreacionResponses
@param CreacionResponses responses

<!doctype html>
<html lang="en">
@template.partes.includes.head()
<body>

    
    <section class="container-fluid">
         <div class="row">
             @template.partes.includes.siderbarEmpleado()

             <div class="col-sm p-3 min-vh-100">
                 <!-- content -->
                 @template.partes.includes.titulos(responses.username(),
                                                   "Generar Habitaciones",
                                                    "bi-card-list fs-1")

                 <form action="/operacion/generar/Habitacion/tipo" method="post" class="row g-3" >
                     <h4 class="text-capitalize">Generar Tipo Habitacion </h4>
                     <div class="col-auto">
                         <label for="staticEmail2">Categoria</label>
                         <input type="text" required class="form-control" name="categoria" pattern="[A-Za-z]+">
                     </div>
                     <div class="col-auto">
                         <label for="inputPassword2" >Precio por día</label>
                         <input type="text" required class="form-control" id="inputPassword2" name="precioUnitario" pattern="[0-9]*\.?[0-9]+">
                     </div>
                     <div class="col-auto">
                         <label for="inputPassword2" >Puntos</label>
                         <input type="number" required class="form-control" id="inputPassword2" name="puntoUnitario">
                     </div>
                     <div class="col-auto">
                         <button type="submit" class="btn btn-outline-success mt-4">Agregar</button>
                     </div>
                 </form>
                 @if(responses.confirmaciones()[0])
                     <div class="alert alert-info alert-dismissible fade show mt-4" role="alert">
                         <strong>¡Tipo Habitación creada!</strong> Se registran los datos en el sistema
                         <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                     </div>
                 @endif
                 <hr>

                 <form action="/operacion/generar/Habitacion" method="post"  class="row g-2 my-2">
                     <h4 class="text-capitalize"> Generar Habitacion </h4>
                     <div class="col-auto">
                         <label for="staticEmail2">Numero</label>
                         <input type="number" required name="numero" class="form-control" id="staticEmail2" >
                     </div>
                     <div class="col-auto">
                         <label for="inputPassword2" >Habitacion tipo</label>
                         <select class="form-select" id="categoria" name="categoria" aria-label="Default select example" required>
                             @for(var categoria : responses.listarCaregoria())
                                 <option class="text-capitalize" value="${categoria.getCategoria()}">${categoria.getCategoria()}</option>
                             @endfor
                         </select>
                     </div>
                     <div class="col-auto">
                         <button type="submit" class="btn btn-outline-success mt-4">Agregar</button>
                     </div>
                 </form>
                 @if(responses.confirmaciones()[1])
                     <div class="alert alert-info alert-dismissible fade show mt-4" role="alert">
                         <strong>!Habitación creada!</strong> Se registran los datos en el sistema
                         <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                     </div>
                 @endif
                 <hr>


             </div>

         </div>
   </section>

@template.partes.includes.footer()
</body>
</html>