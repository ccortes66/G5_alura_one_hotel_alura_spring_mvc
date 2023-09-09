package gg.jte.generated.ondemand.employer;
import com.alura.hotelalura.springboottres.controller.responses.CreacionResponses;
public final class JtepagosGenerated {
	public static final String JTE_NAME = "employer/pagos.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,5,5,5,11,11,14,15,17,30,30,35,35,44,44,46};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CreacionResponses responses) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n");
		gg.jte.generated.ondemand.partes.includes.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n<body>\n\n    \n    <section class=\"container-fluid\">\n         <div class=\"row\">\n             ");
		gg.jte.generated.ondemand.partes.includes.JtesiderbarEmpleadoGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n             <div class=\"col-sm p-3 min-vh-100\">\n                 ");
		jteOutput.writeContent("\n                 ");
		gg.jte.generated.ondemand.partes.includes.JtetitulosGenerated.render(jteOutput, jteHtmlInterceptor, responses.username(), "Generar método de pago", "bi bi-wallet fs-1");
		jteOutput.writeContent("\n\n                 <form action=\"/operacion/generar/pagos\" method=\"post\" class=\"row g-4\" >\n                     <h4 class=\"text-capitalize\">Generar método de pago</h4>\n                     <div class=\"col-auto\">\n                         <label for=\"staticEmail2\">Metodo</label>\n                         <input type=\"text\" required class=\"form-control\" name=\"nombre\" pattern=\"[A-Za-z]+\">\n                     </div>\n                     <div class=\"col-auto\">\n                         <button type=\"submit\" class=\"btn btn-outline-success mt-4\">Agregar</button>\n                     </div>\n                 </form>\n                \n                 ");
		if (responses.confirmaciones()[0]) {
			jteOutput.writeContent("\n                     <div class=\"alert alert-info alert-dismissible fade show mt-4\" role=\"alert\">\n                         <strong>¡Método de pago generado!</strong> Se registran los datos en el sistema\n                         <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n                     </div>\n                 ");
		}
		jteOutput.writeContent("\n                \n\n\n             </div>\n\n         </div>\n   </section>\n\n");
		gg.jte.generated.ondemand.partes.includes.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CreacionResponses responses = (CreacionResponses)params.get("responses");
		render(jteOutput, jteHtmlInterceptor, responses);
	}
}
