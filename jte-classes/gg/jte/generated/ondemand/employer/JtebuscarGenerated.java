package gg.jte.generated.ondemand.employer;
import com.alura.hotelalura.springboottres.controller.responses.*;
import java.time.LocalDate;;
public final class JtebuscarGenerated {
	public static final String JTE_NAME = "employer/buscar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,4,4,4,9,9,9,15,15,18,19,21,65,65,66,66,68,68,68,69,69,69,70,70,70,71,71,71,72,72,72,73,73,73,75,75,77,77,80,80,81,81,93,119,121,121,123};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuscarResponsesEmpleado buscarResponses) {
		jteOutput.writeContent("\n\n<!doctype html>\n<html lang=\"en\">\n");
		gg.jte.generated.ondemand.partes.includes.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n<body>\n\n    \n    <section class=\"container-fluid\">\n         <div class=\"row\">\n             ");
		gg.jte.generated.ondemand.partes.includes.JtesiderbarEmpleadoGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n             <div class=\"col-sm p-3 min-vh-100\">\n                 ");
		jteOutput.writeContent("\n                 ");
		gg.jte.generated.ondemand.partes.includes.JtetitulosGenerated.render(jteOutput, jteHtmlInterceptor, buscarResponses.username(), "Buscar Reservación", "bi-search fs-1");
		jteOutput.writeContent("\n                 \n\n                  <form id=\"formulario\" action=\"/operacion/buscar/reservacion\" method=\"post\">\n                     <div class=\"row g-3\">\n                         \n                         <div class=\"col-sm-5\">\n                             <label for=\"inputPassword2\" >reservaId</label>\n                             <input type=\"text\" style=\"margin-top:3%; width:100%;\"  class=\"form-control\" id=\"precio\" name=\"reservaId\">\n                         </div>\n\n                         <div class=\"col-auto\">\n                             <label for=\"checkOut\" class=\"form-label\">Check In</label>\n                             <input type=\"date\" style=\"margin-top:3.6%;\" id=\"checkIn\" class=\"form-control\" name=\"fechaInicio\"   aria-label=\"First name\">\n                         </div>\n\n                         \n                         <div class=\"col-auto\">\n\n                             <button class=\"btn btn-outline-primary btn-block \" style=\"margin-top:73%; border-radius: 100%;\"  type=\"submit\">\n                                 <i class=\"bi-search\"></i>\n                             </button>\n                         </div>\n\n                     </div>\n                 </form>\n\n\n\n\n                    <table class=\"table table-hover mt-3\">\n                     <thead >\n                         <tr>\n                             <th scope=\"col\">Reserva</th>\n                             <th scope=\"col\">CheckIn</th>\n                             <th scope=\"col\">CheckOut</th>\n                             <th scope=\"col\">Categoria</th>\n                             <th scope=\"col\">Método de Pago</th>\n                             <th scope=\"col\">Habitación</th>\n                             <th scope=\"col\">Accion</th>\n                         </tr>\n                     </thead>\n                     <tbody>\n                   \n                        ");
		if (buscarResponses.listarCriteria() != null) {
			jteOutput.writeContent("\n                            ");
			for (var busqueda: buscarResponses.listarCriteria() ) {
				jteOutput.writeContent("\n                             <tr class=\"myResult\">\n                                <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.reservaId());
				jteOutput.writeContent("</td>\n                                <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.checkIn());
				jteOutput.writeContent("</td>\n                                <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.checOut());
				jteOutput.writeContent("</td>\n                                <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.categoria());
				jteOutput.writeContent("</td>\n                                <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.metodoDePago());
				jteOutput.writeContent("</td>\n                                <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(busqueda.numeroDeHabitacion().toString());
				jteOutput.writeContent("</td>\n                                <td class=\"text-capitalize\">\n                                    ");
				if (LocalDate.parse(busqueda.checkIn()).isAfter(LocalDate.now().plusDays(1))) {
					jteOutput.writeContent("\n                                    <a  class=\"btn btn-outline-danger btn-block btnEliminar\">Eliminar</a>\n                                    ");
				}
				jteOutput.writeContent("\n                                </td>\n                             </tr>   \n                            ");
			}
			jteOutput.writeContent("\n                        ");
		}
		jteOutput.writeContent("\n\n                     \n                     \n                     </tbody>\n                 </table>\n                \n             </div>\n\n         </div>\n   </section>\n\n    ");
		jteOutput.writeContent("\n    <script>\n        const btnEliminar = document.querySelectorAll(\".btnEliminar\");\n         \n        btnEliminar.forEach((btn,index) =>{\n            btn.addEventListener(\"click\",()=>{\n                Swal.fire({\n                    title: '¿Estás seguro?',\n                    text: \"¡Esta acción no se puede deshacer!\",\n                    icon: 'warning',\n                    showCancelButton: true,\n                    confirmButtonText: 'Sí',\n                    cancelButtonText: 'No',\n                    reverseButtons: false\n                }).then((resultado)=>{\n                    if(resultado.isConfirmed)\n                    { const filas = document.querySelectorAll('.myResult');\n                      window.location.href = \"/operacion/eliminar/reservacion?busqueda=\"+filas[index].getElementsByTagName(\"td\")[0].innerHTML;    \n                    }\n\n                });\n            });\n\n        }); \n        \n    </script>\n    ");
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.partes.includes.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuscarResponsesEmpleado buscarResponses = (BuscarResponsesEmpleado)params.get("buscarResponses");
		render(jteOutput, jteHtmlInterceptor, buscarResponses);
	}
}
