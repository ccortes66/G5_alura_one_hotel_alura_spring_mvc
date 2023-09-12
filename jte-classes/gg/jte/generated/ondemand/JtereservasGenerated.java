package gg.jte.generated.ondemand;
import com.alura.hotelalura.springboottres.controller.responses.*;
import java.text.DecimalFormat;
public final class JtereservasGenerated {
	public static final String JTE_NAME = "reservas.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,4,4,4,11,11,11,17,17,20,21,23,41,41,42,42,42,42,42,42,42,42,42,42,42,42,43,43,50,50,51,51,51,51,51,51,51,51,51,51,51,51,52,52,64,64,66,66,66,66,66,66,70,70,74,74,74,75,75,75,76,76,76,78,78,78,83,83,91,91,93};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ReservaClienteResponses reservaResponses, ErrorResponses response) {
		jteOutput.writeContent("\n\n\n<!doctype html>\n<html lang=\"en\">\n");
		gg.jte.generated.ondemand.partes.includes.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n<body>\n\n    \n    <section class=\"container-fluid\">\n         <div class=\"row\">\n             ");
		gg.jte.generated.ondemand.partes.includes.JtesiderbarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n             <div class=\"col-sm p-3 min-vh-100\">\n                 ");
		jteOutput.writeContent("\n                 ");
		gg.jte.generated.ondemand.partes.includes.JtetitulosGenerated.render(jteOutput, jteHtmlInterceptor, reservaResponses.username(), "Generar Reservación", "bi-card-list fs-1");
		jteOutput.writeContent("\n\n                 <form action=\"/cliente/generar/reservacion\" method=\"post\">\n                  <div class=\"row g-3\">\n\n                     <div class=\"col-auto\">\n                         <label for=\"checkOut\" class=\"form-label\">Check In</label>\n                         <input type=\"date\" class=\"form-control\" name=\"checkIn\" required  aria-label=\"First name\">\n                     </div>\n\n                     <div class=\"col-auto\">\n                         <label for=\"checkOut\" class=\"form-label\">Check Out</label>\n                         <input type=\"date\" class=\"form-control\" id=\"checkOut\" name=\"checkOut\" required aria-label=\"Last name\">\n                     </div>\n\n                     <div class=\"col-auto\">\n                         <label for=\"categoria\" class=\"form-label\">Categoría</label>\n                         <select class=\"form-select\" id=\"categoria\" name=\"categoria\" aria-label=\"Default select example\" required>\n                             ");
		for (var categoria: reservaResponses.listarCategoria()) {
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
		jteOutput.writeContent("\n                         </select>\n                     </div>\n\n                     <div class=\"col-auto\">\n                         <label for=\"metodoPago\" class=\"form-label\">Método de pago</label>\n                         <select class=\"form-select\" id=\"metodoPago\" name=\"metodoPago\" aria-label=\"Default select example\" required>\n                             ");
		for (var pago: reservaResponses.listaMetodoPago()) {
			jteOutput.writeContent("\n                                     <option");
			var __jte_html_attribute_1 = pago;
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
				jteOutput.writeContent(" value=\"");
				jteOutput.setContext("option", "value");
				jteOutput.writeUserContent(__jte_html_attribute_1);
				jteOutput.setContext("option", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(">");
			jteOutput.setContext("option", null);
			jteOutput.writeUserContent(pago);
			jteOutput.writeContent("</option>\n                              ");
		}
		jteOutput.writeContent("\n                          \n                         </select>\n                     </div>\n\n                      <div class=\"col-auto\">\n\n                          <input class=\"btn btn-outline-primary btn-block \" style=\"margin-top:33%\"  type=\"submit\" value=\"Reservar\">\n                      </div>\n\n                 </div>\n                 </form>\n                 ");
		if (response != null) {
			jteOutput.writeContent("\n                      <div class=\"alert alert-danger alert-dismissible fade show mt-4\" role=\"alert\">\n                             <strong>Error ");
			jteOutput.setContext("strong", null);
			jteOutput.writeUserContent(response.erroNumber());
			jteOutput.writeContent("</strong> ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(response.message());
			jteOutput.writeContent("\n                             <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n                     </div>\n\n                 ");
		} else if (reservaResponses.listarReservacion() != null) {
			jteOutput.writeContent("\n                         <div class=\"alert alert-success alert-dismissible fade show mt-4\" role=\"alert\">\n                             <h4 class=\"alert-heading\">¡La reserva se ha realizado con éxito!</h4>\n                             <p> Esperamos que disfrute de su estancia en el Hotel Alura. Aquí tiene los detalles de su reserva:</p>\n                             <p> ID: ");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(reservaResponses.listarReservacion().reservaId());
			jteOutput.writeContent(" </p>\n                             <p> Precio (en USD):");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(new DecimalFormat("#,###.00").format(reservaResponses.listarReservacion().precio()));
			jteOutput.writeContent(" </p>\n                             <p> Número de habitación: ");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(reservaResponses.listarReservacion().habitacion());
			jteOutput.writeContent("</p>\n                             <hr>\n                             <p class=\"mb-0\">Hotel Alura G5 &copy; ");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(java.time.LocalDate.now().getYear());
			jteOutput.writeContent(".</p>\n                             <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n                         </div>\n                   \n\n                 ");
		}
		jteOutput.writeContent("\n\n\n             </div>\n\n         </div>\n   </section>\n\n");
		gg.jte.generated.ondemand.partes.includes.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		ReservaClienteResponses reservaResponses = (ReservaClienteResponses)params.get("reservaResponses");
		ErrorResponses response = (ErrorResponses)params.get("response");
		render(jteOutput, jteHtmlInterceptor, reservaResponses, response);
	}
}
