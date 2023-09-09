package gg.jte.generated.ondemand;
import com.alura.hotelalura.springboottres.controller.responses.LoginResponses;
public final class JteloginGenerated {
	public static final String JTE_NAME = "login.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, LoginResponses loginResponse) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.partes.JteloginGenerated.render(jteOutput, jteHtmlInterceptor, loginResponse);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		LoginResponses loginResponse = (LoginResponses)params.get("loginResponse");
		render(jteOutput, jteHtmlInterceptor, loginResponse);
	}
}
