package fr.uha.hassenforder.logo.ui;

public abstract class AbstractDocument {

	private String filename=null;
	private AbstractView view = null;
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public AbstractView getView() {
		return view;
	}

	public void setView(AbstractView view) {
		this.view = view;
	}

	public void onOpenDocument () {
		updateViews ();
	}

	public void onNewDocument () {
		setFilename (null);
		updateViews ();
	}
	
	public void onSaveDocument() {
		
	}

	public void updateViews () {
		if (view != null) {
			view.invalidate();
			view.repaint();
		}
	}

}
