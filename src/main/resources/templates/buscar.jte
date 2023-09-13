@import com.alura.hotelalura.springboottres.controller.responses.*
@import java.text.DecimalFormat


@param BuscarResponses buscarResponses




<!doctype html>
<html lang="en">
@template.partes.includes.head()
<body>

    
    <section class="container-fluid">
         <div class="row">
             @template.partes.includes.siderbar()

             <div class="col-sm p-3 min-vh-100">
                 <!-- content -->
                 @template.partes.includes.titulos(buscarResponses.username(),
                                                   "Buscar Reservación",
                                                   "bi-search fs-1")

                 <form id="formulario" action="/cliente/buscar/reservacion" method="post">
                     <div class="row g-3">

                         <div class="col-auto">
                             <label for="checkOut" class="form-label">Check In</label>
                             <input type="date" id="checkIn" class="form-control" name="checkIn"   aria-label="First name">
                         </div>

                         <div class="col-auto">
                             <label for="categoria" class="form-label">Categoría</label>
                             <select class="form-select" id="categoria" name="categoria" aria-label="Default select example" >

                                 @for(var categoria: buscarResponses.listarCategoria())
                                     <option class="text-capitalize" value="${categoria}">${categoria}</option>
                                 @endfor

                             </select>
                         </div>

                         <div class="col-auto">
                             <label for="inputPassword2" >Precio</label>
                             <input type="text" style="margin-top:3%"  class="form-control" id="precio" name="precioUnitario" pattern="[0-9]*\.?[0-9]+">
                         </div>

                         <div class="col-auto">

                             <button class="btn btn-outline-primary btn-block " style="margin-top:73%"  type="submit">
                                 <i class="bi-search"></i>
                             </button>
                         </div>

                     </div>
                 </form>


                    <table class="table table-hover mt-3">
                     <thead >
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
                         @if(buscarResponses.listarCriteria() != null)

                           @for(var busqueda: buscarResponses.listarCriteria() )
                            <tr>
                                 <td class="text-capitalize">${busqueda.reservaId()}</td>
                                 <td class="text-capitalize">${busqueda.checkIn()}</td>
                                 <td class="text-capitalize">${busqueda.checOut()}</td>
                                 <td class="text-capitalize">${new DecimalFormat("#,###.00").format(busqueda.precio())}</td>
                                 <td class="text-capitalize">${busqueda.categoria()}</td>
                                 <td class="text-capitalize">${busqueda.numeroDeHabitacion().toString()}</td>
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
        
         document.querySelector('#formulario').addEventListener('submit',event => {
            event.preventDefault();

            let fecha = document.querySelector('#checkIn').value;
            let categoria = document.querySelector('#categoria').value
            let precio = document.querySelector('#precio').value
            localStorage.setItem('fecha',fecha)
            localStorage.setItem('categoria',categoria)
            localStorage.setItem('precio',precio)

            event.target.submit();
         });

         document.addEventListener('DOMContentLoaded', () => {
         let fechaGuardada = localStorage.getItem('fecha');
         let categoriaGuardada = localStorage.getItem('categoria');
         let precioGuardado = localStorage.getItem('precio');

          if (fechaGuardada)
             {document.querySelector('#checkIn').value = fechaGuardada;}

          if (categoriaGuardada)
             {document.querySelector('#categoria').value = categoriaGuardada;}

          if (precioGuardado)
             {document.querySelector('#precio').value = precioGuardado;}
        });


    </script>
    @endraw

@template.partes.includes.footer()
</body>
</html>>