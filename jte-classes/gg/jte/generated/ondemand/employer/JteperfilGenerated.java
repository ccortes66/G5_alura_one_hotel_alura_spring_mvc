package gg.jte.generated.ondemand.employer;
import com.alura.hotelalura.springboottres.persitence.entity.EmpleadoEntity;;
import java.time.LocalDate;
import java.time.Period;
public final class JteperfilGenerated {
	public static final String JTE_NAME = "employer/perfil.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,5,5,5,9,9,9,15,15,18,19,21,32,32,32,39,40,50,50,50,51,51,51,63,63,63,74,74,74,85,85,85,104,104,104,104,104,104,104,104,104,124,133,133,135};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, EmpleadoEntity listarPerfil) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n");
		gg.jte.generated.ondemand.partes.includes.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n<body>\n\n\n<section class=\"container-fluid\">\n    <div class=\"row\">\n        ");
		gg.jte.generated.ondemand.partes.includes.JtesiderbarEmpleadoGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n        <div class=\"col-sm p-3 min-vh-100\">\n            ");
		jteOutput.writeContent("\n            ");
		gg.jte.generated.ondemand.partes.includes.JtetitulosGenerated.render(jteOutput, jteHtmlInterceptor, listarPerfil.getUsername(), "Perfil", "      bi-person-circle fs-1");
		jteOutput.writeContent("\n\n            <div class=\"container py-3\">\n\n                <div class=\"row\">\n                    <div class=\"col-lg-4\">\n                        <div class=\"card mb-4\">\n                            <div class=\"card-body text-center\">\n                                <img class=\"avatar avatar-128 bg-light rounded-circle text-white p-2\"\n                                     src=\"https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg\" alt=\"d\">\n                                <h5 class=\"my-3\">\n                                    ");
		jteOutput.setContext("h5", null);
		jteOutput.writeUserContent(listarPerfil.getUserEntity().getInfoPersonal().getNombre());
		jteOutput.writeContent("\n                                </h5>\n\n                            </div>\n                        </div>\n\n                    </div>\n                    ");
		jteOutput.writeContent("\n                    ");
		jteOutput.writeContent("\n                    <div class=\"col-lg-8\">\n                        <div class=\"card mb-4\">\n                            <div class=\"card-body\">\n                                <div class=\"row\">\n                                    <div class=\"col-sm-3\">\n                                        <p class=\"mb-0\">Nombre completo</p>\n                                    </div>\n                                    <div class=\"col-sm-9\">\n                                        <p class=\"text-muted mb-0\">\n                                            ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(listarPerfil.getUserEntity().getInfoPersonal().getNombre());
		jteOutput.writeContent("\n                                            ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(listarPerfil.getUserEntity().getInfoPersonal().getApellido());
		jteOutput.writeContent("\n                                        </p>\n                                    </div>\n                                </div>\n                                <hr>\n\n                                <div class=\"row\">\n                                    <div class=\"col-sm-3\">\n                                        <p class=\"mb-0\">Edad</p>\n                                    </div>\n                                    <div class=\"col-sm-9\">\n                                        <p class=\"text-muted mb-0\">\n                                            ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(Period.between(listarPerfil.getUserEntity().getInfoPersonal().getFechaNacimiento(),LocalDate.now()).getYears());
		jteOutput.writeContent("\n                                        </p>\n                                    </div>\n                                </div>\n                                <hr>\n                                <div class=\"row\">\n                                    <div class=\"col-sm-3\">\n                                        <p class=\"mb-0\">Teléfono</p>\n                                    </div>\n                                    <div class=\"col-sm-9\">\n                                        <p class=\"text-muted mb-0\">\n                                            ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(listarPerfil.getUserEntity().getInfoPersonal().getTelefono());
		jteOutput.writeContent("\n                                        </p>\n                                    </div>\n                                </div>\n                                <hr>\n                                <div class=\"row\">\n                                    <div class=\"col-sm-3\">\n                                        <p class=\"mb-0\">Cargo</p>\n                                    </div>\n                                    <div class=\"col-sm-9\">\n                                        <p class=\"text-muted mb-0\">\n                                            ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(listarPerfil.getCargo());
		jteOutput.writeContent("\n                                        </p>\n                                    </div>\n                                </div>\n\n                            </div>\n                        </div>\n\n                        <div class=\"col-lg-12\">\n                            <div class=\"card mb-4\">\n                                <div class=\"card-body\">\n                                    <form action=\"/operacion/perfil\" method=\"post\">\n\n                                        <div class=\"row\">\n                                            <div class=\"col-sm-3\">\n                                                <p class=\"mb-0\">Teléfono</p>\n                                            </div>\n                                            <div class=\"col-sm-9\">\n                                                <p class=\"text-muted mb-0\">\n                                                    <input type=\"tel\" id=\"telefono\" name=\"telefono\" required class=\"form-control\"");
		var __jte_html_attribute_0 = listarPerfil.getUserEntity().getInfoPersonal().getTelefono();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" />\n                                                </p>\n                                            </div>\n                                        </div>\n                                        <hr>\n\n\n                                        <div class=\"row\">\n\n                                            <div class=\"col-sm-3\">\n                                                <input type=\"submit\" class=\"btn btn-outline-secondary btn-block\" value=\"Editar\">\n                                            </div>\n                                        </div>\n\n                                    </form>\n                                </div>\n                            </div>\n                        </div>\n\n                    </div>\n                    ");
		jteOutput.writeContent("\n                </div>\n            </div>\n\n        </div>\n\n    </div>\n</section>\n\n");
		gg.jte.generated.ondemand.partes.includes.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		EmpleadoEntity listarPerfil = (EmpleadoEntity)params.get("listarPerfil");
		render(jteOutput, jteHtmlInterceptor, listarPerfil);
	}
}
