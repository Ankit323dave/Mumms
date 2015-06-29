package com.lister.finaldemo.client;

import com.lister.finaldemo.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Finaldemo implements EntryPoint {
	private DBconnectionAsync rpc;
	private TextBox usernamebox;
	private TextBox passwordbox;
	private Button ok;
	
public Finaldemo(){
	System.out.println("ank6it6666666666666666");
	rpc=(DBconnectionAsync)GWT.create(DBconnection.class);
	ServiceDefTarget target=(ServiceDefTarget) rpc;
	String moduleurl=GWT.getModuleBaseURL()+"MyPostgresConn";
	target.setServiceEntryPoint(moduleurl);
}
	


	@Override
	public void onModuleLoad() {
		System.out.println("1");
		Grid g = new Grid(3, 2);
		 usernamebox = new TextBox();
		 passwordbox = new TextBox();
		 ok = new Button("OK");
		 ok.addStyleName("sendButton");
		 g.setWidget(0, 0, new Label("Username: "));
		 g.setWidget(0, 1, usernamebox);
		 g.setWidget(1, 0, new Label("Password: "));
		 g.setWidget(1, 1, passwordbox);
		 g.setWidget(2, 1, ok);
		 HorizontalPanel addpanel=new HorizontalPanel();
		 //addpanel.add(usernamebox);
		//addpanel.add(passwordbox);
		//addpanel.add(ok);
		addpanel.add(g);
		VerticalPanel mainpanel=new VerticalPanel();
		mainpanel.add(addpanel);
		 RootPanel.get().add(mainpanel);
		 usernamebox.setFocus(true);

			ok.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					AsyncCallback<User> callback = new AsyncCallback<User>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							caught.printStackTrace();
							RootPanel.get().add(new HTML("RPC call failed."));
						}

						@Override
						public void onSuccess(User result) {
							// TODO Auto-generated method stub
							
							RootPanel.get().add(new HTML("Success."));
						}
					};
					
					rpc.authenticateuser(usernamebox.getText(),passwordbox.getText(),callback);
				}
			});
	}

	

	
/*private class AuthenticationHandler<T> implements AsyncCallback<User> {
	public void onFailure(Throwable ex) {
		
		Window.alert("failed");
	}
	public void onSuccess(User result) {
	//do stuff on success with GUI, like load the next GUI element
		
		rpc.authenticateuser(usernamebox.getText(),passwordbox.getText(),callback);
	}
	}*/
		
}
