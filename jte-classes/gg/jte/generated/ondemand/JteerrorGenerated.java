package gg.jte.generated.ondemand;
public final class JteerrorGenerated {
	public static final String JTE_NAME = "error.jte";
	public static final int[] JTE_LINE_INFO = {18,18,18,18,18,18};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<!DOCTYPE html>\n<html lang=\"en\">\n\n  <head>\n    <meta charset=\"UTF-8\" />\n    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n    <title>Bootstrap 5 404 Error Page</title>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n  </head>\n\n  <body>\n    <div class=\"d-flex flex-column align-items-center justify-content-center vh-100 bg-primary\">\n        <h1 class=\"display-1 fw-bold text-white\">404</h1>\n        <h2 class=\"display-1 fw-bold text-white\">Pagina No encontrada</h2>\n    </div>\n  </body>\n\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
