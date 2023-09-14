package gg.jte.generated.ondemand.partes;
import com.alura.hotelalura.springboottres.controller.responses.LoginResponses;
public final class JteloginGenerated {
	public static final String JTE_NAME = "partes/login.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,6,6,6,13,13,13,13,13,13,13,13,13,18,18,18,18,18,18,18,18,18,21,21,23,23,23,23,23,23,26,26,32,38,44,47,49,49,49,49,49,49,49,49,49,58,58,61};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, LoginResponses loginResponse) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n");
		gg.jte.generated.ondemand.partes.includes.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n<body>\n<section class=\"vh-100\">\n    <div class=\"container py-5 h-100\">\n        <div class=\"row d-flex align-items-center justify-content-center h-100\">\n\n            <div class=\"col-md-8 col-lg-7 col-xl-6\">\n                <img");
		var __jte_html_attribute_0 = loginResponse.img();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" src=\"");
			jteOutput.setContext("img", "src");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("img", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("\n                     class=\"img-fluid\" alt=\"Phone image\"/>\n            </div>\n\n            <div class=\"col-md-7 col-lg-5 col-xl-5 offset-xl-1\">\n                <form");
		var __jte_html_attribute_1 = loginResponse.linkAction();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" action=\"");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("form", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" method=\"post\">\n                  \n                  \n                    ");
		if (loginResponse.responses() != null) {
			jteOutput.writeContent("\n                        <div class=\"alert alert-danger alert-dismissible fade show mt-4\" role=\"alert\">\n                            <strong>Error ");
			jteOutput.setContext("strong", null);
			jteOutput.writeUserContent(loginResponse.responses().erroNumber());
			jteOutput.writeContent(" </strong> ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(loginResponse.responses().message());
			jteOutput.writeContent("\n                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n                        </div>\n                    ");
		}
		jteOutput.writeContent("\n                    \n\n                    <div class=\"divider d-flex align-items-center my-4\">\n                        <p class=\"text-center fw-bold mx-3 mb-0 text-muted\">Login</p>\n                    </div>\n                    ");
		jteOutput.writeContent("\n                    <div class=\"form-outline mb-4\">\n                        <input type=\"text\" id=\"username\"  name=\"username\" class=\"form-control form-control-lg\" required />\n                        <label class=\"form-label\" for=\"username\" >Username</label>\n                    </div>\n\n                    ");
		jteOutput.writeContent("\n                    <div class=\"form-outline mb-4\">\n                        <input type=\"password\" id=\"password\" name=\"password\" class=\"form-control form-control-lg\" required />\n                        <label class=\"form-label\" for=\"password\" >Password</label>\n                    </div>\n\n                    ");
		jteOutput.writeContent("\n                    <div class=\"form-outline mb-4  h-captcha\" data-sitekey=\"fd57c86b-3201-4b83-af0a-12f67c8fe5a1\"></div>\n\n                    ");
		jteOutput.writeContent("\n                    <button type=\"submit\" class=\"btn btn-outline-success btn-lg btn-block mb-2\" style=\"width:100%\">Ingresar</button>\n                    <a");
		var __jte_html_attribute_2 = loginResponse.linkRegistro();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" class=\"btn btn-outline-primary btn-lg btn-block\" style=\"width:100%\">Registar</a>\n\n                </form>\n            </div>\n        </div>\n    </div>\n</section>\n\n\n");
		gg.jte.generated.ondemand.partes.includes.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		LoginResponses loginResponse = (LoginResponses)params.get("loginResponse");
		render(jteOutput, jteHtmlInterceptor, loginResponse);
	}
}
