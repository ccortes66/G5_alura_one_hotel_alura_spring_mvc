package gg.jte.generated.ondemand;
import com.alura.hotelalura.springboottres.controller.responses.ListarReservacionResponses;
import java.text.DecimalFormat;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,7,7,7,12,12,16,18,33,33,34,34,36,36,36,37,37,37,38,38,38,39,39,39,40,40,40,41,41,41,43,43,44,44,53,53,55};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ListarReservacionResponses resultadoLista) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n");
		gg.jte.generated.ondemand.partes.includes.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n<body>\n\n    <section class=\"container-fluid\">\n         <div class=\"row\">\n             ");
		gg.jte.generated.ondemand.partes.includes.JtesiderbarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n             <div class=\"col-sm p-3 min-vh-100\">\n                 \n                  ");
		gg.jte.generated.ondemand.partes.includes.JtetitulosGenerated.render(jteOutput, jteHtmlInterceptor, resultadoLista.username(), "Mis reservaciones", "bi-arrow-repeat fs-1");
		jteOutput.writeContent("\n                  \n                 <table class=\"table\">\n                     <thead class=\"thead-dark\">\n                     <tr>\n                         <th scope=\"col\">reserva</th>\n                         <th scope=\"col\">checkIn</th>\n                         <th scope=\"col\">checkOut</th>\n                         <th scope=\"col\">precio</th>\n                         <th scope=\"col\">categoria</th>\n                         <th scope=\"col\">habitacion</th>\n                     </tr>\n                     </thead>\n                     <tbody>\n                     \n                     ");
		if (resultadoLista.listarReservacion() != null) {
			jteOutput.writeContent("\n                         ");
			for (var reservaInfo: resultadoLista.listarReservacion()) {
				jteOutput.writeContent("\n                             <tr>\n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(reservaInfo.getReservaId());
				jteOutput.writeContent("</td>\n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(String.valueOf(reservaInfo.getCheckIn()));
				jteOutput.writeContent("</td>\n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(String.valueOf(reservaInfo.getCheckOut()));
				jteOutput.writeContent("</td>\n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(new DecimalFormat("#,###.00").format(reservaInfo.getPrecioHabitacion()));
				jteOutput.writeContent("</td> \n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(reservaInfo.getCategoria());
				jteOutput.writeContent("</td>\n                                 <td class=\"text-capitalize\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(reservaInfo.getNumeroHabitacion().toString());
				jteOutput.writeContent("</td>\n                             </tr>\n                         ");
			}
			jteOutput.writeContent("\n                     ");
		}
		jteOutput.writeContent("\n                     \n                     </tbody>\n                 </table>\n             </div>\n\n         </div>\n   </section>\n\n");
		gg.jte.generated.ondemand.partes.includes.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		ListarReservacionResponses resultadoLista = (ListarReservacionResponses)params.get("resultadoLista");
		render(jteOutput, jteHtmlInterceptor, resultadoLista);
	}
}
