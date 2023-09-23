@import com.alura.hotelalura.springboottres.controller.responses.LoginResponses

@param LoginResponses loginResponse 

<!doctype html>
<html lang="en">
@template.partes.includes.head()
<body>
<section class="vh-100">
    <div class="container py-5 h-100">
        <div class="row d-flex align-items-center justify-content-center h-100">

            <div class="col-md-8 col-lg-7 col-xl-6">
                <img src="${loginResponse.img()}"
                     class="img-fluid" alt="Phone image"/>
            </div>

            <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                <form action="${loginResponse.linkAction()}" method="post">
                  
                  
                    @if(loginResponse.responses() != null)
                        <div class="alert alert-danger alert-dismissible fade show mt-4" role="alert">
                            <strong>Error ${loginResponse.responses().erroNumber()} </strong> ${loginResponse.responses().message()}
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    @endif
                    

                    <div class="divider d-flex align-items-center my-4">
                        <p class="text-center fw-bold mx-3 mb-0 text-muted">Login</p>
                    </div>
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <input type="text" id="username"  name="username" class="form-control form-control-lg" required />
                        <label class="form-label" for="username" >Username</label>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-4">
                        <input type="password" id="password" name="password" class="form-control form-control-lg" required />
                        <label class="form-label" for="password" >Password</label>
                    </div>

                    <!-- captcha -->
                    <div class="form-outline mb-4  h-captcha" data-sitekey="fd57c86b-3201-4b83-af0a-12f67c8fe5a1"></div>

                    <!-- Submit button -->
                    <button type="submit" class="btn btn-outline-success btn-lg btn-block mb-2" style="width:100%">Ingresar</button>
                    <a href="${loginResponse.linkRegistro()}" class="btn btn-outline-primary btn-lg btn-block" style="width:100%">Registar</a>

                </form>
            </div>
        </div>
    </div>
</section>


@template.partes.includes.footer()

</body>
</html>