@import com.alura.hotelalura.springboottres.controller.responses.*



@param BuscarResponses buscarResponses

<!doctype html>
<html lang="en">
@template.partes.includes.head()
<body>

<section class="container-fluid">
    <div class="row">
        @template.partes.includes.siderbarEmpleado()

        <div class="col-sm p-3 min-vh-100">
          @template.partes.includes.titulos(buscarResponses.username(),
                                           "reservaciones Actuales",
                                           "bi-arrow-repeat fs-1")

            <div class="d-flex justify-content-between ">

               <div>
                   <p class="text-capitalize">buscar</p>
                   <nav aria-label="Page navigation example" >
                   <ul class="pagination">
                    <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                    </li>
                    
                    @for(int i = 0; i<(buscarResponses.listarCriteria().getTotalElements()/10)+1; i++ )
                        <li class="page-item"><a class="page-link" href="/operacion?pagina=${i}">${i+1}</a></li>
                    @endfor  
                    
                    <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                    </li>
                </ul>
                </nav>
             </div>    
                
                 <div>
                   <p class="text-capitalize">Total ${buscarResponses.listarCriteria().getTotalElements()} </p>
                 </div>

             </div>  
          
           

            <table class="table table-hover mt-3">
                <thead >
                <tr>
                    <th scope="col">Reserva</th>
                    <th scope="col">CheckIn</th>
                    <th scope="col">CheckOut</th>
                    <th scope="col">Categoria</th>
                    <th scope="col">Método de Pago</th>
                    <th scope="col">Habitación</th>
                </tr>
                </thead>
                <tbody>
               
                      @if(buscarResponses.listarCriteria().getContent() != null)

                           @for(var busqueda: buscarResponses.listarCriteria().getContent() )
                            <tr>
                                 <td class="text-capitalize">${busqueda.reservaId()}</td>
                                 <td class="text-capitalize">${busqueda.checkIn()}</td>
                                 <td class="text-capitalize">${busqueda.checOut()}</td>
                                 <td class="text-capitalize">${busqueda.categoria()}</td>
                                 <td class="text-capitalize">${busqueda.metodoDePago()}</td>
                                 <td class="text-capitalize">${busqueda.numeroDeHabitacion().toString()}</td>
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