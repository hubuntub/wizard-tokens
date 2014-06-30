package com.mycompany.example.client.tokens;

import com.google.gwt.user.client.ui.Button;

public class TokenField extends Button {

	
	public TokenField(String content){
		String html = "<div class='token'><label>" + content + "</label></br></div>";
		setHTML(html);
		setHeight("20px");
	}
}
