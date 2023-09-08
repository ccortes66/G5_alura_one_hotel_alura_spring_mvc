package gg.jte.generated.ondemand.employer;
public final class JteindexGenerated {
	public static final String JTE_NAME = "employer/index.jte";
	public static final int[] JTE_LINE_INFO = {1,1,1,1,5,5,5,10,10,13,15,29,69,69,71};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String user) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n");
		gg.jte.generated.ondemand.partes.includes.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n<body>\n\n<section class=\"container-fluid\">\n    <div class=\"row\">\n        ");
		gg.jte.generated.ondemand.partes.includes.JtesiderbarEmpleadoGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n        <div class=\"col-sm p-3 min-vh-100\">\n          ");
		gg.jte.generated.ondemand.partes.includes.JtetitulosGenerated.render(jteOutput, jteHtmlInterceptor, user, "reservaciones", "bi-arrow-repeat fs-1");
		jteOutput.writeContent("\n\n           \n            <form action=\"/busqueda\" method=\"get\">\n                <p class=\"text-capitalize\">buscar</p>\n                <div class=\"input-group\">\n                    <div class=\"form-outline\">\n                        <input type=\"number\" id=\"form1\" name=\"buscar\" class=\"form-control\" />\n                    </div>\n                    <button type=\"submit\"  class=\"btn btn-primary\">\n                        <i class=\"fas fa-search\"></i>\n                    </button>\n                </div>\n            </form>\n           ");
		jteOutput.writeContent("\n        </div>\n\n    </div>\n</section>\n\n");
		gg.jte.generated.ondemand.partes.includes.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String user = (String)params.get("user");
		render(jteOutput, jteHtmlInterceptor, user);
	}
}
