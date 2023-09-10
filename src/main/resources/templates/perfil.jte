@import com.alura.hotelalura.springboottres.persitence.dto.user.ClienteModel
@import java.time.LocalDate
@import java.time.Period


@param ClienteModel listarPerfil


<!doctype html>
<html lang="en">
@template.partes.includes.head()
<body>


<section class="container-fluid">
    <div class="row">
        @template.partes.includes.siderbar()

        <div class="col-sm p-3 min-vh-100">
            <!-- content -->
            @template.partes.includes.titulos(listarPerfil.username(),
                                             "Perfil",
                                             "bi-person-circle fs-1")

            <div class="container py-3">

                <div class="row">
                    <div class="col-lg-4">
                        <div class="card mb-4">
                            <div class="card-body text-center">
                                <img class="avatar avatar-128 bg-light rounded-circle text-white p-2"
                                     src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg" alt="d">
                                <h5 class="my-3">
                                    ${listarPerfil.userEntity().getInfoPersonal().getNombre()}
                                </h5>
                                @if(listarPerfil.vip() != 0)
                                    <p class="text-muted mb-1">VIP Numero ${listarPerfil.vip()}</p>
                                @endif
                                <p class="text-muted mb-4"> Hotel alura puntos ${listarPerfil.puntos()}</p>

                            </div>
                        </div>

                        <div class="card mb-4 mb-lg-0">
                            <div class="card-body p-0">
                                <ul class="list-group list-group-flush rounded-3">
                                    <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                        <p class="mb-0">Eliminar Cuenta</p>
                                        <a id="btnEliminar" class="btn btn-outline-danger btn-block">Eliminar</a>
                                    </li>

                                </ul>
                            </div>
                        </div>


                    </div>
                    <div class="col-lg-8">
                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Nombre completo</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">
                                            ${listarPerfil.userEntity().getInfoPersonal().getNombre()}
                                            ${listarPerfil.userEntity().getInfoPersonal().getApellido()}
                                        </p>
                                    </div>
                                </div>
                                <hr>
                                
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Edad</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">
                                            ${Period.between(listarPerfil.userEntity().getInfoPersonal().getFechaNacimiento(),LocalDate.now()).getYears()}
                                        </p>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Teléfono</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">
                                            ${listarPerfil.userEntity().getInfoPersonal().getTelefono()}
                                        </p>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Nacionalidad</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">
                                            ${listarPerfil.nacionalidad()}
                                        </p>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <div class="col-lg-12">
                            <div class="card mb-4">
                                <div class="card-body">
                                   <form action="/cliente/perfil" method="post">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Teléfono</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <p class="text-muted mb-0">
                                                <input type="tel" id="telefono" name="telefono" required class="form-control" value="${listarPerfil.userEntity().getInfoPersonal().getTelefono()}" pattern="^\d{3} \d{7}$" />
                                            </p>
                                        </div>
                                    </div>
                                    <hr>


                                       <div class="row">

                                           <div class="col-sm-3">
                                               <input type="submit" class="btn btn-outline-secondary btn-block" value="Editar">
                                           </div>
                                       </div>

                                   </form>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>

    </div>
</section>
@raw
<script>
    let data = document.querySelector("#btnEliminar");

     data.addEventListener("click",()=>{
     Swal.fire({
        title: '¿Estás seguro?',
        text: "¡Esta acción no se puede deshacer!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Sí',
        cancelButtonText: 'No',
        reverseButtons: false
     }).then((resultado)=>{
        if(resultado.isConfirmed){
           window.location.href = "/cliente/eliminar";
        }
      })
  });
</script>
@endraw

@template.partes.includes.footer()
</body>
</html>