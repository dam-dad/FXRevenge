package dad.fxrevenge.informes;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dad.fxrevenge.app.Main;
import dad.fxrevenge.models.Avatar;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GenerarInforme {
	public static void generarPdf() throws JRException, IOException {
		JasperReport report = JasperCompileManager
				.compileReport(Main.class.getResourceAsStream("/reports/InformeAvatar.jrxml"));

		Map<String, Object> parametrers = new HashMap<>();
		parametrers.put("autor", "FXRevenge");

		JasperPrint print = JasperFillManager.fillReport(report, parametrers,
				new JRBeanCollectionDataSource(Avatar.getAvatarList()));

		JasperExportManager.exportReportToPdfFile(print, "informe.pdf");

		Desktop.getDesktop().open(new File("informe.pdf"));

	}

	public static void main(String[] args) throws JRException, IOException {
		generarPdf();
	}
}
