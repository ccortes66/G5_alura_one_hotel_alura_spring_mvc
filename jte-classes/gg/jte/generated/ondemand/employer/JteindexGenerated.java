package gg.jte.generated.ondemand.employer;
import com.alura.hotelalura.springboottres.controller.responses.*;
public final class JteindexGenerated {
	public static final String JTE_NAME = "employer/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,4,4,4,8,8,8,13,13,16,18,32,32,33,33,33,33,33,33,33,34,34,46,46,46,66,66,68,68,70,70,70,71,71,71,72,72,72,73,73,73,74,74,74,75,75,75,77,77,79,79,97,97,99};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuscarResponses buscarResponses) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n");
		gg.jte.generated.ondemand.partes.includes.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n<body>\n\n<section class=\"container-fluid\">\n    <div class=\"row\">\n        ");
		gg.jte.generated.ondemand.partes.includes.JtesiderbarEmpleadoGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n        <div class=\"col-sm p-3 min-vh-100\">\n          ");
		gg.jte.generated.ondemand.partes.includes.JtetitulosGenerated.render(jteOutput, jteHtmlInterceptor, buscarResponses.username(), "reservaciones Actuales", "bi-arrow-repeat fs-1");
		jteOutput.writeContent("\n\n            <div class=\"d-flex justify-content-between \">\n\n               <div>\n                   <p class=\"text-capitalize\">buscar</p>\n                   <nav aria-label=\"Page navigation example\" >\n                   <ul class=\"pagination\">\n                    <li class=\"page-item\">\n                    <a class=\"page-link\" href=\"#\" aria-label=\"Previous\">\n                        <span aria-hidden=\"true\">&laquo;</span>\n                    </a>\n                    </li>\n                    \n                    ");
		for (int i = 0; i<(buscarResponses.listarCriteria().getTotalElements()/10)+1; i++ ) {
			jteOutput.writeContent("\n                        <li class=\"page-item\"><a class=\"page-link\" href=\"/operacion?pagina=");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(i);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\">");
			jteOutput.setContext("a", null);
			jteOutput.writeUserContent(i+1);
			jteOutput.writeContent("</a></li>\n                    ");
		}
		jteOutput.writeContent("  \n                    \n                    <li class=\"page-item\">\n                    <a class=\"page-link\" href=\"#\" aria-label=\"Next\">\n                        <span aria-hidden=\"true\">&raquo;</span>\n                    </a>\n                    </li>\n                </ul>\n                </nav>\n             </div>    \n                \n                 <div>\n                   <p class=\"text-capitalize\">Total ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(buscarResponses.listarCriteria().getTotalElements());
		jteOutput.writeContent(" </p>\n                 </div>\n\n             </div>  \n          \n           \n\n            <table class=\"table table-hover mt-3\">\n                <thead >\n                <tr>\n                    <th scope=\"col\">Reserva</th>\n                    <th scope=\"col\">CheckIn</th>\n                    <th scope=\"col\">CheckOut</th>\n                    <th scope=\"col\">Categoria</th>\n                    <th scope=\"col\">Método de Pago</th>\n                    <th scope=\"col\">Habitación</th>\n                </tr>\n                </thead>\n                <tbody>\n               \n                      ");
		if (buscarResponses.listarCriteria().getContent() != null) {
			jteOutput.writeContent("\n\n                           ");
			for (var busqueda: buscarResponses.listarCriteria().getContent() ) {
				jteOutput.writeContent("\n                            <tr>\n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.reservaId());
				jteOutput.writeContent("</td>\n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.checkIn());
				jteOutput.writeContent("</td>\n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.checOut());
				jteOutput.writeContent("</td>\n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.categoria());
				jteOutput.writeContent("</td>\n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.metodoDePago());
				jteOutput.writeContent("</td>\n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.numeroDeHabitacion().toString());
				jteOutput.writeContent("</td>\n                            </tr>\n                           ");
			}
			jteOutput.writeContent("\n\n                         ");
		}
		jteOutput.writeContent("\n                \n               \n                </tbody>\n            </table>\n        </div>\n    \n      \n\n    </div>\n\n     \n\n</section>\n\n  \n        \n\n");
		gg.jte.generated.ondemand.partes.includes.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuscarResponses buscarResponses = (BuscarResponses)params.get("buscarResponses");
		render(jteOutput, jteHtmlInterceptor, buscarResponses);
	}
}
