package com.imatia.jee.bankmanager.client;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ontimize.gui.Form;
import com.ontimize.gui.images.ImageManager;
import com.ontimize.gui.preferences.BasicApplicationPreferences;
import com.ontimize.gui.table.Table;
import com.ontimize.jee.common.hessian.OntimizeHessianHttpClientSessionProcessorFactory;
import com.ontimize.jee.desktopclient.builder.MultiModuleApplicationLauncher;
import com.ontimize.report.ReportManager;
import com.ontimize.report.engine.dynamicjasper.DynamicJasperEngine;
import com.ontimize.util.math.MathExpressionParser;
import com.ontimize.util.math.MathExpressionParserFactory;
import com.ontimize.util.xls.XLSExporterFactory;
import com.ontimize.xml.DefaultXMLParametersManager;

public class ClientLauncher {
	private static final Logger logger = LoggerFactory.getLogger(ClientLauncher.class);

	private ClientLauncher() {
		super();
	}

	public static void main(String[] args) {
		DefaultXMLParametersManager.setXMLDefaultParameterFile("ontimize-configuration-parameters-static-values.xml");
		DefaultXMLParametersManager.setXMLDefaultParameterFile("ontimize-configuration-parameters-ui.xml");
		OntimizeHessianHttpClientSessionProcessorFactory.ENCRYPT = false;
		System.setProperty(MathExpressionParserFactory.MATH_EXPRESSION_PARSER_PROPERTY, MathExpressionParser.MESP);
//		Table.XLS_EXPORT_CLASS = XLSExporterFactory.POI_3_5;
		Table.rendererEditorConfigurationFile = "forms/conf/table_render_editor_config.xml";
		ImageManager.addBaseImagePath("com/imatia/jee/bankmanager/images");
//		Form.DEFAULT_DATABASE_BUNDLE = true;
//		BasicApplicationPreferences.remoteUserPreferences = true;
//		BasicApplicationPreferences.checkOldPreferences = false;

		new MultiModuleApplicationLauncher() {
			@Override
			protected void doInCreationThread(String labelsPath, String clientApplicationPath, String[] springConfigurationFiles, String[] args) {
				LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
				super.doInCreationThread(labelsPath, clientApplicationPath, springConfigurationFiles, args);
				// hay que configurarlo despues de que se inicialice el beans
				// factory
				// ((DmsTransfererManagerDefault)
				// DmsTransfererManagerFactory.getInstance()).setSyncFolder(new
				// File(Utils.getAppWorkDirectory(), "DMS"));
			};
		}.launch(args);
	}

	public static void checkLibraries() {
		new Thread("Check Libraries") {
			@Override
			public void run() {
				super.run();
				try {
					// com.ontimize.report.ReportManager.createReportEngine();
					// Ontimize lanza esto en un hilo y me impide cambiarlo, de
					// ahi el sleep
					Thread.sleep(4000);
					ReportManager.registerNewReportEngine(new DynamicJasperEngine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
