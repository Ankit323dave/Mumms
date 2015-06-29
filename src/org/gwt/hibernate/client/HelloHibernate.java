package org.gwt.hibernate.client;



import org.gwt.hibernate.server.User;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class HelloHibernate implements EntryPoint {
	private UserInterfaceAsync rpc;
	private TextBox usernamebox;
	private TextBox passwordbox;
	private Button ok;
	
	public  HelloHibernate() {
		// TODO Auto-generated constructor stub
		rpc=(UserInterfaceAsync)GWT.create(UserInterface.class);
		ServiceDefTarget target=(ServiceDefTarget) rpc;
		String moduleurl=GWT.getModuleBaseURL()+"MyHBNConn";
		target.setServiceEntryPoint(moduleurl);
	}
	
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
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
		addpanel.add(g);
		VerticalPanel mainpanel=new VerticalPanel();
		mainpanel.add(addpanel);
		 RootPanel.get().add(mainpanel);
		 usernamebox.setFocus(true);
		 
		 ok.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					//User user= new User();
			
					AsyncCallback<UserDTO> callback= new AsyncCallback<UserDTO>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							caught.printStackTrace();
							RootPanel.get().add(new HTML("RPC call failed."));
						}

						@Override
						public void onSuccess(UserDTO result) {
							// TODO Auto-generated method stub
							RootPanel.get().add(new HTML("RPC call Success."));
						}
					};
					rpc.saveuser(1, usernamebox.getText(), passwordbox.getText(), callback);
					
				}
			});
	}

}
