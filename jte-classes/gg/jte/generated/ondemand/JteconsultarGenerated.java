package gg.jte.generated.ondemand;
import com.alura.hotelalura.springboottres.controller.responses.*;
import java.text.DecimalFormat;
public final class JteconsultarGenerated {
	public static final String JTE_NAME = "consultar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,4,4,4,11,11,11,17,17,20,21,23,43,43,44,44,44,44,44,44,44,44,44,44,44,44,45,45,58,58,61,61,61,61,61,61,65,65,78,78,78,79,79,79,80,80,80,81,81,81,88,88,96,96,98};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ReservaResponses reservaResponses, ErrorResponses response) {
		jteOutput.writeContent("\n\n\n<!doctype html>\n<html lang=\"en\">\n");
		gg.jte.generated.ondemand.partes.includes.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n<body>\n\n    \n    <section class=\"container-fluid\">\n         <div class=\"row\">\n             ");
		gg.jte.generated.ondemand.partes.includes.JtesiderbarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n             <div class=\"col-sm p-3 min-vh-100\">\n                 ");
		jteOutput.writeContent("\n              ");
		gg.jte.generated.ondemand.partes.includes.JtetitulosGenerated.render(jteOutput, jteHtmlInterceptor, reservaResponses.username(), "Consultar Precio", "bi-cash-stack fs-1");
		jteOutput.writeContent("\n                  \n\n                                                \n                 <form action=\"/cliente/consultar/reservacion\" method=\"post\">\n                  <div class=\"row g-3\">\n\n                     <div class=\"col-auto\">\n                         <label for=\"checkOut\" class=\"form-label\">Check In</label>\n                         <input type=\"date\" class=\"form-control\" id=\"checkIn\" name=\"checkIn\" required  aria-label=\"First name\">\n                     </div>\n\n                     <div class=\"col-auto\">\n                         <label for=\"checkOut\" class=\"form-label\">Check Out</label>\n                         <input type=\"date\" class=\"form-control\" id=\"checkOut\" name=\"checkOut\" required aria-label=\"Last name\">\n                     </div>\n\n                     <div class=\"col-auto\">\n                         <label for=\"categoria\" class=\"form-label\">Categoría</label>\n                         <select class=\"form-select\" id=\"categoria\" name=\"categoria\" aria-label=\"Default select example\" required>\n                             ");
		for (var categoria: reservaResponses.listarCaregoria()) {
			jteOutput.writeContent("\n                                     <option class=\"text-capitalize\"");
			var __jte_html_attribute_0 = categoria;
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeContent(" value=\"");
				jteOutput.setContext("option", "value");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("option", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(">");
			jteOutput.setContext("option", null);
			jteOutput.writeUserContent(categoria);
			jteOutput.writeContent("</option>\n                             ");
		}
		jteOutput.writeContent("\n                          \n                         </select>\n                     </div>\n\n\n                      <div class=\"col-auto\">\n                          <input class=\"btn btn-outline-success btn-block \" style=\"margin-top:33%\"  type=\"submit\" value=\"Consultar\">\n                      </div>\n\n                 </div>\n                 </form>\n                 \n                 ");
		if (response != null) {
			jteOutput.writeContent("\n\n                     <div class=\"alert alert-danger alert-dismissible fade show mt-4\" role=\"alert\">\n                             <strong>Error ");
			jteOutput.setContext("strong", null);
			jteOutput.writeUserContent(response.erroNumber());
			jteOutput.writeContent("</strong> ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(response.message());
			jteOutput.writeContent("\n                             <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n                     </div>\n\n                 ");
		} else if (reservaResponses.consultaResponses() != null) {
			jteOutput.writeContent("\n\n                     <div class=\"card mb-3 mt-4\" style=\"max-width: 540px;\">\n                         <div class=\"row g-0\">\n                             <div class=\"col-md-4\">\n                                 <img src=\"https://i.ibb.co/vVhTHRy/logo.png\" class=\"img-fluid rounded-start\" alt=\"...\">\n                             </div>\n                             <div class=\"col-md-8\">\n                                 <div class=\"card-body\">\n                                     <h5 class=\"card-title\">Consultar Precio</h5>\n                                     <p class=\"card-text\">Cálculo del costo según la duración de la estadía .</p>\n\n                                    <ul class=\"list-unstyled\">\n                                        <li id=\"myInicio\" class=\"card-text\">Check In:");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(String.valueOf(reservaResponses.consultaResponses().checkIn()));
			jteOutput.writeContent("</li>\n                                        <li id=\"myFin\" class=\"card-text\">Check Out:");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(String.valueOf(reservaResponses.consultaResponses().checkOut()));
			jteOutput.writeContent(" </li>\n                                        <li id=\"myCategoria\" class=\"card-text\">Categoria: ");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(reservaResponses.consultaResponses().categoria());
			jteOutput.writeContent("</li>\n                                        <li class=\" card-text\">Precio(USD) $");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(new DecimalFormat("#,###.00").format(reservaResponses.consultaResponses().precio()));
			jteOutput.writeContent("</li>\n                                     </ul>\n\n                                 </div>\n                             </div>\n                         </div>\n                     </div>\n                 ");
		}
		jteOutput.writeContent("\n             \n             </div>\n\n         </div>\n   </section>\n\n\n");
		gg.jte.generated.ondemand.partes.includes.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		ReservaResponses reservaResponses = (ReservaResponses)params.get("reservaResponses");
		ErrorResponses response = (ErrorResponses)params.get("response");
		render(jteOutput, jteHtmlInterceptor, reservaResponses, response);
	}
}
