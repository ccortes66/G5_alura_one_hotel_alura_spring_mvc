package gg.jte.generated.ondemand;
import com.alura.hotelalura.springboottres.controller.responses.*;
import java.text.DecimalFormat;
public final class JtebuscarGenerated {
	public static final String JTE_NAME = "buscar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,4,4,4,11,11,11,17,17,20,21,23,37,37,38,38,38,38,38,38,38,38,38,38,38,38,39,39,72,72,74,74,76,76,76,77,77,77,78,78,78,79,79,79,80,80,80,81,81,81,83,83,84,84,95,128,130,130,132};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuscarResponses buscarResponses) {
		jteOutput.writeContent("\n\n\n\n<!doctype html>\n<html lang=\"en\">\n");
		gg.jte.generated.ondemand.partes.includes.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n<body>\n\n    \n    <section class=\"container-fluid\">\n         <div class=\"row\">\n             ");
		gg.jte.generated.ondemand.partes.includes.JtesiderbarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n             <div class=\"col-sm p-3 min-vh-100\">\n                 ");
		jteOutput.writeContent("\n                 ");
		gg.jte.generated.ondemand.partes.includes.JtetitulosGenerated.render(jteOutput, jteHtmlInterceptor, buscarResponses.username(), "Buscar Reservación", "bi-search fs-1");
		jteOutput.writeContent("\n\n                 <form id=\"formulario\" action=\"/cliente/buscar/reservacion\" method=\"post\">\n                     <div class=\"row g-3\">\n\n                         <div class=\"col-auto\">\n                             <label for=\"checkOut\" class=\"form-label\">Check In</label>\n                             <input type=\"date\" id=\"checkIn\" class=\"form-control\" name=\"checkIn\"   aria-label=\"First name\">\n                         </div>\n\n                         <div class=\"col-auto\">\n                             <label for=\"categoria\" class=\"form-label\">Categoría</label>\n                             <select class=\"form-select\" id=\"categoria\" name=\"categoria\" aria-label=\"Default select example\" >\n\n                                 ");
		for (var categoria: buscarResponses.listarCategoria()) {
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
			jteOutput.writeContent("</option>\n                                 ");
		}
		jteOutput.writeContent("\n\n                             </select>\n                         </div>\n\n                         <div class=\"col-auto\">\n                             <label for=\"inputPassword2\" >Precio</label>\n                             <input type=\"text\" style=\"margin-top:3%\"  class=\"form-control\" id=\"precio\" name=\"precioUnitario\" pattern=\"[0-9]*\\.?[0-9]+\">\n                         </div>\n\n                         <div class=\"col-auto\">\n\n                             <button class=\"btn btn-outline-primary btn-block \" style=\"margin-top:73%\"  type=\"submit\">\n                                 <i class=\"bi-search\"></i>\n                             </button>\n                         </div>\n\n                     </div>\n                 </form>\n\n\n                    <table class=\"table table-hover mt-3\">\n                     <thead >\n                         <tr>\n                             <th scope=\"col\">reserva</th>\n                             <th scope=\"col\">checkIn</th>\n                             <th scope=\"col\">checkOut</th>\n                             <th scope=\"col\">precio</th>\n                             <th scope=\"col\">categoria</th>\n                             <th scope=\"col\">habitacion</th>\n                         </tr>\n                     </thead>\n                     <tbody>\n                         ");
		if (buscarResponses.listarCriteria() != null) {
			jteOutput.writeContent("\n\n                           ");
			for (var busqueda: buscarResponses.listarCriteria() ) {
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
				jteOutput.writeUserContent(new DecimalFormat("#,###.00").format(busqueda.precio()));
				jteOutput.writeContent("</td>\n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.categoria());
				jteOutput.writeContent("</td>\n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.numeroDeHabitacion().toString());
				jteOutput.writeContent("</td>\n                            </tr>\n                           ");
			}
			jteOutput.writeContent("\n                         ");
		}
		jteOutput.writeContent("\n\n                     </tbody>\n                 </table>\n\n\n             </div>\n\n         </div>\n   </section>\n\n    ");
		jteOutput.writeContent("\n     <script>\n        \n         document.querySelector('#formulario').addEventListener('submit',event => {\n            event.preventDefault();\n\n            let fecha = document.querySelector('#checkIn').value;\n            let categoria = document.querySelector('#categoria').value\n            let precio = document.querySelector('#precio').value\n            localStorage.setItem('fecha',fecha)\n            localStorage.setItem('categoria',categoria)\n            localStorage.setItem('precio',precio)\n\n            event.target.submit();\n         });\n\n         document.addEventListener('DOMContentLoaded', () => {\n         let fechaGuardada = localStorage.getItem('fecha');\n         let categoriaGuardada = localStorage.getItem('categoria');\n         let precioGuardado = localStorage.getItem('precio');\n\n          if (fechaGuardada)\n             {document.querySelector('#checkIn').value = fechaGuardada;}\n\n          if (categoriaGuardada)\n             {document.querySelector('#categoria').value = categoriaGuardada;}\n\n          if (precioGuardado)\n             {document.querySelector('#precio').value = precioGuardado;}\n        });\n\n\n    </script>\n    ");
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.partes.includes.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n</body>\n</html>>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuscarResponses buscarResponses = (BuscarResponses)params.get("buscarResponses");
		render(jteOutput, jteHtmlInterceptor, buscarResponses);
	}
}
