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
                                                   "Generar método de pago",
                                                    "bi bi-wallet fs-1")

                 <form action="/operacion/generar/pagos" method="post" class="row g-4" >
                     <h4 class="text-capitalize">Generar método de pago</h4>
                     <div class="col-auto">
                         <label for="staticEmail2">Metodo</label>
                         <input type="text" required class="form-control" name="nombre" pattern="[A-Za-z]+">
                     </div>
                     <div class="col-auto">
                         <button type="submit" class="btn btn-outline-success mt-4">Agregar</button>
                     </div>
                 </form>
                
                 @if(responses.confirmaciones()[0])
                     <div class="alert alert-info alert-dismissible fade show mt-4" role="alert">
                         <strong>¡Método de pago generado!</strong> Se registran los datos en el sistema
                         <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                     </div>
                 @endif
                


             </div>

         </div>
   </section>

@template.partes.includes.footer()
</body>
</html>