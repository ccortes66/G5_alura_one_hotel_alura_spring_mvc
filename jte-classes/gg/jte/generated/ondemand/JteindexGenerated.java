package gg.jte.generated.ondemand;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {1,1,1,1,5,5,5,10,10,14,16,30,51,51,53};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String user) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n");
		gg.jte.generated.ondemand.partes.includes.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n<body>\n\n    <section class=\"container-fluid\">\n         <div class=\"row\">\n             ");
		gg.jte.generated.ondemand.partes.includes.JtesiderbarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n             <div class=\"col-sm p-3 min-vh-100\">\n                 \n                  ");
		gg.jte.generated.ondemand.partes.includes.JtetitulosGenerated.render(jteOutput, jteHtmlInterceptor, user, "Mis reservaciones", "bi-arrow-repeat fs-1");
		jteOutput.writeContent("\n                  \n                 <table class=\"table\">\n                     <thead class=\"thead-dark\">\n                     <tr>\n                         <th scope=\"col\">reserva</th>\n                         <th scope=\"col\">checkIn</th>\n                         <th scope=\"col\">checkOut</th>\n                         <th scope=\"col\">precio</th>\n                         <th scope=\"col\">categoria</th>\n                         <th scope=\"col\">habitacion</th>\n                     </tr>\n                     </thead>\n                     <tbody>\n                     ");
		jteOutput.writeContent("\n                     </tbody>\n                 </table>\n             </div>\n\n         </div>\n   </section>\n\n");
		gg.jte.generated.ondemand.partes.includes.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String user = (String)params.get("user");
		render(jteOutput, jteHtmlInterceptor, user);
	}
}
