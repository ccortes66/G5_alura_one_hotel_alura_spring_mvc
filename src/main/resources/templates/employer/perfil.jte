@import com.alura.hotelalura.springboottres.persitence.entity.EmpleadoEntity;
@import java.time.LocalDate
@import java.time.Period


@param EmpleadoEntity listarPerfil

<!doctype html>
<html lang="en">
@template.partes.includes.head()
<body>


<section class="container-fluid">
    <div class="row">
        @template.partes.includes.siderbarEmpleado()

        <div class="col-sm p-3 min-vh-100">
            <!-- content -->
            @template.partes.includes.titulos(listarPerfil.getUsername(),
                                             "Perfil",
                                      "      bi-person-circle fs-1")

            <div class="container py-3">

                <div class="row">
                    <div class="col-lg-4">
                        <div class="card mb-4">
                            <div class="card-body text-center">
                                <img class="avatar avatar-128 bg-light rounded-circle text-white p-2"
                                     src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg" alt="d">
                                <h5 class="my-3">
                                    ${listarPerfil.getUserEntity().getInfoPersonal().getNombre()}
                                </h5>

                            </div>
                        </div>

                    </div>
                    <!-- fin div perfl-->
                    <!-- fin div info-->
                    <div class="col-lg-8">
                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Nombre completo</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">
                                            ${listarPerfil.getUserEntity().getInfoPersonal().getNombre()}
                                            ${listarPerfil.getUserEntity().getInfoPersonal().getApellido()}
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
                                            ${Period.between(listarPerfil.getUserEntity().getInfoPersonal().getFechaNacimiento(),LocalDate.now()).getYears()}
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
                                            ${listarPerfil.getUserEntity().getInfoPersonal().getTelefono()}
                                        </p>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Cargo</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">
                                            ${listarPerfil.getCargo()}
                                        </p>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <div class="col-lg-12">
                            <div class="card mb-4">
                                <div class="card-body">
                                    <form action="/operacion/perfil" method="post">

                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Teléfono</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0">
                                                    <input type="tel" id="telefono" name="telefono" required class="form-control" value="${listarPerfil.getUserEntity().getInfoPersonal().getTelefono()}" />
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
                    <!-- fin div info -->
                </div>
            </div>

        </div>

    </div>
</section>

@template.partes.includes.footer()
</body>
</html>