package gg.jte.generated.ondemand;
import com.alura.hotelalura.springboottres.persitence.dto.user.ClienteModel;
import java.time.LocalDate;
import java.time.Period;
public final class JteperfilGenerated {
	public static final String JTE_NAME = "perfil.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,5,5,5,10,10,10,16,16,19,20,22,33,33,33,35,35,36,36,36,37,37,38,38,38,66,66,66,67,67,67,79,79,79,90,90,90,101,101,101,119,119,119,119,119,119,119,119,119,146,166,168,168,170};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ClienteModel listarPerfil) {
		jteOutput.writeContent("\n\n<!doctype html>\n<html lang=\"en\">\n");
		gg.jte.generated.ondemand.partes.includes.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n<body>\n\n\n<section class=\"container-fluid\">\n    <div class=\"row\">\n        ");
		gg.jte.generated.ondemand.partes.includes.JtesiderbarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n        <div class=\"col-sm p-3 min-vh-100\">\n            ");
		jteOutput.writeContent("\n            ");
		gg.jte.generated.ondemand.partes.includes.JtetitulosGenerated.render(jteOutput, jteHtmlInterceptor, listarPerfil.username(), "Perfil", "bi-person-circle fs-1");
		jteOutput.writeContent("\n\n            <div class=\"container py-3\">\n\n                <div class=\"row\">\n                    <div class=\"col-lg-4\">\n                        <div class=\"card mb-4\">\n                            <div class=\"card-body text-center\">\n                                <img class=\"avatar avatar-128 bg-light rounded-circle text-white p-2\"\n                                     src=\"https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg\" alt=\"d\">\n                                <h5 class=\"my-3\">\n                                    ");
		jteOutput.setContext("h5", null);
		jteOutput.writeUserContent(listarPerfil.userEntity().getInfoPersonal().getNombre());
		jteOutput.writeContent("\n                                </h5>\n                                ");
		if (listarPerfil.vip() != 0) {
			jteOutput.writeContent("\n                                    <p class=\"text-muted mb-1\">VIP Numero ");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(listarPerfil.vip());
			jteOutput.writeContent("</p>\n                                ");
		}
		jteOutput.writeContent("\n                                <p class=\"text-muted mb-4\"> Hotel alura puntos ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(listarPerfil.puntos());
		jteOutput.writeContent("</p>\n\n                            </div>\n                        </div>\n\n                        <div class=\"card mb-4 mb-lg-0\">\n                            <div class=\"card-body p-0\">\n                                <ul class=\"list-group list-group-flush rounded-3\">\n                                    <li class=\"list-group-item d-flex justify-content-between align-items-center p-3\">\n                                        <p class=\"mb-0\">Eliminar Cuenta</p>\n                                        <a id=\"btnEliminar\" class=\"btn btn-outline-danger btn-block\">Eliminar</a>\n                                    </li>\n\n                                </ul>\n                            </div>\n                        </div>\n\n\n                    </div>\n                    <div class=\"col-lg-8\">\n                        <div class=\"card mb-4\">\n                            <div class=\"card-body\">\n                                <div class=\"row\">\n                                    <div class=\"col-sm-3\">\n                                        <p class=\"mb-0\">Nombre completo</p>\n                                    </div>\n                                    <div class=\"col-sm-9\">\n                                        <p class=\"text-muted mb-0\">\n                                            ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(listarPerfil.userEntity().getInfoPersonal().getNombre());
		jteOutput.writeContent("\n                                            ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(listarPerfil.userEntity().getInfoPersonal().getApellido());
		jteOutput.writeContent("\n                                        </p>\n                                    </div>\n                                </div>\n                                <hr>\n                                \n                                <div class=\"row\">\n                                    <div class=\"col-sm-3\">\n                                        <p class=\"mb-0\">Edad</p>\n                                    </div>\n                                    <div class=\"col-sm-9\">\n                                        <p class=\"text-muted mb-0\">\n                                            ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(Period.between(listarPerfil.userEntity().getInfoPersonal().getFechaNacimiento(),LocalDate.now()).getYears());
		jteOutput.writeContent("\n                                        </p>\n                                    </div>\n                                </div>\n                                <hr>\n                                <div class=\"row\">\n                                    <div class=\"col-sm-3\">\n                                        <p class=\"mb-0\">Teléfono</p>\n                                    </div>\n                                    <div class=\"col-sm-9\">\n                                        <p class=\"text-muted mb-0\">\n                                            ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(listarPerfil.userEntity().getInfoPersonal().getTelefono());
		jteOutput.writeContent("\n                                        </p>\n                                    </div>\n                                </div>\n                                <hr>\n                                <div class=\"row\">\n                                    <div class=\"col-sm-3\">\n                                        <p class=\"mb-0\">Nacionalidad</p>\n                                    </div>\n                                    <div class=\"col-sm-9\">\n                                        <p class=\"text-muted mb-0\">\n                                            ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(listarPerfil.nacionalidad());
		jteOutput.writeContent("\n                                        </p>\n                                    </div>\n                                </div>\n\n                            </div>\n                        </div>\n\n                        <div class=\"col-lg-12\">\n                            <div class=\"card mb-4\">\n                                <div class=\"card-body\">\n                                   <form action=\"/cliente/perfil\" method=\"post\">\n                                    <div class=\"row\">\n                                        <div class=\"col-sm-3\">\n                                            <p class=\"mb-0\">Teléfono</p>\n                                        </div>\n                                        <div class=\"col-sm-9\">\n                                            <p class=\"text-muted mb-0\">\n                                                <input type=\"tel\" id=\"telefono\" name=\"telefono\" required class=\"form-control\"");
		var __jte_html_attribute_0 = listarPerfil.userEntity().getInfoPersonal().getTelefono();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" pattern=\"^\\d{3} \\d{7}$\" />\n                                            </p>\n                                        </div>\n                                    </div>\n                                    <hr>\n\n\n                                       <div class=\"row\">\n\n                                           <div class=\"col-sm-3\">\n                                               <input type=\"submit\" class=\"btn btn-outline-secondary btn-block\" value=\"Editar\">\n                                           </div>\n                                       </div>\n\n                                   </form>\n                                </div>\n                            </div>\n                        </div>\n\n                    </div>\n                </div>\n            </div>\n\n        </div>\n\n    </div>\n</section>\n");
		jteOutput.writeContent("\n<script>\n    let data = document.querySelector(\"#btnEliminar\");\n\n     data.addEventListener(\"click\",()=>{\n     Swal.fire({\n        title: '¿Estás seguro?',\n        text: \"¡Esta acción no se puede deshacer!\",\n        icon: 'warning',\n        showCancelButton: true,\n        confirmButtonText: 'Sí',\n        cancelButtonText: 'No',\n        reverseButtons: false\n     }).then((resultado)=>{\n        if(resultado.isConfirmed){\n           window.location.href = \"/cliente/eliminar\";\n        }\n      })\n  });\n</script>\n");
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.partes.includes.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		ClienteModel listarPerfil = (ClienteModel)params.get("listarPerfil");
		render(jteOutput, jteHtmlInterceptor, listarPerfil);
	}
}
