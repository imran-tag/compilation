package fr.uha.hassenforder.logo.streaming;

import java.io.File;

import javax.swing.JFileChooser;

import fr.uha.hassenforder.logo.ui.AbstractDocument;

public class Document extends AbstractDocument {

	@Override
	public void onOpenDocument() {
		int state = getView().getJFileChooser().showOpenDialog(getView());
		if (state == JFileChooser.APPROVE_OPTION) {
			File f = getView().getJFileChooser().getSelectedFile();
			setFilename(f.getPath());
		}
		super.onOpenDocument();
	}

}
